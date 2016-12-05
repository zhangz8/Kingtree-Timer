package com.kingtree.timer.service.imp;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.TaHouseMapper;
import com.kingtree.timer.entity.TaHouse;
import com.kingtree.timer.service.KingtreeTaHouseService;

/**
 * 房源服务类
 * 
 * @author youchuan
 * @date 2016-12-01
 */
@Service
public class KingtreeTaHouseServiceImp implements KingtreeTaHouseService {

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

	@Override
	public int countOutSide() {
		return taHouseMapper.countByTooutside();
	}

	@Override
	public List<TaHouse> getOutSide(int start, int length) {
		if (start < 0 || length <= 0) {
			return null;
		}
		return taHouseMapper.selectByTooutside(start, length);
	}

	@Override
	public TaHouse get(String houseId) {
		if (StringUtils.isBlank(houseId)) {
			return null;
		}
		return taHouseMapper.selectByPrimaryKey(houseId);
	}

}
