package com.kingtree.timer.service.imp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		//缩进排版格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		//设置编码
		format.setEncoding("UTF-8");
		//创建XMLWriter对象，指定写出文件及编码格式
		XMLWriter writer = new XMLWriter(new FileWriter("E:/JAVA/file/2016-12-01/housetest.xml"),format);
		//写入
		writer.write(document);
		//立即写入
		writer.flush();
		//关闭操作
		writer.close();
	}

	@Override
	public void write(Document document,File file) throws IOException {
		//缩进排版格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		//设置编码
		format.setEncoding("UTF-8");
		//创建XMLWriter对象，指定写出文件及编码格式
		XMLWriter writer = new XMLWriter(new FileWriter(file),format);
		//写入
		writer.write(document);
		//立即写入
		writer.flush();
		//关闭操作
		writer.close();
	}
/*
 * 传入xml文件名，输出绝对路径
 * */
	@Override
	public File getXMLPath(String xmlName)throws IOException {
		
		String path = "E:/JAVA/file/"; //暂时先写该路径
		Calendar  c = Calendar.getInstance(); 
		String datePath = c.get(Calendar.YEAR)+"-"+c.get(Calendar.MONTH)+"-"+c.get(Calendar.DATE);//格式：2016-11-3
		String xmlPath = path+datePath+"/"+xmlName; //格式：E:/JAVA/file/2016-11-3/SecondHandHouseList.xml
		return new File(xmlPath);
	}
}
