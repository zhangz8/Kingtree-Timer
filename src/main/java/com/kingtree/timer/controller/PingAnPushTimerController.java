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

import com.kingtree.timer.dao.TaHouseMapper;
import com.kingtree.timer.entity.TaHouse;

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

	@Resource
	private TaHouseMapper taHouseMapper;

	/**
	 * @throws IOException
	 * 
	 */
	@ResponseBody
	@Scheduled(cron = "0/60 * * * * ?")
	@RequestMapping(value = "/run", method = { RequestMethod.GET, RequestMethod.POST })
	public void run() throws IOException {
		TaHouse taHouse = new TaHouse();
		taHouse.setTooutside(true);
		List<TaHouse> selectBySelective = taHouseMapper.selectBySelective(taHouse, 0, 100);
		logger.info(selectBySelective.size() + "");
		logger.info(sdft.format(new Date()) + "定时任务已启动...");
	}

}
