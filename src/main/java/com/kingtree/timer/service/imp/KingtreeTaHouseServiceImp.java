package com.kingtree.timer.service.imp;

import java.sql.Timestamp;
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
import com.kingtree.timer.dao.TaHousePriceMapper;
import com.kingtree.timer.dao.TaHouseownerMapper;
import com.kingtree.timer.entity.KingtreeTaHouse;
import com.kingtree.timer.entity.KingtreeTaHouseTooutside;
import com.kingtree.timer.entity.KingtreeTaHouseowner;
import com.kingtree.timer.entity.TaAttachment;
import com.kingtree.timer.entity.TaHouse;
import com.kingtree.timer.entity.TaHousePrice;
import com.kingtree.timer.entity.TaHouseowner;
import com.kingtree.timer.entity.TaReference;
import com.kingtree.timer.enums.KingtreeHouseStatus;
import com.kingtree.timer.service.KingtreeTaHouseService;
import com.kingtree.timer.service.TaDepartmentService;
import com.kingtree.timer.service.TaEmployeeService;
import com.kingtree.timer.service.TaEstateService;
import com.kingtree.timer.service.TaReferenceService;
import com.kingtree.timer.service.vo.IndexicalHouseVO;
import com.kingtree.timer.service.vo.TaDepartmentVO;
import com.kingtree.timer.service.vo.TaEmployeeVO;
import com.kingtree.timer.service.vo.TaEstateVO;
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
	@Resource
	private TaHousePriceMapper taHousePriceMapper;
	@Resource
	private TaHouseownerMapper taHouseownerMapper;

	@Resource
	private TaEmployeeService taEmployeeService;
	@Resource
	private TaDepartmentService taDepartmentService;
	@Resource
	private TaEstateService taEstateService;
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
			TaHouseVO houseVO = TaHouseVO.build(kingtreeTaHouseMapper.selectByHouseId(item.getHouseid()).getId(), item);
			TaHouseowner owner = taHouseownerMapper.selectByPrimaryKey(item.getHwid());
			if (owner != null) {
				houseVO.setHouseOwnerName(owner.getOwername());
				houseVO.setHouseOwnerTel(owner.getOwnemobile());
			}
			taHouseVOList.add(houseVO);
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
			if (kingtreeTaHouseowner != null) {
				taHouseVO.setUserId(kingtreeTaHouseowner.getId());
			}
			TaReference refTrede = taReferenceService.get(taHouseVO.getTradestatus());
			if (refTrede != null) {
				KingtreeHouseStatus offLineStatus = KingtreeHouseStatus.nameOf(refTrede.getRefnamecn());
				if (offLineStatus != null) {
					taHouseVO.setIsOffLine(true);
				}
			}
			List<TaAttachment> taAttachmentList = taAttachmentMapper.selectByBelongId(taHouse.getHouseid());
			if (taAttachmentList != null) {
				List<String> innerImgList = new ArrayList<String>();
				for (TaAttachment item : taAttachmentList) {
					if (LAYOUT_IMG_TYPE.equals(item.getPhototype())) {
						taHouseVO.setLayoutImg(item.getAttachurl());
					} else {
						innerImgList.add(item.getAttachurl());
					}
				}
				taHouseVO.setInnerImgList(innerImgList);
			}
			TaHousePrice housePrice = taHousePriceMapper.selectByHouseId(houseId);
			if (housePrice != null) {
				taHouseVO.setSellPrice(housePrice.getSellprice() == null ? 0.0 : Double.valueOf(housePrice.getSellprice().toString()));
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
		List<TaHouse> houseOffLine = taHouseMapper.selectOffLine(start, length);
		List<TaHouseVO> taHouseVOList = new ArrayList<TaHouseVO>();
		for (TaHouse item : houseOffLine) {
			taHouseVOList.add(get(item.getHouseid()));
		}
		return taHouseVOList;
	}

	@Override
	public void remove(int kingtreeHouseId) {
		if (kingtreeHouseId <= 0) {
			return;
		}
		kingtreeTaHouseTooutsideMapper.deleteByPrimaryKey(kingtreeHouseId);
	}

	@Override
	public List<TaHouseVO> getRefreshBroker(Timestamp start, Timestamp end) {
		if (start == null || end == null || start.after(end)) {
			return Collections.emptyList();
		}
		List<TaHouse> refreshedTaHouseList = taHouseMapper.selectRefreshBroker(start, end);
		List<TaHouseVO> taHouseVOList = new ArrayList<TaHouseVO>();
		for (TaHouse item : refreshedTaHouseList) {
			taHouseVOList.add(get(item.getHouseid()));
		}
		return taHouseVOList;
	}

	@Override
	public List<TaHouse> get(Timestamp updateTime, int start, int length) {
		if (updateTime == null || start < 0 || length <= 0) {
			return Collections.emptyList();
		}
		return taHouseMapper.selectByUpdateTime(updateTime, start, length);
	}

	@Override
	public List<TaHouse> query(int start, int length) {
		if (start < 0 || length <= 0) {
			return Collections.emptyList();
		}
		return taHouseMapper.selectAllEffeciveHouse(start, length);
	}

	@Override
	public int count() {
		return taHouseMapper.count();
	}

	@Override
	public IndexicalHouseVO get(TaHouse house) {
		IndexicalHouseVO indexicalHouseVO = new IndexicalHouseVO();
		TaHouseVO taHouseVO = get(house.getHouseid());
		if (taHouseVO == null) {
			return null;
		}
		indexicalHouseVO.setHouseId(taHouseVO.getHouseid());
		indexicalHouseVO.setHouseDesc(taHouseVO.getPropdesc());
		indexicalHouseVO.setHousePrice(taHouseVO.getSellPrice() + "");
		indexicalHouseVO.setHostName(taHouseVO.getHouseOwnerName());
		indexicalHouseVO.setHostTel(taHouseVO.getHouseOwnerTel());
		indexicalHouseVO.setBrokerName(house.getGsempname());
		indexicalHouseVO.setHouseName(taHouseVO.getTitle());
		TaEmployeeVO taEmployeeVO = taEmployeeService.get(house.getGsempid());
		if (taEmployeeVO != null) {
			indexicalHouseVO.setBrokerName(taEmployeeVO.getUserName());
			indexicalHouseVO.setBrokerTel(taEmployeeVO.getMobile());
			List<TaDepartmentVO> depts = taDepartmentService.gets(taEmployeeVO.getDeptid());
			if (depts != null) {
				String deptsName = "";
				for (TaDepartmentVO item : depts) {
					deptsName += item.getDepname() + ",";
				}
				indexicalHouseVO.setBlock(deptsName);
			}
		}
		TaEstateVO taEstateVO = taEstateService.get(taHouseVO.getEstid());
		if (taEstateVO != null) {
			indexicalHouseVO.setHouseAddress(taEstateVO.getAddress());
			indexicalHouseVO.setCommunityDesc(taEstateVO.getDescription());
			indexicalHouseVO.setCommunityName(taEstateVO.getEstatename());
		}
		return indexicalHouseVO;
	}

}
