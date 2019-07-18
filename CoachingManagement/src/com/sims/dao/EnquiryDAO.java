package com.sims.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

import com.sims.dto.Enquiry;
import com.sims.utils.SQLConstants;

public class EnquiryDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public EnquiryDAO() throws ClassNotFoundException, SQLException{
		con=CommonDAO.getConnection();
	}
	
	public TreeMap<Integer,Enquiry> fetchEnquiry() throws SQLException{
		TreeMap<Integer,Enquiry> enquiry=new TreeMap<>();
		ps=con.prepareStatement(SQLConstants.FETCH_ENQUIRY);
		rs=ps.executeQuery();
		while(rs.next()) {
			Enquiry obj=new Enquiry();
			obj.setEnquiryId(Integer.parseInt(rs.getString("eid")));
			obj.setFirstName(rs.getString("first_name"));
			obj.setLastName(rs.getString("last_name"));
			obj.setAge(Integer.parseInt(rs.getString("age")));
			obj.setEmail(rs.getString("email"));
			obj.setMobileNo(rs.getString("mob_no"));
			obj.setCourse(rs.getString("course_name"));
			obj.setMessage(rs.getString("message"));
			obj.setAddress(rs.getString("address"));
			obj.setStatus(rs.getString("status_name"));
			obj.setColor(rs.getString("color"));
			obj.setDate(rs.getTimestamp("date").toLocalDateTime().toLocalDate());
			enquiry.put(obj.getEnquiryId(),obj);
		}
		return enquiry;
	}
}
