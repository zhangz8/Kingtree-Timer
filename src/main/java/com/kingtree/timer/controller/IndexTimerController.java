package com.kingtree.timer.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingtree.timer.entity.KingtreeConfig;
import com.kingtree.timer.service.IndexService;
import com.kingtree.timer.service.KingtreeConfigService;
import com.kingtree.timer.service.KingtreeTaHouseService;
import com.kingtree.timer.service.exception.IndexException;
import com.kingtree.timer.service.vo.IndexicalHouseVO;
import com.kingtree.timer.thread.IndexDataProviderThread;
import com.kingtree.timer.thread.IndexWriterThread;
import com.kingtree.timer.util.PageUtil;

@Controller
@RequestMapping("/index_timer")
public class IndexTimerController {

	@Resource
	private IndexService indexService;
	@Resource
	private KingtreeConfigService kingtreeConfigService;
	@Resource
	private KingtreeTaHouseService kingtreeTaHouseService;
	private static final String INDEX_UPDATE_TIME = "INDEX_UPDATE_TIME";

	private static Logger logger = LoggerFactory.getLogger(IndexTimerController.class);

	@ResponseBody
	@Scheduled(cron = "0 0 4 * * *")
	@RequestMapping(value = "/house/index_all", method = { RequestMethod.GET, RequestMethod.POST })
	public void indexAll() {
		List<KingtreeConfig> configs = kingtreeConfigService.gets(INDEX_UPDATE_TIME);
		if (configs.isEmpty()) {
			return;
		}
		KingtreeConfig config = configs.get(0);

		try {
			if (!isDailyInit(config)) {
				indexService.createIndex(new Timestamp(0));
			}
		} catch (IndexException e) {
			logger.error("日初始化索引失败");
		}

		config.setValue(new Timestamp(System.currentTimeMillis()).toString());
		kingtreeConfigService.modify(config);
	}

	@ResponseBody
	// @Scheduled(cron = "0 */3 * * * *")
	@RequestMapping(value = "/house/index", method = { RequestMethod.GET, RequestMethod.POST })
	public void index() {
		List<KingtreeConfig> configs = kingtreeConfigService.get(INDEX_UPDATE_TIME);
		if (configs.isEmpty()) {
			return;
		}
		KingtreeConfig config = configs.get(0);
		if (StringUtils.isNotBlank(config.getValue())) {
			Timestamp updateTime = null;
			try {
				updateTime = Timestamp.valueOf(config.getValue());
			} catch (Exception e) {
				logger.info("上次更新索引的时间格式不正确");
			}
			if (isDailyInit(config)) {
				try {
					indexService.updateIndex(updateTime);
				} catch (IndexException e) {
					logger.error("更新索引失败");
				}
				config.setValue(new Timestamp(System.currentTimeMillis()).toString());
				kingtreeConfigService.modify(config);
			}
		} else {
			logger.error("上次更新索引的时间为空");
		}
	}

	private boolean isDailyInit(KingtreeConfig config) {
		String dateStr = config.getValue().substring(0, 10);
		String currentDateStr = new Timestamp(System.currentTimeMillis()).toString().substring(0, 10);
		return dateStr.equals(currentDateStr);
	}

	@ResponseBody
	@Scheduled(cron = "0 0 4 * * *")
	@RequestMapping(value = "/house/indexMultiThread", method = { RequestMethod.GET, RequestMethod.POST })
	public void indexMultiThread() {
		int page = 0;
		int totalPage = 0;
		int pageSize = 100;
		long start = System.currentTimeMillis();
		BlockingQueue<List<IndexicalHouseVO>> queue = new LinkedBlockingQueue<List<IndexicalHouseVO>>(20);
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		int total = kingtreeTaHouseService.count();
		totalPage = PageUtil.getTotalPage(pageSize, total);

		logger.info("线程池启动中...");
		logger.info("totalPage:" + totalPage + ",totalRecord:" + total + ",pageSize:" + pageSize);

		IndexWriterThread indexWriterThread = new IndexWriterThread(queue);
		Thread indexWriThread = new Thread(indexWriterThread, "indexWriThread");
		indexWriThread.start();// 索引写线程启动

		for (; page < totalPage; page++) {
			threadPool.execute(new IndexDataProviderThread(page, pageSize, queue, kingtreeTaHouseService));
		}
		threadPool.shutdown();// 结束线程池

		while (!threadPool.isTerminated()) {// 调用反馈，为了给浏览器一个执行状态，其实没什么用
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		logger.info("线程池执行结束，耗时：" + ((System.currentTimeMillis() - start) / 1000) + "秒");
	}
}
