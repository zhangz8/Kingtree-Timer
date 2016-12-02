package com.kingtree.timer.service.imp;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import com.kingtree.timer.service.PingAnXmlService;

@Service
public class PingAnXmlServiceImp implements PingAnXmlService {

	@Override
	public Element getBrokerCompany(Map<String, String> data) {
		return null;
	}

	@Override
	public Element getBrokerDepart(Map<String, String> data) {
		return null;
	}

	@Override
	public Element getBroker(Map<String, String> data) {
		return null;
	}

	@Override
	public Element getCommunity(Map<String, String> data) {
		return null;
	}

	@Override
	public Element getSecondHandHouse(Map<String, String> data) {
		return null;
	}

	@Override
	public Element getSecondHandHouseOffline(Map<String, String> data) {
		return null;
	}

	@Override
	public Element getSecondHandHousePic(Map<String, String> data) {
		return null;
	}

	@Override
	public Document getSecondHandHouseRefresh(List<Map<String, String>> data) {
		if (data == null) {
			return null;
		}

		String[] keys = { "second_hand_house_refresh_list", "second_hand_house_refresh", "id", "user_id" };
		Element root = DocumentHelper.createElement(keys[0]);
		root.addNamespace("", "http://www.pinganfang.com/second_hand_house_refresh");
		for (Map<String, String> item : data) {
			Element refresh = root.addElement(keys[1]);
			Element id = refresh.addElement(keys[2]);
			Element userId = refresh.addElement(keys[3]);

			String idText = item.get(keys[2]);
			String userIText = item.get(keys[3]);

			id.setText(idText);
			userId.setText(userIText);
		}
		return DocumentHelper.createDocument(root);
	}

}
