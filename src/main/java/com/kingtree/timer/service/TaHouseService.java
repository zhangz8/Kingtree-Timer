package com.kingtree.timer.service;

import java.util.List;

import com.kingtree.timer.entity.TaHouse;

public interface TaHouseService {

	List<TaHouse> get(TaHouse taHouse, int start, int length);

	int count(TaHouse taHouse);
}
