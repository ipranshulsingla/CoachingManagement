package com.sims.dto.payment;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.sims.dao.student.StudentDAO;

public class Payment {
	private String paymentType;
	private ArrayList<Dues> dueDates;
	
	@Override
	public String toString() {
		return "Payment [paymentType=" + paymentType + ", dueDates=" + dueDates + "]";
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public ArrayList<Dues> getDueDates() {
		return dueDates;
	}
	public void setDueDates(ArrayList<Dues> dueDates) {
		this.dueDates = dueDates;
	}
	
	public static long generateRefNo(int i) throws ClassNotFoundException, SQLException {
		StudentDAO sd=new StudentDAO();
		long lastRefNo=sd.fetchLastRefNo();
		String refNo=null;
		LocalDate today=LocalDate.now();
		String month=(today.getMonthValue()<10)?("0"+today.getMonthValue()):(""+today.getMonthValue());
		String day=(today.getDayOfMonth()<10)?("0"+today.getDayOfMonth()):(""+today.getDayOfMonth());
		refNo=today.getYear()+month+day;
		if((lastRefNo+"").startsWith(refNo)){
			int temp=(int)(lastRefNo%100)+i;
			refNo+=""+(temp<10?("0"+temp):temp);
		}
		else {
			refNo+="0"+i;
		}
		return Long.parseLong(refNo);
	}
}
