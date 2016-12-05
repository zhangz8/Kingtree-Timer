package com.kingtree.timer.enums;

public enum PingAnTowardType {
	EAST(1, "东"), SOUTH(2, "南"), WEST(3, "西"), NORTH(4, "北"), SOUTH_NORTH(5, "南北"), EAST_WEST(6, "东西"), EAST_SOUTH(7, "东南"), WEST_SOUTH(8,
			"西南"), EAST_NORTH(9, "东北"), WEST_NORTH(10, "西北");

	private int value;

	private String name;

	private PingAnTowardType(int value, String name) {
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

	public static PingAnTowardType valueOf(int value) {
		PingAnTowardType[] values = PingAnTowardType.values();
		for (PingAnTowardType item : values) {
			if (item.getValue() == value) {
				return item;
			}
		}
		return null;
	}

}
