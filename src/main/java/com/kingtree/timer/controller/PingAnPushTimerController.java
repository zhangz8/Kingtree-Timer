package com.kingtree.timer.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingtree.timer.entity.TaHouse;
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
	private static final int PAGE_SIZE = 20;

	@Resource
	private HouseManager houseManager;

	/**
	 * @throws IOException
	 * 
	 */
	@ResponseBody
	// @Scheduled(cron = "0/60 * * * * ?")
	@RequestMapping(value = "/run", method = { RequestMethod.GET, RequestMethod.POST })
	public void run() throws IOException {
		logger.info(sdft.format(new Date()) + "定时任务执行开始...");
		TaHouse taHouse = new TaHouse();
		taHouse.setTooutside(true);
		int page = 0;
		String baseFilePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "document/pinganxml/"
				+ sdft.format(new Date());

		for (;;) {
			List<HouseBO> houseBOList = houseManager.gets(PageUtil.getStart(page, PAGE_SIZE), PageUtil.getEnd(page, PAGE_SIZE));
			if (houseBOList.isEmpty()) {
				break;
			}
			houseManager.process(houseBOList, baseFilePath);
			page++;
		}

		page = 0;
		for (;;) {
			List<HouseBO> offLineHoseBOList = houseManager.getsOffLine(PageUtil.getStart(page, PAGE_SIZE), PageUtil.getEnd(page, PAGE_SIZE));
			if (offLineHoseBOList.isEmpty()) {
				break;
			}
			houseManager.process(offLineHoseBOList, baseFilePath);
			page++;
		}
		logger.info(sdft.format(new Date()) + "定时任务执行结束!!!");
	}

}
