package com.kingtree.timer.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingtree.timer.util.ConstantsUtil;

@Controller
@RequestMapping("/pingan")
public class PingAnDownloadXmlController {

	private static Logger logger = LoggerFactory.getLogger(PingAnDownloadXmlController.class);

	@ResponseBody
	@RequestMapping("/{date}/{fileName}")
	public void download(HttpServletResponse response, @PathVariable String date, @PathVariable String fileName) throws IOException {
		fileName += ".xml";
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "document/pinganxml/" + date;
		File file = new File(path + File.separator + fileName);
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			logger.info(ConstantsUtil.ERROR + ConstantsUtil.COLON + file.toString());
			return;
		}

		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

		OutputStream os = response.getOutputStream();
		byte[] b = new byte[(int) file.length()];
		int length;
		while ((length = inputStream.read(b)) > 0) {
			os.write(b, 0, length);
		}
		os.close();
		inputStream.close();
	}

}
