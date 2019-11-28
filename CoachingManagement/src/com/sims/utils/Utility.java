package com.sims.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface Utility {
	public static LocalDate StringToLocalDate(String date,DateTimeFormatter format) {
		LocalDate localDate=LocalDate.parse(date,format);
		System.out.print(localDate);
		return localDate;
	}
}
