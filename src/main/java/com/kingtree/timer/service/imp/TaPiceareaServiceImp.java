package com.kingtree.timer.service.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.KingtreeTaPiceareaMapper;
import com.kingtree.timer.dao.TaPiceareaMapper;
import com.kingtree.timer.entity.KingtreeTaPicearea;
import com.kingtree.timer.entity.TaPicearea;
import com.kingtree.timer.service.TaPiceareaService;
import com.kingtree.timer.service.vo.TaPiceareaVO;

@Service
public class TaPiceareaServiceImp implements TaPiceareaService {

	@Resource
	private TaPiceareaMapper taPiceareaMapper;
	@Resource
	private KingtreeTaPiceareaMapper kingtreeTaPiceareaMapper;

	@Override
	public TaPiceareaVO get(String piceAreaId) {
		if (StringUtils.isBlank(piceAreaId)) {
			return null;
		}
		TaPicearea taPicearea = taPiceareaMapper.selectByPrimaryKey(piceAreaId);
		if (taPicearea != null) {
			KingtreeTaPicearea kingtreeTaPicearea = kingtreeTaPiceareaMapper.selectByPiceareaId(piceAreaId);
			if (kingtreeTaPicearea != null) {
				return TaPiceareaVO.build(kingtreeTaPicearea.getId(), taPicearea);
			}
		}
		return null;
	}

}
