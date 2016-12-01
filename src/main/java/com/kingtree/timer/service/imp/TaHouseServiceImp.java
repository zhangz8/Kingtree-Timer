package com.kingtree.timer.service.imp;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.TaHouseMapper;
import com.kingtree.timer.entity.TaHouse;
import com.kingtree.timer.service.TaHouseService;

/**
 * 房源服务类
 * 
 * @author youchuan
 * @date 2016-12-01
 */
@Service
public class TaHouseServiceImp implements TaHouseService {

	@Resource
	private TaHouseMapper taHouseMapper;

	@Override
	public List<TaHouse> get(TaHouse taHouse, int start, int length) {
		if (taHouse == null || start < 0 || length <= 0) {
			return Collections.emptyList();
		}
		return taHouseMapper.selectBySelective(taHouse, start, length);
	}

	@Override
	public int count(TaHouse taHouse) {
		if (taHouse == null) {
			return 0;
		}
		return taHouseMapper.countBySelective(taHouse);
	}

}
