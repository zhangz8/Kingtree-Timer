package com.kingtree.timer.service.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.TaDepartmentMapper;
import com.kingtree.timer.entity.TaDepartment;
import com.kingtree.timer.service.TaDepartmentService;

@Service
public class TaDepartmentServiceImp implements TaDepartmentService {

	@Resource
	private TaDepartmentMapper taDepartmentMapper;

	@Override
	public TaDepartment get(String departmentId) {
		if (StringUtils.isBlank(departmentId)) {
			return null;
		}
		return taDepartmentMapper.selectByPrimaryKey(departmentId);
	}

}
