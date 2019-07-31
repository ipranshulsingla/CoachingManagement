package com.sims.dto.generic;

public class Generic {
	private Character value;
	private String desc;
	
	public Character getValue() {
		return value;
	}
	@Override
	public String toString() {
		return "Generic [value=" + value + ", desc=" + desc + "]";
	}
	public void setValue(Character value) {
		this.value = value;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
