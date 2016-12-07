package com.kingtree.timer.manager.imp;

import java.io.File;
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
import com.kingtree.timer.entity.TaDstrict;
import com.kingtree.timer.entity.TaReference;
import com.kingtree.timer.enums.PingAnDecorationType;
import com.kingtree.timer.enums.PingAnHouseImageType;
import com.kingtree.timer.enums.PingAnHouseType;
import com.kingtree.timer.enums.PingAnTowardType;
import com.kingtree.timer.manager.HouseManager;
import com.kingtree.timer.manager.bo.HouseBO;
import com.kingtree.timer.service.KingtreeTaHouseService;
import com.kingtree.timer.service.PingAnXmlService;
import com.kingtree.timer.service.PingAnXmlWriterService;
import com.kingtree.timer.service.TaCompanyService;
import com.kingtree.timer.service.TaDepartmentService;
import com.kingtree.timer.service.TaDstrictService;
import com.kingtree.timer.service.TaEmployeeService;
import com.kingtree.timer.service.TaEstateService;
import com.kingtree.timer.service.TaPiceareaService;
import com.kingtree.timer.service.TaReferenceService;
import com.kingtree.timer.service.vo.TaDepartmentVO;
import com.kingtree.timer.service.vo.TaEmployeeVO;
import com.kingtree.timer.service.vo.TaEstateVO;
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
	@Resource
	private TaDstrictService taDstrictService;
	@Resource
	private TaReferenceService taReferenceService;

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
		TaEstateVO taEstate = taEstateService.get(taHouse.getEstid());
		if (taEstate == null) {
			return null;
		}
		TaDepartmentVO taDepartment = taDepartmentService.get(taHouse.getGsdeptid());
		if (taDepartment == null) {
			return null;
		}
		TaPiceareaVO taPicearea = taPiceareaService.get(taHouse.getPiceareaid());
		if (taPicearea == null) {
			return null;
		}
		TaCompany taCompany = taCompanyService.get(COMPANY_ID);
		TaEmployeeVO taEmployeeVO = taEmployeeService.get(taHouse.getGsempid());
		if (taEmployeeVO == null) {
			return null;
		}
		HouseBO houseBO = new HouseBO(taHouse, taEstate, taDepartment, taCompany, taPicearea, taEmployeeVO);
		TaDstrict taDstrict = taDstrictService.get(taPicearea.getDsid());
		if (taDstrict != null) {
			houseBO.setBrokerArea(taDstrict.getDstrictname());
		}
		TaReference decorationType = taReferenceService.get(taHouse.getPropertydecoration());
		if (decorationType != null) {
			houseBO.setDecorationType(PingAnDecorationType.nameOf(decorationType.getRefnamecn()).getValue() + "");
		}
		TaReference houseType = taReferenceService.get(taHouse.getPropertytype());
		if (houseType != null) {
			houseBO.setHouseType(PingAnHouseType.nameOf(houseType.getRefnamecn()).getValue() + "");
		}
		TaReference dirctionType = taReferenceService.get(taHouse.getPropertydirction());
		if (dirctionType != null) {
			houseBO.setTowardType(PingAnTowardType.nameOf(dirctionType.getRefnamecn()).getValue() + "");
		}
		
		houseBO.setBrokerBlock(taPicearea.getAreaname());
		return houseBO;
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
	public void process(List<HouseBO> houseBOList, String baseFilePath) {
		if (houseBOList == null || StringUtils.isBlank(baseFilePath)) {
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

		initDirectory(baseFilePath);

		try {
			pingAnXmlWriterService.write(pingAnXmlService.getBroker(brokers), new File(baseFilePath + "/BrokerList.xml"));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating brokerList.xml was error!!!");
		}
		try {
			pingAnXmlWriterService.write(pingAnXmlService.getBrokerDepart(brokerDepts), new File(baseFilePath + "/BrokerDepartList.xml"));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating brokerDepartList.xml was error!!!");
		}
		try {
			pingAnXmlWriterService.write(pingAnXmlService.getBrokerCompany(brokerCompanys), new File(baseFilePath + "/BrokerCompanyList.xml"));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating brokerCompanyList.xml was error!!!");
		}
		try {
			pingAnXmlWriterService.write(pingAnXmlService.getCommunity(communitys), new File(baseFilePath + "/CommunityList.xml"));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating communityList.xml was error!!!");
		}
		try {
			pingAnXmlWriterService.write(pingAnXmlService.getSecondHandHouse(houses), new File(baseFilePath + "/SecondHandHouseList.xml"));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating secondHandHouseList.xml was error!!!");
		}
		try {
			pingAnXmlWriterService.write(pingAnXmlService.getSecondHandHouseOffline(houseOffLines),
					new File(baseFilePath + "/SecondHandHouseOffLineList.xml"));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating secondHandHouseOffLineList.xml was error!!!");
		}
		try {
			pingAnXmlWriterService.write(pingAnXmlService.getSecondHandHousePic(housePictures),
					new File(baseFilePath + "/SecondHandHousePicList.xml"));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating secondHandHousePicList.xml was error!!!");
		}
		try {
			pingAnXmlWriterService.write(pingAnXmlService.getSecondHandHouseRefresh(houseRefreshs),
					new File(baseFilePath + "/SecondHandHouseRefresh.xml"));
		} catch (IOException e) {
			logger.info(sdft.format(new Date()) + "generating secondHandHouseRefresh.xml was error!!!");
		}

	}

	private void initDirectory(String baseFilePath) {
		File file = new File(baseFilePath);
		if (!file.exists()) {
			file.mkdir();
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
			Map<String, String> innerImgMap = new HashMap<String, String>();
			innerImgMap.put("image_id", houseVO.getInnerImgId());
			innerImgMap.put("url", houseVO.getInnerImg());
			innerImgMap.put("house_id", houseVO.getHouseId());
			innerImgMap.put("pic_type", PingAnHouseImageType.INNER.getValue() + "");

			Map<String, String> outterImgMap = new HashMap<String, String>();
			outterImgMap.put("image_id", houseVO.getOutterImgId());
			outterImgMap.put("url", houseVO.getOutterImg());
			outterImgMap.put("pic_type", PingAnHouseImageType.OUTTER.getValue() + "");
			outterImgMap.put("house_id", houseVO.getHouseId());

			Map<String, String> layoutImgMap = new HashMap<String, String>();
			layoutImgMap.put("image_id", houseVO.getLayoutImgId());
			layoutImgMap.put("url", houseVO.getLayoutImg());
			layoutImgMap.put("pic_type", PingAnHouseImageType.LAYOUT.getValue() + "");
			layoutImgMap.put("house_id", houseVO.getHouseId());

			list.add(layoutImgMap);
			list.add(outterImgMap);
			list.add(innerImgMap);
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
			map.put("unique_id", houseVO.getHouseId());
			map.put("title", houseVO.getTitle());
			map.put("current_floor", houseVO.getCurrentFloor());
			map.put("total_floor", houseVO.getTotalFloor());
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
			map.put("user_id", houseVO.getUserId());
			list.add(map);
		}
		return list;
	}

	private List<Map<String, String>> getCommunity(List<HouseBO> houseVOList) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (HouseBO houseVO : houseVOList) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", houseVO.getCommunityId());
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
			map.put("user_id", houseVO.getBrokerId());
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
