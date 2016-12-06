package com.kingtree.timer.service.imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.KingtreeTaHouseMapper;
import com.kingtree.timer.dao.TaHouseMapper;
import com.kingtree.timer.entity.KingtreeTaHouse;
import com.kingtree.timer.entity.TaHouse;
import com.kingtree.timer.service.KingtreeTaHouseService;
import com.kingtree.timer.service.vo.TaHouseVO;

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
	@Resource
	private KingtreeTaHouseMapper kingtreeTaHouseMapper;

	@Override
	public List<TaHouseVO> get(TaHouse taHouse, int start, int length) {
		if (taHouse == null || start < 0 || length <= 0) {
			return Collections.emptyList();
		}
		List<TaHouse> taHouseList = taHouseMapper.selectBySelective(taHouse, start, length);
		if (taHouseList == null) {
			return Collections.emptyList();
		}
		List<TaHouseVO> taHouseVOList = new ArrayList<TaHouseVO>();
		for (TaHouse item : taHouseList) {
			taHouseVOList.add(TaHouseVO.build(kingtreeTaHouseMapper.selectByHouseId(item.getHouseid()).getId(), item));
		}
		return taHouseVOList;
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
	public List<TaHouseVO> getOutSide(int start, int length) {
		if (start < 0 || length <= 0) {
			return Collections.emptyList();
		}
		List<TaHouse> taHouseList = taHouseMapper.selectByTooutside(start, length);
		if (taHouseList == null) {
			return Collections.emptyList();
		}
		List<TaHouseVO> taHouseVOList = new ArrayList<TaHouseVO>();
		for (TaHouse item : taHouseList) {
			KingtreeTaHouse kingtreeTaHouse = kingtreeTaHouseMapper.selectByHouseId(item.getHouseid());
			if (kingtreeTaHouse != null) {
				taHouseVOList.add(TaHouseVO.build(kingtreeTaHouse.getId(), item));
			}
		}
		return taHouseVOList;
	}

	@Override
	public TaHouseVO get(String houseId) {
		if (StringUtils.isBlank(houseId)) {
			return null;
		}
		TaHouse taHouse = taHouseMapper.selectByPrimaryKey(houseId);
		if (taHouse == null) {
			return null;
		}
		return TaHouseVO.build(kingtreeTaHouseMapper.selectByHouseId(taHouse.getHouseid()).getId(), taHouse);
	}

}
