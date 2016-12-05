package com.kingtree.timer.service.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.TaPiceareaMapper;
import com.kingtree.timer.entity.TaPicearea;
import com.kingtree.timer.service.TaPiceareaService;

@Service
public class TaPiceareaServiceImp implements TaPiceareaService {

	@Resource
	private TaPiceareaMapper taPiceareaMapper;

	@Override
	public TaPicearea get(String piceAreaId) {
		if (StringUtils.isBlank(piceAreaId)) {
			return null;
		}
		return taPiceareaMapper.selectByPrimaryKey(piceAreaId);
	}

}
