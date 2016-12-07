package com.kingtree.timer.service.imp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Service;

import com.kingtree.timer.service.PingAnXmlWriterService;

@Service
public class PingAnXmlWriterServiceImp implements PingAnXmlWriterService {

	@Override
	public void write(Document document) throws IOException {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileWriter("E:/JAVA/file/2016-12-01/housetest.xml"), format);
		writer.write(document);
		writer.flush();
		writer.close();
	}

	@Override
	public void write(Document document, File file) throws IOException {
		if (document == null || file == null) {
			return;
		}
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileWriter(file), format);
		writer.write(document);
		writer.flush();
		writer.close();
	}

	/**
	 * 传入xml文件名，输出绝对路径
	 */
	@Override
	public File getXMLPath(String xmlName) throws IOException {
		String path = "E:/JAVA/file/"; // 暂时先写该路径
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String datePath = sdf.format(new Date());
		String xmlPath = path + datePath + "/" + xmlName;
		return new File(xmlPath);
	}
}
