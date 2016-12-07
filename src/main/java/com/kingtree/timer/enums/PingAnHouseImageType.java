package com.kingtree.timer.enums;

public enum PingAnHouseImageType {
	INNER(1, "室内图"), LAYOUT(2, "户型图"), OUTTER(3, "小区图");
	private int value;

	private String name;

	private PingAnHouseImageType(int value, String name) {
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

	public static PingAnHouseImageType valueOf(int value) {
		PingAnHouseImageType[] values = PingAnHouseImageType.values();
		for (PingAnHouseImageType item : values) {
			if (item.getValue() == value) {
				return item;
			}
		}
		return null;
	}

	public static PingAnHouseImageType nameOf(String name) {
		PingAnHouseImageType[] values = PingAnHouseImageType.values();
		for (PingAnHouseImageType item : values) {
			if (item.getName().equals(name)) {
				return item;
			}
		}
		return null;
	}

}
