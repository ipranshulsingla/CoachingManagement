package com.sims.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Iterator;

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
	
}
