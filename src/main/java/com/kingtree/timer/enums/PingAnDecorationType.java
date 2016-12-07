package com.kingtree.timer.enums;

public enum PingAnDecorationType {
	ROUGH(1, "毛坯"), COMMON(2, "简装"), REFINED(3, "精装"), DELUXE(4, "豪装"), OTHER(5, "其他");

	private int value;

	private String name;

	private PingAnDecorationType(int value, String name) {
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

	public static PingAnDecorationType valueOf(int value) {
		PingAnDecorationType[] values = PingAnDecorationType.values();
		for (PingAnDecorationType item : values) {
			if (item.getValue() == value) {
				return item;
			}
		}
		return OTHER;
	}

	public static PingAnDecorationType nameOf(String name) {
		PingAnDecorationType[] values = PingAnDecorationType.values();
		for (PingAnDecorationType item : values) {
			if (item.getName().equals(name)) {
				return item;
			}
		}
		return OTHER;
	}

}
