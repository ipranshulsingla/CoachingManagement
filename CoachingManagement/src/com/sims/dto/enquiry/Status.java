package com.sims.dto.enquiry;

public class Status implements Comparable<Status> {
	private Integer statusId;
	private String color,statusName;
	
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	@Override
	public int compareTo(Status o) {
		// TODO Auto-generated method stub
		return this.statusId-o.getStatusId();
	}
	
	
}
