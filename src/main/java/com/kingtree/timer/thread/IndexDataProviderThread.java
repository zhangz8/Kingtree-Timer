package com.kingtree.timer.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kingtree.timer.entity.TaHouse;
import com.kingtree.timer.service.KingtreeTaHouseService;
import com.kingtree.timer.service.vo.IndexicalHouseVO;
import com.kingtree.timer.util.PageUtil;

public class IndexDataProviderThread implements Runnable {

	private int page, pageSize;
	private BlockingQueue<List<IndexicalHouseVO>> queue;
	private KingtreeTaHouseService kingtreeTaHouseService;
	private static Logger LOGGER = LoggerFactory.getLogger(IndexDataProviderThread.class);

	public IndexDataProviderThread(int page, int pageSize, BlockingQueue<List<IndexicalHouseVO>> queue,
			KingtreeTaHouseService kingtreeTaHouseService) {
		this.page = page;
		this.pageSize = pageSize;
		this.queue = queue;
		this.kingtreeTaHouseService = kingtreeTaHouseService;
	}

	@Override
	public void run() {
		List<TaHouse> houses = kingtreeTaHouseService.query(PageUtil.getStart(page, pageSize), PageUtil.getEnd(page, pageSize));
		List<IndexicalHouseVO> houseVOs = new ArrayList<>();
		if (houses == null || houses.isEmpty()) {
			return;
		}
		for (TaHouse house : houses) {
			IndexicalHouseVO indexicalHouseVO = kingtreeTaHouseService.get(house);
			houseVOs.add(indexicalHouseVO);
		}
		try {
			queue.put(houseVOs);
			LOGGER.info("缓冲区写入数据,page:" + page + ",pageSize:" + pageSize);
		} catch (InterruptedException e) {
			LOGGER.error("缓冲区写入数据【失败】,page:" + page + ",pageSize:" + pageSize + e);
		}
	}

}
