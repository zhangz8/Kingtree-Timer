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
	public Document getBrokerCompany(List<Map<String, String>> data) {
		if (data == null) {
			return null;
		}
		String[] keys = { "broker_company_list", "broker_company",
				"company_id", "city_name", "company_name", "company_full_name" };
		Element root = DocumentHelper.createElement(keys[0]);
		root.addNamespace("", "http://www.pinganfang.com/broker_company");

		for (Map<String, String> item : data) {
			Element broker_company = root.addElement(keys[1]);
			Element company_id = broker_company.addElement(keys[2]);
			Element city_name = broker_company.addElement(keys[3]);
			Element company_name = broker_company.addElement(keys[4]);
			Element company_full_name = broker_company.addElement(keys[5]);

			String company_id_text = item.get(keys[2]);
			String city_name_text = item.get(keys[3]);
			String company_name_text = item.get(keys[4]);
			String company_full_name_text = item.get(keys[5]);

			company_id.setText(company_id_text);
			city_name.setText(city_name_text);
			company_name.setText(company_name_text);
			company_full_name.setText(company_full_name_text);

		}
		return DocumentHelper.createDocument(root);
	}

	@Override
	public Document getBrokerDepart(List<Map<String, String>> data) {
		if (data == null) {
			return null;
		}
		String[] keys = { "broker_department_list", "broker_department",
				"dept_id", "name", "dept_address", "company_id",
				"parent_dept_id" };
		Element root = DocumentHelper.createElement(keys[0]);
		root.addNamespace("", "http://www.pinganfang.com/broker_department");

		for (Map<String, String> item : data) {
			Element broker_department = root.addElement(keys[1]);
			Element dept_id = broker_department.addElement(keys[2]);
			Element name = broker_department.addElement(keys[3]);
			Element dept_address = broker_department.addElement(keys[4]);
			Element company_id = broker_department.addElement(keys[5]);
			Element parent_dept_id = broker_department.addElement(keys[6]);

			String dept_id_text = item.get(keys[2]);
			String name_text = item.get(keys[3]);
			String dept_address_text = item.get(keys[4]);
			String company_id_text = item.get(keys[5]);
			String parent_dept_id_text = item.get(keys[6]);

			dept_id.setText(dept_id_text);
			name.setText(name_text);
			dept_address.setText(dept_address_text);
			company_id.setText(company_id_text);
			parent_dept_id.setText(parent_dept_id_text);

		}
		return DocumentHelper.createDocument(root);
	}

	@Override
	public Document getBroker(List<Map<String, String>> data) {
		if (data == null) {
			return null;
		}
		String[] keys = { "broker_list", "broker", "user_id", "user_name",
				"user_mobile", "user_bankcard_no", "user_card_no", "city_name",
				"area_name", "block_name", "company_id", "store_id" };
		Element root = DocumentHelper.createElement(keys[0]);
		root.addNamespace("", "http://www.pinganfang.com/broker");

		for (Map<String, String> item : data) {
			Element broker = root.addElement(keys[1]);
			Element user_id = broker.addElement(keys[2]);
			Element user_name = broker.addElement(keys[3]);
			Element user_mobile = broker.addElement(keys[4]);
			Element user_bankcard_no = broker.addElement(keys[5]);
			Element user_card_no = broker.addElement(keys[6]);
			Element city_name = broker.addElement(keys[7]);
			Element area_name = broker.addElement(keys[8]);
			Element block_name = broker.addElement(keys[9]);
			Element company_id = broker.addElement(keys[10]);
			Element store_id = broker.addElement(keys[11]);

			String user_id_text = item.get(keys[2]);
			String user_name_text = item.get(keys[3]);
			String user_mobile_text = item.get(keys[4]);
			String user_bankcard_no_text = item.get(keys[5]);
			String user_card_no_text = item.get(keys[6]);
			String city_name_text = item.get(keys[7]);
			String area_name_text = item.get(keys[8]);
			String block_name_text = item.get(keys[9]);
			String company_id_text = item.get(keys[10]);
			String store_id_text = item.get(keys[11]);

			user_id.setText(user_id_text);
			user_name.setText(user_name_text);
			user_mobile.setText(user_mobile_text);
			user_bankcard_no.setText(user_bankcard_no_text);
			user_card_no.setText(user_card_no_text);
			city_name.setText(city_name_text);
			area_name.setText(area_name_text);
			block_name.setText(block_name_text);
			company_id.setText(company_id_text);
			store_id.setText(store_id_text);

		}
		return DocumentHelper.createDocument(root);
	}

	@Override
	public Document getCommunity(List<Map<String, String>> data) {
		if (data == null) {
			return null;
		}

		String[] keys = { "community_list", "community", "id", "name",
				"city_name", "region_name", "sub_region_name", "address" };
		Element root = DocumentHelper.createElement(keys[0]);
		root.addNamespace("", "http://www.pinganfang.com/community");

		for (Map<String, String> item : data) {
			Element community = root.addElement(keys[1]);
			Element id = community.addElement(keys[2]);
			Element name = community.addElement(keys[3]);
			Element city_name = community.addElement(keys[4]);
			Element region_name = community.addElement(keys[5]);
			Element sub_region_name = community.addElement(keys[6]);
			Element address = community.addElement(keys[7]);

			String id_text = item.get(keys[2]);
			String name_text = item.get(keys[3]);
			String city_name_text = item.get(keys[4]);
			String region_name_text = item.get(keys[5]);
			String sub_region_name_text = item.get(keys[6]);
			String address_text = item.get(keys[7]);

			id.setText(id_text);
			name.setText(name_text);
			city_name.setText(city_name_text);
			region_name.setText(region_name_text);
			sub_region_name.setText(sub_region_name_text);
			address.setText(address_text);

		}
		return DocumentHelper.createDocument(root);
	}

	@Override
	public Document getSecondHandHouse(List<Map<String, String>> data) {
		if (data == null) {
			return null;
		}

		String[] keys = { "second_hand_house_list", "second_hand_house", "id",
				"loupan_id", "user_id", "unique_id", "title", "desc", "price",
				"room_num", "hall_num", "toilet_num", "current_floor",
				"total_floor", "space", "house_type", "decoration", "toward",
				"building_year", "door_plate", "room_no", "tag", "create_time", };
		Element root = DocumentHelper.createElement(keys[0]);
		root.addNamespace("", "http://www.pinganfang.com/second_hand_house");
		for (Map<String, String> item : data) {
			Element second_house = root.addElement(keys[1]);
			Element id = second_house.addElement(keys[2]);
			Element loupan_id = second_house.addElement(keys[3]);
			Element user_id = second_house.addElement(keys[4]);
			Element unique_id = second_house.addElement(keys[5]);
			Element title = second_house.addElement(keys[6]);
			Element desc = second_house.addElement(keys[7]);
			Element price = second_house.addElement(keys[8]);
			Element room_num = second_house.addElement(keys[9]);
			Element hall_num = second_house.addElement(keys[10]);
			Element toilet_num = second_house.addElement(keys[11]);
			Element current_floor = second_house.addElement(keys[12]);
			Element total_floor = second_house.addElement(keys[13]);
			Element space = second_house.addElement(keys[14]);
			Element house_type = second_house.addElement(keys[15]);
			Element decoration = second_house.addElement(keys[16]);
			Element toward = second_house.addElement(keys[17]);
			Element building_year = second_house.addElement(keys[18]);
			Element door_plate = second_house.addElement(keys[19]);
			Element room_no = second_house.addElement(keys[20]);
			Element tag = second_house.addElement(keys[21]);
			Element create_time = second_house.addElement(keys[22]);

			String id_text = item.get(keys[2]);
			String loupan_id_text = item.get(keys[3]);
			String user_id_text = item.get(keys[4]);
			String unique_id_text = item.get(keys[5]);
			String title_text = item.get(keys[6]);
			String desc_text = item.get(keys[7]);
			String price_text = item.get(keys[8]);
			String room_num_text = item.get(keys[9]);
			String hall_num_text = item.get(keys[10]);
			String toilet_num_text = item.get(keys[11]);
			String current_floor_text = item.get(keys[12]);
			String total_floor_text = item.get(keys[13]);
			String space_text = item.get(keys[14]);
			String house_type_text = item.get(keys[15]);
			String decoration_text = item.get(keys[16]);
			String toward_text = item.get(keys[17]);
			String building_year_text = item.get(keys[18]);
			String door_plate_text = item.get(keys[19]);
			String room_no_text = item.get(keys[20]);
			String tag_text = item.get(keys[21]);
			String create_time_text = item.get(keys[22]);

			id.setText(id_text);
			loupan_id.setText(loupan_id_text);
			user_id.setText(user_id_text);
			unique_id.setText(unique_id_text);
			title.setText(title_text);
			desc.setText(desc_text);
			price.setText(price_text);
			room_num.setText(room_num_text);
			hall_num.setText(hall_num_text);
			toilet_num.setText(toilet_num_text);
			current_floor.setText(current_floor_text);
			total_floor.setText(total_floor_text);
			space.setText(space_text);
			house_type.setText(house_type_text);
			decoration.setText(decoration_text);
			toward.setText(toward_text);
			building_year.setText(building_year_text);
			door_plate.setText(door_plate_text);
			room_no.setText(room_no_text);
			tag.setText(tag_text);
			create_time.setText(create_time_text);
		}
		return DocumentHelper.createDocument(root);
	}

	@Override
	public Document getSecondHandHouseOffline(List<Map<String, String>> data) {
		if (data == null) {
			return null;
		}

		String[] keys = { "second_hand_house_offline_list",
				"second_hand_house_offline", "id" };
		Element root = DocumentHelper.createElement(keys[0]);
		root.addNamespace("",
				"http://www.pinganfang.com/second_hand_house_offline");
		for (Map<String, String> item : data) {
			Element offline = root.addElement(keys[1]);
			Element id = offline.addElement(keys[2]);

			String id_text = item.get(keys[2]);

			id.setText(id_text);
		}
		return DocumentHelper.createDocument(root);
	}

	@Override
	public Document getSecondHandHousePic(List<Map<String, String>> data) {
		if (data == null) {
			return null;
		}
		String[] keys = { "second_hand_house_pic_list",
				"second_hand_house_pic", "image_id", "pic_type", "url",
				"house_id" };
		Element root = DocumentHelper.createElement(keys[0]);
		root.addNamespace("",
				"http://www.pinganfang.com/second_hand_house_pics");
		for (Map<String, String> item : data) {
			Element house_pic = root.addElement(keys[1]);
			Element image_id = house_pic.addElement(keys[2]);
			Element pic_type = house_pic.addElement(keys[3]);
			Element url = house_pic.addElement(keys[4]);
			Element house_id = house_pic.addElement(keys[5]);

			String image_id_text = item.get(keys[2]);
			String pic_type_text = item.get(keys[3]);
			String url_text = item.get(keys[4]);
			String house_id_text = item.get(keys[5]);

			image_id.setText(image_id_text);
			pic_type.setText(pic_type_text);
			url.setText(url_text);
			house_id.setText(house_id_text);
		}
		return DocumentHelper.createDocument(root);
	}

	@Override
	public Document getSecondHandHouseRefresh(List<Map<String, String>> data) {
		if (data == null) {
			return null;
		}

		String[] keys = { "second_hand_house_refresh_list",
				"second_hand_house_refresh", "id", "user_id" };
		Element root = DocumentHelper.createElement(keys[0]);
		root.addNamespace("",
				"http://www.pinganfang.com/second_hand_house_refresh");
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
