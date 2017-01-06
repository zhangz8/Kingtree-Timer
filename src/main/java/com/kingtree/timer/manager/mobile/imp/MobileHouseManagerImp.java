package com.kingtree.timer.manager.mobile.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.manager.mobile.MobileHouseManager;
import com.kingtree.timer.manager.mobile.bo.MobileHouseBO;
import com.kingtree.timer.service.KingtreeTaHouseService;
import com.kingtree.timer.service.TaEstateService;
import com.kingtree.timer.service.TaSystemUserService;
import com.kingtree.timer.service.vo.TaEstateVO;
import com.kingtree.timer.service.vo.TaHouseVO;
import com.kingtree.timer.service.vo.TaSystemUserVO;

@Service
public class MobileHouseManagerImp implements MobileHouseManager {

	@Resource
	private KingtreeTaHouseService kingtreeTaHouseService;
	@Resource
	private TaEstateService taEstateService;
	@Resource
	private TaSystemUserService taSystemUserService;

	@Override
	public MobileHouseBO get(String houseId) {
		if (StringUtils.isNotBlank(houseId)) {
			TaHouseVO house = kingtreeTaHouseService.get(houseId);
			if (house == null) {
				return null;
			}
			TaEstateVO estate = taEstateService.get(house.getEstid());
			if (estate == null) {
				return null;
			}
			TaSystemUserVO user = taSystemUserService.getByEmployeeId(house.getGsempid());
			if (user == null) {
				return null;
			}
			MobileHouseBO houseBO = new MobileHouseBO(house, estate, user);
			return houseBO;
		}
		return null;
	}
}
