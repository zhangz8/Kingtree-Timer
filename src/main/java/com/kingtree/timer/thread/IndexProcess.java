package com.kingtree.timer.thread;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.kingtree.timer.entity.TaHouse;

public class IndexProcess {

	private BlockingQueue<List<TaHouse>> housesQueue = new LinkedBlockingQueue<List<TaHouse>>(20);

	public void set(List<TaHouse> houses) {
		try {
			housesQueue.put(houses);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public List<TaHouse> get() {
		try {
			return housesQueue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int size() {
		return housesQueue.size();
	}

}
