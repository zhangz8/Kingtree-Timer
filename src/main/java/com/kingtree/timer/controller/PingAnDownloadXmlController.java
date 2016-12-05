package com.kingtree.timer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pingan")
public class PingAnDownloadXmlController {

	private static Logger logger = LoggerFactory.getLogger(PingAnDownloadXmlController.class);

	@RequestMapping("/download/{date}/{fileName}")
	public void download(@PathVariable String date, @PathVariable String fileName) {
		logger.info(date + "/" + fileName + ".xml");
	}

}
