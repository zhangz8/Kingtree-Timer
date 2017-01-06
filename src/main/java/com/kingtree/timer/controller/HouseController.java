package com.kingtree.timer.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingtree.timer.manager.mobile.MobileHouseManager;
import com.kingtree.timer.manager.mobile.bo.MobileHouseBO;
import com.kingtree.timer.vo.JsonVO;

@Controller
@RequestMapping("/house")
public class HouseController {

	@Resource
	private MobileHouseManager mobileHouseManager;

	@ResponseBody
	@RequestMapping("/{houseId}")
	public JsonVO detail(HttpServletResponse response, @PathVariable String houseId) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonVO jsonVO = new JsonVO(true);
		MobileHouseBO house = mobileHouseManager.get(houseId);
		jsonVO.setData(house);
		return jsonVO;
	}

}
