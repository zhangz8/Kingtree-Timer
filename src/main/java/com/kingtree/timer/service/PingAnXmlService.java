package com.kingtree.timer.service;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;

public interface PingAnXmlService {
 
	Document getSecondHandHouseOffline(List<Map<String, String>> data); 

	Document getSecondHandHouseRefresh(List<Map<String, String>> data);

	Document getSecondHandHousePic(List<Map<String, String>> data);

	Document getSecondHandHouse(List<Map<String, String>> data);

	Document getCommunity(List<Map<String, String>> data);

	Document getBroker(List<Map<String, String>> data);

	Document getBrokerDepart(List<Map<String, String>> data);

	Document getBrokerCompany(List<Map<String, String>> data);

}
