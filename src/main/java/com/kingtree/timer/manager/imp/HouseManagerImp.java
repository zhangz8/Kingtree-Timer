package com.kingtree.timer.manager.imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.entity.TaCompany;
import com.kingtree.timer.entity.TaDepartment;
import com.kingtree.timer.entity.TaEstate;
import com.kingtree.timer.entity.TaHouse;
import com.kingtree.timer.entity.TaPicearea;
import com.kingtree.timer.manager.HouseManager;
import com.kingtree.timer.manager.vo.HouseVO;
import com.kingtree.timer.service.KingtreeTaHouseService;
import com.kingtree.timer.service.TaCompanyService;
import com.kingtree.timer.service.TaDepartmentService;
import com.kingtree.timer.service.TaEmployeeService;
import com.kingtree.timer.service.TaEstateService;
import com.kingtree.timer.service.TaPiceareaService;

@Service
public class HouseManagerImp implements HouseManager {

	@Resource
	private KingtreeTaHouseService kingtreeTaHouseService;
	@Resource
	private TaEstateService taEstateService;
	@Resource
	private TaEmployeeService taEmployeeService;
	@Resource
	private TaDepartmentService taDepartmentService;
	@Resource
	private TaPiceareaService taPiceareaService;
	@Resource
	private TaCompanyService taCompanyService;

	private static final String COMPANY_ID = "10";

	@Override
	public HouseVO get(String houseId) {
		if (StringUtils.isBlank(houseId)) {
			return null;
		}
		TaHouse taHouse = kingtreeTaHouseService.get(houseId);
		if (taHouse == null) {
			return null;
		}
		TaEstate taEstate = taEstateService.get(taHouse.getEstid());
		if (taEstate == null) {
			return null;
		}
		TaDepartment taDepartment = taDepartmentService.get(taHouse.getGsdeptid());
		if (taDepartment == null) {
			return null;
		}
		TaPicearea taPicearea = taPiceareaService.get(taHouse.getPiceareaid());
		TaCompany taCompany = taCompanyService.get(COMPANY_ID);
		return new HouseVO(taHouse, taEstate, taDepartment, taCompany, taPicearea);
	}

	@Override
	public List<HouseVO> gets(int start, int length) {
		List<TaHouse> outSideHouseList = kingtreeTaHouseService.getOutSide(start, length);
		if (outSideHouseList == null || outSideHouseList.isEmpty()) {
			return Collections.emptyList();
		}
		List<HouseVO> houseVOList = new ArrayList<HouseVO>();
		for (TaHouse item : outSideHouseList) {
			houseVOList.add(get(item.getHouseid()));
		}
		return houseVOList;
	}

}
