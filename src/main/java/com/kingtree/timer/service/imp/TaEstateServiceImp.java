package com.kingtree.timer.service.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.TaEstateMapper;
import com.kingtree.timer.entity.TaEstate;
import com.kingtree.timer.service.TaEstateService;

@Service
public class TaEstateServiceImp implements TaEstateService {

	@Resource
	private TaEstateMapper taEstateMapper;

	@Override
	public TaEstate get(String estId) {
		if (StringUtils.isBlank(estId)) {
			return null;
		}
		return taEstateMapper.selectByPrimaryKey(estId);
	}

}
