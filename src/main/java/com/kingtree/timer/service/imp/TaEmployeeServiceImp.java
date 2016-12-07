package com.kingtree.timer.service.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.TaEmployeeMapper;
import com.kingtree.timer.dao.TaSystemUserMapper;
import com.kingtree.timer.entity.TaEmployee;
import com.kingtree.timer.service.TaEmployeeService;
import com.kingtree.timer.service.TaSystemUserService;
import com.kingtree.timer.service.vo.TaEmployeeVO;
import com.kingtree.timer.service.vo.TaSystemUserVO;

@Service
public class TaEmployeeServiceImp implements TaEmployeeService {

	@Resource
	private TaEmployeeMapper taEmployeeMapper;
	@Resource
	private TaSystemUserService taSystemUserService;
	@Resource
	private TaSystemUserMapper taSystemUserMapper;

	@Override
	public TaEmployeeVO get(String employeeId) {
		if (StringUtils.isBlank(employeeId)) {
			return null;
		}
		TaEmployee taEmployee = taEmployeeMapper.selectByPrimaryKey(employeeId);
		if (taEmployee != null) {
			TaSystemUserVO taSystemUserVO = taSystemUserService.get(taEmployee.getUid());
			if (taSystemUserVO != null) {
				return TaEmployeeVO.build(taSystemUserVO.getId(), taEmployee, taSystemUserMapper.selectByPrimaryKey(taSystemUserVO.getUid()));
			}
		}
		return null;
	}

}
