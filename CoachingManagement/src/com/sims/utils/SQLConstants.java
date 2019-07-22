package com.sims.utils;

public interface SQLConstants {
	public static String LOGIN_QUERY="select first_name,last_name from users_mst where email=? and password=?";
	String EMAIL_CHECK_QUERY="select first_name,last_name from users_mst where email=?";
	String UPDATE_PASSWORD ="update users_mst set password=? where email=?";
	String FETCH_ENQUIRY="select enquiry.*,courses.name as course_name,enquiry_status.status as status_name,enquiry_status.color "
			+ "from enquiry "
			+ "inner join courses on courses.id=enquiry.course_id "
			+ "inner join enquiry_status on enquiry.status=enquiry_status.id";
	String FETCH_COURSES="select * from courses";
	String FETCH_STATUS="select * from enquiry_status";
	String INSERT_ENQUIRY="insert into enquiry values(DEFAULT,?,?,?,?,?,?,?,?,?,?)";
}
