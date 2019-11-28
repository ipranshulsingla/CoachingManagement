package com.sims.dto.payment;

import java.time.LocalDate;

public class Dues {
	
	private Long refNo;
	private Integer instNo;
	private LocalDate dueDate;
	private Float amount;
	private String status;
	
	public Integer getInstNo() {
		return instNo;
	}
	public void setInstNo(Integer instNo) {
		this.instNo = instNo;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getRefNo() {
		return refNo;
	}
	
	public void setRefNo(Long refNo) {
		this.refNo = refNo;
	}
	
	@Override
	public String toString() {
		return "Dues [refNo=" + refNo + ", instNo=" + instNo + ", dueDate=" + dueDate + ", amount=" + amount
				+ ", status=" + status + "]";
	}
	
}
