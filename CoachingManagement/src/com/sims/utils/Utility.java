package com.sims.utils;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import com.sims.dto.payment.Dues;
import com.sims.dto.payment.Payment;

public interface Utility {
	public static LocalDate StringToLocalDate(String date,DateTimeFormatter format) {
		LocalDate localDate=LocalDate.parse(date,format);
		return localDate;
	}
	
	public static boolean isExcludedPattern(String reqUrl){
		HashSet<String> excludedURL=new HashSet<>();
		excludedURL.add("index.html");
		excludedURL.add("checklogin");
		excludedURL.add("forgetpassword");
		excludedURL.add("reset.html");
		excludedURL.add(".css");
		excludedURL.add(".jpg");
		excludedURL.add(".jpeg");
		excludedURL.add(".png");
		excludedURL.add(".js");
		Iterator<String> it=excludedURL.iterator();
		while(it.hasNext()) {
			String str=it.next();
			if(reqUrl.contains(str)) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<Dues> emiCalc(int noOfInst,float amt,String payStatus) throws ClassNotFoundException, SQLException {
		float emi=amt/noOfInst;
		ArrayList<Dues> dues=new ArrayList<>();
		LocalDate today=LocalDate.now();
		for(int i=0;i<noOfInst;++i){
            Dues due=new Dues();
            due.setDueDate(today.plusDays(i*30));
            due.setAmount(emi);
            due.setStatus(payStatus);
            due.setInstNo(i+1);
            due.setRefNo(Payment.generateRefNo(i+1));
            dues.add(due);
		}
		return dues;
	}
	
}
