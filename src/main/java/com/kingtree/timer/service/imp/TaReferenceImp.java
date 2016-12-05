package com.kingtree.timer.service.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.TaReferenceMapper;
import com.kingtree.timer.entity.TaReference;
import com.kingtree.timer.service.TaReferenceService;

@Service
public class TaReferenceImp implements TaReferenceService {

	@Resource
	private TaReferenceMapper taReferenceMapper;

	@Override
	public TaReference get(String referenceId) {
		if (StringUtils.isBlank(referenceId)) {
			return null;
		}
		return taReferenceMapper.selectByPrimaryKey(referenceId);
	}

}
