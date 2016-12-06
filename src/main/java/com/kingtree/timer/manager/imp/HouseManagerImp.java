package com.kingtree.timer.manager.imp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kingtree.timer.entity.TaCompany;
import com.kingtree.timer.entity.TaEstate;
import com.kingtree.timer.manager.HouseManager;
import com.kingtree.timer.manager.bo.HouseBO;
import com.kingtree.timer.service.KingtreeTaHouseService;
import com.kingtree.timer.service.PingAnXmlService;
import com.kingtree.timer.service.PingAnXmlWriterService;
import com.kingtree.timer.service.TaCompanyService;
import com.kingtree.timer.service.TaDepartmentService;
import com.kingtree.timer.service.TaEmployeeService;
import com.kingtree.timer.service.TaEstateService;
import com.kingtree.timer.service.TaPiceareaService;
import com.kingtree.timer.service.vo.TaDepartmentVO;
import com.kingtree.timer.service.vo.TaHouseVO;
import com.kingtree.timer.service.vo.TaPiceareaVO;

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
	@Resource
	private PingAnXmlService pingAnXmlService;
	@Resource
	private PingAnXmlWriterService pingAnXmlWriterService;
	private static final Logger logger = LoggerFactory.getLogger(HouseManagerImp.class);
	private static SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static final String COMPANY_ID = "10";

	@Override
	public HouseBO get(String houseId) {
		if (StringUtils.isBlank(houseId)) {
			return null;
		}
		TaHouseVO taHouse = kingtreeTaHouseService.get(houseId);

		if (taHouse == null) {
			return null;
		}
		TaEstate taEstate = taEstateService.get(taHouse.getEstid());
		if (taEstate == null) {
			return null;
		}
		TaDepartmentVO taDepartment = taDepartmentService.get(taHouse.getGsdeptid());
		if (taDepartment == null) {
			return null;
		}
		TaPiceareaVO taPicearea = taPiceareaService.get(taHouse.getPiceareaid());
		TaCompany taCompany = taCompanyService.get(COMPANY_ID);
		return new HouseBO(taHouse, taEstate, taDepartment, taCompany, taPicearea);
	}

	@Override
	public List<HouseBO> gets(int start, int length) {
		List<TaHouseVO> outSideHouseList = kingtreeTaHouseService.getOutSide(start, length);
		if (outSideHouseList == null || outSideHouseList.isEmpty()) {
			return Collections.emptyList();
		}
		List<HouseBO> houseBOList = new ArrayList<HouseBO>();
		for (TaHouseVO item : outSideHouseList) {
			houseBOList.add(get(item.getHouseid()));
		}
		return houseBOList;
	}

	@Override
	public void process(List<HouseBO> houseBOList) {
		if (houseBOList == null) {
			return;
		}
		List<Map<String, String>> brokers = getBroker(houseBOList);
		List<Map<String, String>> brokerDepts = getBrokerDept(houseBOList);
		List<Map<String, String>> brokerCompanys = getBrokerCompany(houseBOList);
		List<Map<String, String>> communitys = getCommunity(houseBOList);
		List<Map<String, String>> houses = getHouse(houseBOList);
		List<Map<String, String>> houseOffLines = getHouseOfLine(houseBOList);
		List<Map<String, String>> housePictures = getHousePicture(houseBOList);
		List<Map<String, String>> houseRefreshs = getHouseRefresh(houseBOList);

		try {
			pingAnXmlWriterService.write(pingAnXmlService.getBroker(brokers));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating brokerList.xml was error!!!");
		}
		try {
			pingAnXmlWriterService.write(pingAnXmlService.getBrokerDepart(brokerDepts));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating brokerDepartList.xml was error!!!");
		}
		try {
			pingAnXmlWriterService.write(pingAnXmlService.getBrokerCompany(brokerCompanys));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating brokerList.xml was error!!!");
		}
		try {
			pingAnXmlWriterService.write(pingAnXmlService.getCommunity(communitys));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating communityList.xml was error!!!");
		}
		try {
			pingAnXmlWriterService.write(pingAnXmlService.getSecondHandHouse(houses));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating secondHandHouse.xml was error!!!");
		}
		try {
			pingAnXmlWriterService.write(pingAnXmlService.getSecondHandHouseOffline(houseOffLines));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating secondHandHouseOffLine.xml was error!!!");
		}
		try {
			pingAnXmlWriterService.write(pingAnXmlService.getSecondHandHousePic(housePictures));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating secondHandHousePic.xml was error!!!");
		}
		try {
			pingAnXmlWriterService.write(pingAnXmlService.getSecondHandHouseRefresh(houseRefreshs));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating secondHandHouseRefresh.xml was error!!!");
		}

	}

	private List<Map<String, String>> getHouseRefresh(List<HouseBO> houseBOList) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (HouseBO houseBO : houseBOList) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", houseBO.getHouseId());
			map.put("user_id", houseBO.getUserId());
			list.add(map);
		}
		return list;
	}

	private List<Map<String, String>> getHousePicture(List<HouseBO> houseVOList) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (HouseBO houseVO : houseVOList) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("image_id", houseVO.getInnerImgId());
			map.put("url", houseVO.getInnerImg());
			list.add(map);
		}
		return list;
	}

	private List<Map<String, String>> getHouseOfLine(List<HouseBO> houseVOList) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (HouseBO houseVO : houseVOList) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", houseVO.getHouseId());
			list.add(map);
		}
		return list;
	}

	private List<Map<String, String>> getHouse(List<HouseBO> houseVOList) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (HouseBO houseVO : houseVOList) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", houseVO.getHouseId());
			map.put("loupan_id", houseVO.getHouseId());
			map.put("user_id", houseVO.getUserId());
			map.put("unique", houseVO.getHouseId());
			map.put("title", houseVO.getTitle());
			map.put("desc", houseVO.getDescription());
			map.put("price", houseVO.getPrice());
			map.put("room_num", houseVO.getRoomCount());
			map.put("hall_num", houseVO.getHallCount());
			map.put("toilet_num", houseVO.getToiletCount());
			map.put("space", houseVO.getSpace());
			map.put("house_type", houseVO.getHouseType());
			map.put("decoration", houseVO.getDecorationType());
			map.put("toward", houseVO.getTowardType());
			map.put("building_year", houseVO.getBuildingYear());
			map.put("door_plate", houseVO.getDoorPlate());
			map.put("room_no", houseVO.getRoomNO());
			map.put("create_time", houseVO.getCreateTime());
			map.put("tag", houseVO.getRoomNO());
			list.add(map);
		}
		return list;
	}

	private List<Map<String, String>> getCommunity(List<HouseBO> houseVOList) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (HouseBO houseVO : houseVOList) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", houseVO.getCommunityName());
			map.put("city_name", houseVO.getCommunityCityName());
			map.put("region_name", houseVO.getCommunityRegionName());
			map.put("sub_region_name", houseVO.getCommunitySubRegionName());
			map.put("address", houseVO.getCommunityAddress());
			list.add(map);
		}
		return list;
	}

	private List<Map<String, String>> getBrokerCompany(List<HouseBO> houseVOList) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (HouseBO houseVO : houseVOList) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("company_id", houseVO.getCompanyId());
			map.put("city_name", houseVO.getCompanyCity());
			map.put("company_name", houseVO.getCompanyName());
			map.put("company_full_name", houseVO.getCompanyFullName());
			list.add(map);
		}
		return list;
	}

	private List<Map<String, String>> getBrokerDept(List<HouseBO> houseVOList) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (HouseBO houseVO : houseVOList) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("dept_id", houseVO.getDeptId());
			map.put("name", houseVO.getDeptName());
			map.put("dept_address", houseVO.getDeptAddress());
			map.put("company_id", houseVO.getCompanyIdOfDept());
			map.put("parent_dept_id", houseVO.getParentDeptId());
			list.add(map);
		}
		return list;
	}

	private List<Map<String, String>> getBroker(List<HouseBO> houseVOList) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (HouseBO houseVO : houseVOList) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("user_id", houseVO.getUserId());
			map.put("user_name", houseVO.getBrokerName());
			map.put("user_mobile", houseVO.getBrokerMobile());
			map.put("user_bankcard_no", "");
			map.put("user_card_no", houseVO.getBrokerIdentityCard());
			map.put("city_name", houseVO.getBrokerCity());
			map.put("area_name", houseVO.getBrokerArea());
			map.put("block_name", houseVO.getBrokerBlock());
			map.put("company_id", houseVO.getBrokerCompanyId());
			map.put("store_id", houseVO.getBrokerStoreId());
			list.add(map);
		}
		return list;
	}

}
