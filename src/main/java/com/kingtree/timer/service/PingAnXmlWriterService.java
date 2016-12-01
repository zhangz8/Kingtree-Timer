package com.kingtree.timer.service;

import java.io.IOException;

import org.dom4j.Document;

public interface PingAnXmlWriterService {

	void write(Document document) throws IOException;
}
