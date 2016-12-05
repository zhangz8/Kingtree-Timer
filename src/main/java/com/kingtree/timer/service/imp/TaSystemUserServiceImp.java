package com.kingtree.timer.service.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.TaSystemUserMapper;
import com.kingtree.timer.entity.TaSystemUser;
import com.kingtree.timer.service.TaSystemUserService;

@Service
public class TaSystemUserServiceImp implements TaSystemUserService {

	@Resource
	private TaSystemUserMapper taSystemUserMapper;

	@Override
	public TaSystemUser get(String userId) {
		if (StringUtils.isBlank(userId)) {
			return null;
		}
		return taSystemUserMapper.selectByPrimaryKey(userId);
	}

}
