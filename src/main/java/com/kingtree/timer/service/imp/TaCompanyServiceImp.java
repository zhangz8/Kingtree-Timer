package com.kingtree.timer.service.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.TaCompanyMapper;
import com.kingtree.timer.entity.TaCompany;
import com.kingtree.timer.service.TaCompanyService;

@Service
public class TaCompanyServiceImp implements TaCompanyService {

	@Resource
	private TaCompanyMapper taCompanyMapper;

	@Override
	public TaCompany get(String companyId) {
		if (StringUtils.isBlank(companyId)) {
			return null;
		}
		return taCompanyMapper.selectByPrimaryKey(companyId);
	}

}
