package com.kingtree.timer.service.imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.KingtreeTaHouseMapper;
import com.kingtree.timer.dao.KingtreeTaHouseTooutsideMapper;
import com.kingtree.timer.dao.KingtreeTaHouseownerMapper;
import com.kingtree.timer.dao.TaAttachmentMapper;
import com.kingtree.timer.dao.TaHouseMapper;
import com.kingtree.timer.entity.KingtreeTaHouse;
import com.kingtree.timer.entity.KingtreeTaHouseTooutside;
import com.kingtree.timer.entity.KingtreeTaHouseowner;
import com.kingtree.timer.entity.TaAttachment;
import com.kingtree.timer.entity.TaHouse;
import com.kingtree.timer.entity.TaReference;
import com.kingtree.timer.enums.KingtreeHouseStatus;
import com.kingtree.timer.service.KingtreeTaHouseService;
import com.kingtree.timer.service.TaReferenceService;
import com.kingtree.timer.service.vo.TaHouseVO;

/**
 * 房源服务类
 * 
 * @author youchuan
 * @date 2016-12-01
 */
@Service
public class KingtreeTaHouseServiceImp implements KingtreeTaHouseService {

	@Resource
	private TaHouseMapper taHouseMapper;
	@Resource
	private KingtreeTaHouseMapper kingtreeTaHouseMapper;
	@Resource
	private KingtreeTaHouseownerMapper kingtreeTaHouseownerMapper;
	@Resource
	private TaReferenceService taReferenceService;
	@Resource
	private TaAttachmentMapper taAttachmentMapper;
	@Resource
	private KingtreeTaHouseTooutsideMapper kingtreeTaHouseTooutsideMapper;
	private static final String LAYOUT_IMG_TYPE = "586ff86e3fe1084f013fea52f930001a";// 无关联表，暂时这样处理

	@Override
	public List<TaHouseVO> get(TaHouse taHouse, int start, int length) {
		if (taHouse == null || start < 0 || length <= 0) {
			return Collections.emptyList();
		}
		List<TaHouse> taHouseList = taHouseMapper.selectBySelective(taHouse, start, length);
		if (taHouseList == null) {
			return Collections.emptyList();
		}
		List<TaHouseVO> taHouseVOList = new ArrayList<TaHouseVO>();
		for (TaHouse item : taHouseList) {
			taHouseVOList.add(TaHouseVO.build(kingtreeTaHouseMapper.selectByHouseId(item.getHouseid()).getId(), item));
		}
		return taHouseVOList;
	}

	@Override
	public int count(TaHouse taHouse) {
		if (taHouse == null) {
			return 0;
		}
		return taHouseMapper.countBySelective(taHouse);
	}

	@Override
	public int countOutSide() {
		return taHouseMapper.countByTooutside();
	}

	@Override
	public List<TaHouseVO> getOutSide(int start, int length) {
		if (start < 0 || length <= 0) {
			return Collections.emptyList();
		}
		List<TaHouse> taHouseList = taHouseMapper.selectByTooutside(start, length);
		List<TaHouseVO> taHouseVOList = new ArrayList<TaHouseVO>();
		for (TaHouse item : taHouseList) {
			taHouseVOList.add(get(item.getHouseid()));
		}
		return taHouseVOList;
	}

	@Override
	public TaHouseVO get(String houseId) {
		if (StringUtils.isBlank(houseId)) {
			return null;
		}
		TaHouse taHouse = taHouseMapper.selectByPrimaryKey(houseId);
		if (taHouse == null) {
			return null;
		}
		KingtreeTaHouse kingtreeTaHouse = kingtreeTaHouseMapper.selectByHouseId(taHouse.getHouseid());
		KingtreeTaHouseowner kingtreeTaHouseowner = kingtreeTaHouseownerMapper.selectByHoseownerId(taHouse.getHwid());
		if (kingtreeTaHouse != null) {
			TaHouseVO taHouseVO = TaHouseVO.build(kingtreeTaHouse.getId(), taHouse);
			TaReference offLineRef = taReferenceService.get(taHouseVO.getTradestatus());
			if (offLineRef != null) {
				KingtreeHouseStatus houseStatus = KingtreeHouseStatus.nameOf(offLineRef.getRefnamecn());
				if (houseStatus != null) {
					taHouseVO.setIsOffLine(true);
				}
			}
			if (kingtreeTaHouseowner != null) {
				taHouseVO.setUserId(kingtreeTaHouseowner.getId());
			}
			List<TaAttachment> taAttachmentList = taAttachmentMapper.selectByBelongId(taHouse.getHouseid());
			if (taAttachmentList != null) {
				for (TaAttachment item : taAttachmentList) {
					if (LAYOUT_IMG_TYPE.equals(item.getPhototype())) {
						taHouseVO.setLayoutImg(item.getAttachurl());
					}
				}
			}
			return taHouseVO;
		}
		return null;
	}

	@Override
	public int add(TaHouseVO taHouse) {
		if (taHouse == null) {
			return 0;
		}
		KingtreeTaHouseTooutside kingtreeTaHouseTooutside = new KingtreeTaHouseTooutside();
		kingtreeTaHouseTooutside.setHouseid(taHouse.getHouseid());
		return kingtreeTaHouseTooutsideMapper.insertSelective(kingtreeTaHouseTooutside);
	}

	@Override
	public List<TaHouseVO> getOffLine(int start, int length) {
		if (start < 0 || length <= 0) {
			return Collections.emptyList();
		}
		List<TaHouse> selectOffLine = taHouseMapper.selectOffLine(start, length);
		List<TaHouseVO> taHouseVOList = new ArrayList<TaHouseVO>();
		for (TaHouse item : selectOffLine) {
			taHouseVOList.add(get(item.getHouseid()));
		}
		return taHouseVOList;
	}

}
