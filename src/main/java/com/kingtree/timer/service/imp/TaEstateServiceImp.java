package com.kingtree.timer.service.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.KingtreeTaEstateMapper;
import com.kingtree.timer.dao.TaEstateMapper;
import com.kingtree.timer.entity.KingtreeTaEstate;
import com.kingtree.timer.entity.TaEstate;
import com.kingtree.timer.service.TaEstateService;
import com.kingtree.timer.service.vo.TaEstateVO;

@Service
public class TaEstateServiceImp implements TaEstateService {

	@Resource
	private TaEstateMapper taEstateMapper;
	@Resource
	private KingtreeTaEstateMapper kingtreeTaEstateMapper;

	@Override
	public TaEstateVO get(String estateId) {
		if (StringUtils.isBlank(estateId)) {
			return null;
		}
		TaEstate taEstate = taEstateMapper.selectByPrimaryKey(estateId);
		if (taEstate != null) {
			KingtreeTaEstate kingtreeTaEstate = kingtreeTaEstateMapper.selectByEstateId(estateId);
			if (kingtreeTaEstate != null) {
				return TaEstateVO.build(kingtreeTaEstate.getId(), taEstate);
			}
		}
		return null;
	}

}
