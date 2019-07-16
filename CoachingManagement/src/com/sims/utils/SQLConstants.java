package com.sims.utils;

public interface SQLConstants {
	public static String LOGIN_QUERY="select first_name,last_name from users_mst where email=? and password=?";
	String EMAIL_CHECK_QUERY="select first_name,last_name from users_mst where email=?";
	String UPDATE_PASSWORD ="update users_mst set password=? where email=?";
}
