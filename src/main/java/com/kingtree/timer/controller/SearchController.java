package com.kingtree.timer.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
  
  private static Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

  @Resource
  private SearchService searchService;

  @ResponseBody
  @RequestMapping("/search")
  public JsonVO search(Model model, HttpServletResponse response,
      @RequestParam(required = false, defaultValue = "") String keyword,
      @RequestParam(required = false, defaultValue = "") String brokerName,
      @RequestParam(required = false, defaultValue = "") String communityName,
      @RequestParam(required = false, defaultValue = "0") int page,
      @RequestParam(required = false, defaultValue = "5") int pageSize)
      throws Exception {
    long startTime = System.currentTimeMillis();
    LOGGER.info("搜索开始时间：" + DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
    response.addHeader("Access-Control-Allow-Origin", "*");
    JsonVO jsonVO = new JsonVO();
    if (StringUtils.isNotBlank(keyword)) {
      String key = keyword.trim().replaceAll(" ", " AND ");
      ResultVO resultVO = searchService.search(key, brokerName, communityName, page, pageSize);
      if (resultVO != null) {
        jsonVO.setData(resultVO);
      }
    }
    LOGGER.info("搜索结束时间：" + DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
    LOGGER.info("搜索耗时：" + (System.currentTimeMillis() - startTime));
    return jsonVO;
  }
}
