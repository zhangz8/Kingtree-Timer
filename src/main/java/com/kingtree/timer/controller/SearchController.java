package com.kingtree.timer.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingtree.timer.service.SearchService;
import com.kingtree.timer.service.vo.ResultVO;
import com.kingtree.timer.vo.JsonVO;

@Controller
public class SearchController {

	@Resource
	private SearchService searchService;

	@ResponseBody
	@RequestMapping("/search")
	public JsonVO search(Model model, HttpServletResponse response, @RequestParam(required = false, defaultValue = "") String keyword,
			@RequestParam(required = false, defaultValue = "0") int page, @RequestParam(required = false, defaultValue = "5") int pageSize)
			throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonVO jsonVO = new JsonVO();
		if (StringUtils.isNotBlank(keyword)) {
			String key = keyword.trim().replaceAll(" ", " AND ");
			ResultVO resultVO = searchService.search(key, page, pageSize);
			if (resultVO != null) {
				jsonVO.setData(resultVO);
			}
		}
		return jsonVO;
	}
}
