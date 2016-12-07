package com.kingtree.timer.service.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.TaDstrictMapper;
import com.kingtree.timer.entity.TaDstrict;
import com.kingtree.timer.service.TaDstrictService;

@Service
public class TaDstrictServiceImp implements TaDstrictService {

	@Resource
	private TaDstrictMapper taDstrictMapper;

	@Override
	public TaDstrict get(String dstrictId) {
		if (StringUtils.isBlank(dstrictId)) {
			return null;
		}
		return taDstrictMapper.selectByPrimaryKey(dstrictId);
	}

}
