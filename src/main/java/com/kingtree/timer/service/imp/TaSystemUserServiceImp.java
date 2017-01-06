package com.kingtree.timer.service.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.KingtreeTaSystemuserMapper;
import com.kingtree.timer.dao.TaEmployeeMapper;
import com.kingtree.timer.dao.TaSystemUserMapper;
import com.kingtree.timer.entity.KingtreeTaSystemuser;
import com.kingtree.timer.entity.TaEmployee;
import com.kingtree.timer.entity.TaSystemUser;
import com.kingtree.timer.service.TaSystemUserService;
import com.kingtree.timer.service.vo.TaSystemUserVO;

@Service
public class TaSystemUserServiceImp implements TaSystemUserService {

	@Resource
	private TaSystemUserMapper taSystemUserMapper;
	@Resource
	private KingtreeTaSystemuserMapper kingtreeTaSystemuserMapper;
	@Resource
	private TaEmployeeMapper taEmployeeMapper;

	@Override
	public TaSystemUserVO get(String userId) {
		if (StringUtils.isBlank(userId)) {
			return null;
		}
		TaSystemUser taSystemUser = taSystemUserMapper.selectByPrimaryKey(userId);
		if (taSystemUser != null) {
			KingtreeTaSystemuser kingtreeTaSystemuser = kingtreeTaSystemuserMapper.selectByUserId(userId);
			if (kingtreeTaSystemuser != null) {
				return TaSystemUserVO.build(kingtreeTaSystemuser.getId(), taSystemUser);
			}
		}
		return null;
	}

	@Override
	public TaSystemUserVO getByEmployeeId(String employeeId) {
		if (StringUtils.isNotBlank(employeeId)) {
			TaEmployee emp = taEmployeeMapper.selectByPrimaryKey(employeeId);
			if (emp != null) {
				return get(emp.getUid());
			}
		}
		return null;
	}

}
