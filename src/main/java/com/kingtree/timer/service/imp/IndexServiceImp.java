package com.kingtree.timer.service.imp;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.kingtree.timer.entity.TaHouse;
import com.kingtree.timer.service.IndexService;
import com.kingtree.timer.service.KingtreeTaHouseService;
import com.kingtree.timer.service.TaDepartmentService;
import com.kingtree.timer.service.TaEmployeeService;
import com.kingtree.timer.service.TaEstateService;
import com.kingtree.timer.service.TaPiceareaService;
import com.kingtree.timer.service.exception.IndexException;
import com.kingtree.timer.service.vo.IndexicalHouseVO;
import com.kingtree.timer.service.vo.TaDepartmentVO;
import com.kingtree.timer.service.vo.TaEmployeeVO;
import com.kingtree.timer.service.vo.TaEstateVO;
import com.kingtree.timer.service.vo.TaHouseVO;
import com.kingtree.timer.util.ContextFileUtil;
import com.kingtree.timer.util.KingtreeIkAnalyzer;
import com.kingtree.timer.util.PageUtil;

@Service
public class IndexServiceImp implements IndexService {

	@Resource
	private KingtreeTaHouseService kingtreeTaHouseService;
	@Resource
	private TaEstateService taEstateService;
	@Resource
	private TaEmployeeService taEmployeeService;
	@Resource
	private TaPiceareaService taPiceareaService;
	@Resource
	private TaDepartmentService taDepartmentService;

	private final static int PAGE_SIZE = 100;

	private final static String INDEX_PATH = "index";

	@Override
	public void createIndex(Timestamp updateTime) throws IndexException {
		if (updateTime == null) {
			return;
		}

		deleteIndexAll();

		for (int page = 0;; page++) {
			List<TaHouse> houses = kingtreeTaHouseService.get(updateTime, PageUtil.getStart(page, PAGE_SIZE),
					PageUtil.getEnd(page, PAGE_SIZE));
			if (houses == null || houses.isEmpty()) {
				break;
			}
			List<IndexicalHouseVO> houseList = get(houses);
			createIndex(houseList);
		}
	}

	private void deleteIndexAll() {
		try {
			IndexWriter indexWriter = getIndexWriter();
			indexWriter.deleteAll();
			indexWriter.forceMergeDeletes();
			indexWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	private List<IndexicalHouseVO> get(List<TaHouse> houses) {
		List<IndexicalHouseVO> houseVOs = new ArrayList<IndexicalHouseVO>();
		for (TaHouse item : houses) {
			houseVOs.add(get(item));
		}
		return houseVOs;
	}

	private IndexicalHouseVO get(TaHouse house) {
		IndexicalHouseVO indexicalHouseVO = new IndexicalHouseVO();
		TaHouseVO taHouseVO = kingtreeTaHouseService.get(house.getHouseid());
		if (taHouseVO == null) {
			return null;
		}
		indexicalHouseVO.setHouseId(taHouseVO.getHouseid());
		indexicalHouseVO.setHouseDesc(taHouseVO.getPropdesc());
		indexicalHouseVO.setHousePrice(taHouseVO.getSellPrice() + "");
		indexicalHouseVO.setHostName(taHouseVO.getHouseOwnerName());
		indexicalHouseVO.setHostTel(taHouseVO.getHouseOwnerTel());
		indexicalHouseVO.setBrokerName(house.getGsempname());
		indexicalHouseVO.setHouseName(taHouseVO.getTitle());
		TaEmployeeVO taEmployeeVO = taEmployeeService.get(house.getGsempid());
		if (taEmployeeVO != null) {
			indexicalHouseVO.setBrokerName(taEmployeeVO.getUserName());
			indexicalHouseVO.setBrokerTel(taEmployeeVO.getMobile());
			List<TaDepartmentVO> depts = taDepartmentService.gets(taEmployeeVO.getDeptid());
			if (depts != null) {
				String deptsName = "";
				for (TaDepartmentVO item : depts) {
					deptsName += item.getDepname() + ",";
				}
				indexicalHouseVO.setBlock(deptsName);
			}
		}
		TaEstateVO taEstateVO = taEstateService.get(taHouseVO.getEstid());
		if (taEstateVO != null) {
			indexicalHouseVO.setHouseAddress(taEstateVO.getAddress());
			indexicalHouseVO.setCommunityDesc(taEstateVO.getDescription());
			indexicalHouseVO.setCommunityName(taEstateVO.getEstatename());
		}
		return indexicalHouseVO;
	}

	@Override
	public void updateIndex(Timestamp updateTime) throws IndexException {
		if (updateTime == null) {
			return;
		}

		for (int page = 0;; page++) {
			List<TaHouse> houses = kingtreeTaHouseService.get(updateTime, PageUtil.getStart(page, PAGE_SIZE),
					PageUtil.getEnd(page, PAGE_SIZE));
			if (houses == null || houses.isEmpty()) {
				break;
			}
			try {
				updateIndex(houses);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateIndex(List<TaHouse> houseList) throws IOException {
		IndexWriter indexWriter = getIndexWriter();

		delete(indexWriter, houseList);

		List<IndexicalHouseVO> indexicalHouses = new ArrayList<IndexicalHouseVO>();
		for (TaHouse house : houseList) {
			indexicalHouses.add(get(house));
		}
		createIndex(indexicalHouses);
	}

	private void delete(IndexWriter indexWriter, List<TaHouse> houseList) throws IOException {
		Term[] terms = new Term[houseList.size()];
		for (int i = 0; i < houseList.size(); i++) {
			terms[i] = new Term("houseId", houseList.get(i).getHouseid());
		}
		indexWriter.deleteDocuments(terms);
		indexWriter.forceMergeDeletes();
	}

	private IndexWriter getIndexWriter() throws IOException {
		IndexWriterConfig iwc = new IndexWriterConfig(new KingtreeIkAnalyzer());
		IndexWriter writer = new IndexWriter(FSDirectory.open(Paths.get(ContextFileUtil.getSysDirectory(INDEX_PATH).toString())), iwc);
		return writer;
	}
}
