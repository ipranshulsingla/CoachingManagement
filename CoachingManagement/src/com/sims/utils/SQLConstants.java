package com.sims.utils;

public interface SQLConstants {
	String LOGIN_QUERY="select first_name,last_name from users_mst where email=? and password=?";
	String EMAIL_CHECK_QUERY="select first_name,last_name from users_mst where email=?";
	String UPDATE_PASSWORD ="update users_mst set password=? where email=?";
	String FETCH_ENQUIRY="select enquiry.*,courses.name as course_name,enquiry_status.status as status_name,enquiry_status.color "
			+ "from enquiry "
			+ "inner join courses on courses.id=enquiry.course_id "
			+ "inner join enquiry_status on enquiry.status=enquiry_status.id";
	String FETCH_COURSES="select * from courses";
	String FETCH_STATUS="select * from enquiry_status";
	String INSERT_ENQUIRY="insert into enquiry values(DEFAULT,?,?,?,?,?,?,?,?,?,?,?)";
	String DELETE_ENQUIRY="delete from enquiry where eid=?";
	String UPDATE_ENQUIRY ="update enquiry set mob_no=?,email=?,course_id=?,message=?,status=?,address=? where eid=?;";
	String FETCH_GENERIC = "select descr,value,extras from common_generic_param where gkey=?";
	String FETCH_LAST_REGID="select max(reg_id) as lastRegId from students";
	String FETCH_LAST_REFNO = "select max(ref_no) as lastRefNo from fees";
	String INSERT_STUDENT_PD="insert into students values(?,?,?,?,?,?,?,?,?,?)";
	String INSERT_STUDENT_FEE="insert into fees values(?,?,?,?,?,?,?)";
	String FETCH_STUDENT="select * from students,fees where students.reg_id=fees.reg_id order by fees.reg_id";
}
