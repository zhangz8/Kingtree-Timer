package com.kingtree.timer.service;

import java.util.Map;

import org.dom4j.Element;

public interface PingAnXmlService {

	Element getBrokerCompany(Map<String, String> data);

	Element getBrokerDepart(Map<String, String> data);

	Element getBroker(Map<String, String> data);

	Element getCommunity(Map<String, String> data);

	Element getSecondHandHouse(Map<String, String> data);

	Element getSecondHandHouseOffline(Map<String, String> data);

	Element getSecondHandHousePic(Map<String, String> data);

	Element getSecondHandHouseRefresh(Map<String, String> data);

}
