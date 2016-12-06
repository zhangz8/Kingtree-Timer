package com.kingtree.timer.service.imp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kingtree.timer.dao.KingtreeTaDepartmentMapper;
import com.kingtree.timer.dao.TaDepartmentMapper;
import com.kingtree.timer.entity.KingtreeTaDepartment;
import com.kingtree.timer.entity.TaDepartment;
import com.kingtree.timer.service.TaDepartmentService;
import com.kingtree.timer.service.vo.TaDepartmentVO;

@Service
public class TaDepartmentServiceImp implements TaDepartmentService {

	@Resource
	private TaDepartmentMapper taDepartmentMapper;
	@Resource
	private KingtreeTaDepartmentMapper kingtreeTaDepartmentMapper;

	@Override
	public TaDepartmentVO get(String departmentId) {
		if (StringUtils.isBlank(departmentId)) {
			return null;
		}
		TaDepartment taDeptment = taDepartmentMapper.selectByPrimaryKey(departmentId);
		if (taDeptment != null) {
			KingtreeTaDepartment kingtreeTaDepartment = kingtreeTaDepartmentMapper.selectByDepartmentId(departmentId);
			if (kingtreeTaDepartment != null) {
				KingtreeTaDepartment parentDept = kingtreeTaDepartmentMapper.selectByDepartmentId(taDeptment.getPid());
				TaDepartmentVO taDepartmentVO = TaDepartmentVO.build(kingtreeTaDepartment.getId(), taDeptment);
				if (parentDept != null) {
					taDepartmentVO.setParentId(parentDept.getId());
				}
				return taDepartmentVO;
			}
		}
		return null;
	}

}
