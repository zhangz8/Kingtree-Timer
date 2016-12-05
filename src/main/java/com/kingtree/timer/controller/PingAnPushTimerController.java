package com.kingtree.timer.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingtree.timer.entity.TaHouse;
import com.kingtree.timer.service.KingtreeTaHouseService;
import com.kingtree.timer.util.ConstantsUtil;
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
	private static SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final int PAGE_SIZE = 20;

	@Resource
	private KingtreeTaHouseService taHouseService;

	/**
	 * @throws IOException
	 * 
	 */
	@ResponseBody
	@Scheduled(cron = "0/60 * * * * ?")
	@RequestMapping(value = "/run", method = { RequestMethod.GET, RequestMethod.POST })
	public void run() throws IOException {
		int successCount = 0;
		int failureCount = 0;
		TaHouse taHouse = new TaHouse();
		taHouse.setTooutside(true);
		int page = 0;
		for (;;) {
			List<TaHouse> taHouseList = taHouseService.getOutSide(PageUtil.getStart(page, PAGE_SIZE), PageUtil.getEnd(page, PAGE_SIZE));
			if (taHouseList == null || taHouseList.isEmpty()) {
				break;
			}

			for (TaHouse item : taHouseList) {
				try {
					logger.info(item.getTitle());
					successCount++;
				} catch (Exception e) {
					logger.info(ConstantsUtil.ERROR + item.getHouseid());
					failureCount++;
				}
			}
			page++;
		}
		logger.info(sdft.format(new Date()) + "定时任务执行结束，SUCCESS:" + successCount + ",FAILURE:" + failureCount);
	}

}
