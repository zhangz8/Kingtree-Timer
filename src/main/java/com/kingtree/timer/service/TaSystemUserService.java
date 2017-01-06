package com.kingtree.timer.service;

import com.kingtree.timer.service.vo.TaSystemUserVO;

public interface TaSystemUserService {

	TaSystemUserVO get(String userId);

	TaSystemUserVO getByEmployeeId(String employeeId);

}
