package com.kingtree.timer.service.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.TaBuildingMapper;
import com.kingtree.timer.entity.TaBuilding;
import com.kingtree.timer.service.TaBuildingService;

@Service
public class TaBuildingServiceImp implements TaBuildingService {

	@Resource
	private TaBuildingMapper taBuildingMapper;

	@Override
	public TaBuilding get(String buildingId) {
		if (StringUtils.isBlank(buildingId)) {
			return null;
		}
		return taBuildingMapper.selectByPrimaryKey(buildingId);
	}

}
