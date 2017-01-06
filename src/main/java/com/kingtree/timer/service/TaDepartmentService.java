package com.kingtree.timer.service;

import java.util.List;

import com.kingtree.timer.service.vo.TaDepartmentVO;

public interface TaDepartmentService {

	TaDepartmentVO get(String departmentId);

	/**
	 * 获取所有上级部门
	 * 
	 * @param departmentId
	 * @return
	 */
	List<TaDepartmentVO> gets(String departmentId);
}
