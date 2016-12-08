package com.kingtree.timer.enums;

public enum KingtreeHouseStatus {
	RENTED(1, "已租"), SOLD(2, "已售"), INVALID(3, "无效");
	private int value;

	private String name;

	private KingtreeHouseStatus(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static KingtreeHouseStatus valueOf(int value) {
		KingtreeHouseStatus[] values = KingtreeHouseStatus.values();
		for (KingtreeHouseStatus item : values) {
			if (item.getValue() == value) {
				return item;
			}
		}
		return null;
	}

	public static KingtreeHouseStatus nameOf(String name) {
		KingtreeHouseStatus[] values = KingtreeHouseStatus.values();
		for (KingtreeHouseStatus item : values) {
			if (item.getName().equals(name)) {
				return item;
			}
		}
		return null;
	}

}
