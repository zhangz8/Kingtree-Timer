package com.kingtree.timer.service.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.TaEmployeeMapper;
import com.kingtree.timer.entity.TaEmployee;
import com.kingtree.timer.service.TaEmployeeService;

@Service
public class TaEmployeeServiceImp implements TaEmployeeService {

	@Resource
	private TaEmployeeMapper taEmployeeMapper;

	@Override
	public TaEmployee get(String userId) {
		if (StringUtils.isBlank(userId)) {
			return null;
		}
		return taEmployeeMapper.selectByUserId(userId);
	}

}
