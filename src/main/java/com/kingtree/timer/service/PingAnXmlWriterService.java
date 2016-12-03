package com.kingtree.timer.service;

import java.io.File;
import java.io.IOException;

import org.dom4j.Document;

public interface PingAnXmlWriterService {

	void write(Document document) throws IOException;

	void write(Document document, File file) throws IOException;  

	File getXMLPath(String xmlName) throws IOException;
}
