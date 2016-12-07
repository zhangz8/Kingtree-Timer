package com.kingtree.timer.enums;

public enum PingAnHouseType {

	COMMON(1, "住宅"), FLAT(2, "商住"), VILLA(3, "别墅"), OTHER(8, "其他");

	private int value;

	private String name;

	private PingAnHouseType(int value, String name) {
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

	public static PingAnHouseType valueOf(int value) {
		PingAnHouseType[] values = PingAnHouseType.values();
		for (PingAnHouseType item : values) {
			if (item.getValue() == value) {
				return item;
			}
		}
		return OTHER;
	}

	public static PingAnHouseType nameOf(String name) {
		PingAnHouseType[] values = PingAnHouseType.values();
		for (PingAnHouseType item : values) {
			if (item.getName().equals(name)) {
				return item;
			}
		}
		return OTHER;
	}
}
