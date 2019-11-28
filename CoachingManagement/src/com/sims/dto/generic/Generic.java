package com.sims.dto.generic;

public class Generic {
	private String value;
	private String desc;
	private String extras;
	
	public String getExtras() {
		return extras;
	}
	public void setExtras(String extras) {
		this.extras = extras;
	}
	public String getValue() {
		return value;
	}
	@Override
	public String toString() {
		return "Generic [value=" + value + ", desc=" + desc + "]";
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
