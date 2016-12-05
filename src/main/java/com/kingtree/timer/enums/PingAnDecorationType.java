package com.kingtree.timer.enums;

public enum PingAnDecorationType {
	ROUGH(1, "毛坯"), COMMON(2, "普通装修"), REFINED(3, "精装修"), DELUXE(4, "豪华装修"), OTHER(5, "其他");

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
		return null;
	}

}
