package com.kingtree.timer.thread;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.kingtree.timer.service.vo.IndexicalHouseVO;
import com.kingtree.timer.util.ContextFileUtil;
import com.kingtree.timer.util.KingtreeIkAnalyzer;

public class IndexWriterThread implements Runnable {

	private BlockingQueue<List<IndexicalHouseVO>> queue;
	private final static String INDEX_PATH = ContextFileUtil.getSysDirectory("index").toString();
	private static Logger LOGGER = LoggerFactory.getLogger(IndexWriterThread.class);

	public IndexWriterThread(BlockingQueue<List<IndexicalHouseVO>> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		int page = 0;
		List<IndexicalHouseVO> houses = null;
		while (true) {
			try {
				houses = queue.take();
				LOGGER.error("缓冲区获取数据take,page:" + page + ",pageSize:" + houses.size());
			} catch (InterruptedException e1) {
				LOGGER.error("缓冲区获取数据失败", e1);
			}
			if (houses != null && !houses.isEmpty()) {
				createIndex(houses);
				LOGGER.info("索引写入页：" + page);
				page++;
			}
		}
	}

	private IndexWriter getIndexWriter() throws IOException {
		IndexWriterConfig iwc = new IndexWriterConfig(new KingtreeIkAnalyzer());
		IndexWriter writer = new IndexWriter(FSDirectory.open(Paths.get(INDEX_PATH)), iwc);
		return writer;
	}

	private void createIndex(List<IndexicalHouseVO> houseList) {
		try {
			IndexWriter indexWriter = getIndexWriter();
			for (IndexicalHouseVO item : houseList) {
				Document doc = new Document();
				doc.add(new TextField("houseId", StringUtils.isBlank(item.getHouseId()) ? "" : item.getHouseId(), Field.Store.YES));
				doc.add(new TextField("block", StringUtils.isBlank(item.getBlock()) ? "" : item.getBlock(), Field.Store.YES));
				doc.add(new StringField("brokerName", StringUtils.isBlank(item.getBrokerName()) ? "" : item.getBrokerName(),
						Field.Store.YES));
				doc.add(new StringField("brokerTel", StringUtils.isBlank(item.getBrokerTel()) ? "" : item.getBrokerTel(), Field.Store.YES));
				doc.add(new TextField("communityDesc", StringUtils.isBlank(item.getCommunityDesc()) ? "" : item.getCommunityDesc(),
						Field.Store.YES));
				doc.add(new TextField("communityName", StringUtils.isBlank(item.getCommunityName()) ? "" : item.getCommunityName(),
						Field.Store.YES));
				doc.add(new StringField("hostName", StringUtils.isBlank(item.getHostName()) ? "" : item.getHostName(), Field.Store.YES));
				doc.add(new StringField("hostTel", StringUtils.isBlank(item.getHostTel()) ? "" : item.getHostTel(), Field.Store.YES));
				doc.add(new TextField("houseAddress", StringUtils.isBlank(item.getHouseAddress()) ? "" : item.getHouseAddress(),
						Field.Store.YES));
				doc.add(new TextField("houseDesc", StringUtils.isBlank(item.getHouseDesc()) ? "" : item.getHouseDesc(), Field.Store.YES));
				doc.add(new TextField("houseName", StringUtils.isBlank(item.getHouseName()) ? "" : item.getHouseName(), Field.Store.YES));
				doc.add(new StringField("housePrice", StringUtils.isBlank(item.getHousePrice()) ? "" : item.getHousePrice(),
						Field.Store.YES));
				doc.add(new TextField("content", JSON.toJSONString(item), Field.Store.YES));
				indexWriter.addDocument(doc);
			}
			indexWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
