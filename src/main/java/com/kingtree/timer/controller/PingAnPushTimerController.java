package com.kingtree.timer.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingtree.timer.manager.HouseManager;
import com.kingtree.timer.manager.bo.HouseBO;
import com.kingtree.timer.util.PageUtil;

/**
 * 21世纪房网定时任务
 * 
 * @author youchuan
 */
@Controller
@RequestMapping("/pingan_push_timer")
public class PingAnPushTimerController {

	private static Logger logger = LoggerFactory.getLogger(PingAnPushTimerController.class);
	private static SimpleDateFormat sdft = new SimpleDateFormat("yyyyMMdd");

	@Resource
	private HouseManager houseManager;

	@ResponseBody
	@Scheduled(cron = "0 50 23 ? * *")
	@RequestMapping(value = "/run", method = { RequestMethod.GET, RequestMethod.POST })
	public void run() {
		long start = System.currentTimeMillis();
		logger.info(sdft.format(new Date()) + "定时任务执行开始...");
		String baseFilePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "document/pinganxml/"
				+ sdft.format(new Date());
		logger.info("baseXmlPath:" + baseFilePath);

		publish(baseFilePath);

		offLine(baseFilePath);

		refresh(baseFilePath);

		logger.info(sdft.format(new Date()) + "定时任务执行结束!!!");
		logger.info("耗时：" + (System.currentTimeMillis() - start) + "毫秒");
	}

	private void refresh(String baseFilePath) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		DateTime now = DateTime.now();
		Timestamp start = Timestamp.valueOf(df.format(new Date(now.getMillis())));
		Timestamp end = Timestamp.valueOf(df.format(new Date(now.plusDays(1).getMillis())));
		List<HouseBO> refreshHoseBOList = houseManager.getsRefresh(start, end);
		if (refreshHoseBOList.isEmpty()) {
			return;
		}
		logger.info("等待更新的房子数量：" + refreshHoseBOList.size());
		logger.info("等待更新的房子：");
		for (HouseBO item : refreshHoseBOList) {
			logger.info(item.getTitle() + "|" + item.getTaHouseId());
		}
		houseManager.processRefresh(refreshHoseBOList, baseFilePath);
	}

	private void offLine(String baseFilePath) {
		List<HouseBO> offLineHoseBOList = houseManager.getsOffLine(0, PageUtil.getEnd(0, Integer.MAX_VALUE));
		if (offLineHoseBOList.isEmpty()) {
			return;
		}
		logger.info("等待下架的房子数量：" + offLineHoseBOList.size());
		logger.info("等待下架的房子：");
		for (HouseBO item : offLineHoseBOList) {
			logger.info(item.getTitle() + "|" + item.getTaHouseId());
		}
		houseManager.processOffLine(offLineHoseBOList, baseFilePath);
	}

	private void publish(String baseFilePath) {
		List<HouseBO> houseBOList = houseManager.gets(0, PageUtil.getEnd(0, Integer.MAX_VALUE));
		if (houseBOList.isEmpty()) {
			return;
		}
		logger.info("等待发布到外网的房子数量：" + houseBOList.size());
		logger.info("等待发布到外网的房子：");
		for (HouseBO item : houseBOList) {
			logger.info(item.getTitle() + "|" + item.getTaHouseId());
		}
		houseManager.processPublish(houseBOList, baseFilePath);
	}
}
