package com.sims.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.TreeMap;
import java.util.TreeSet;

import com.sims.dto.enquiry.Enquiry;
import com.sims.dto.enquiry.Status;
import com.sims.dto.generic.Course;
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
			obj.setEnquiryId(rs.getInt("eid"));
			obj.setFirstName(rs.getString("first_name"));
			obj.setLastName(rs.getString("last_name"));
			obj.setAge(rs.getInt("age"));
			obj.setEmail(rs.getString("email"));
			obj.setMobileNo(rs.getString("mob_no"));
			obj.setCourse(rs.getString("course_name"));
			obj.setMessage(rs.getString("message"));
			obj.setAddress(rs.getString("address"));
			obj.setStatus(rs.getString("status_name"));
			obj.setColor(rs.getString("color"));
			obj.setDate(rs.getTimestamp("date").toLocalDateTime().toLocalDate());
			obj.setGender(rs.getString("gender").charAt(0));
			enquiry.put(obj.getEnquiryId(),obj);
		}
		return enquiry;
	}
	
	public int addEnquiry(Enquiry eq) throws SQLException {
		ps=con.prepareStatement(SQLConstants.INSERT_ENQUIRY);
		ps.setString(1,eq.getFirstName());
		ps.setString(2,eq.getLastName());
		ps.setInt(3,eq.getAge());
		ps.setString(4,eq.getMobileNo());
		ps.setString(5,eq.getEmail());
		ps.setString(6,eq.getAddress());
		ps.setInt(7,Integer.parseInt(eq.getCourse()));
		ps.setString(8,eq.getMessage());
		ps.setTimestamp(9,Timestamp.valueOf(eq.getDate().atTime(LocalTime.MIDNIGHT)));
		ps.setInt(10,Integer.parseInt(eq.getStatus()));
		ps.setString(11,eq.getGender()+"");
		int rowCount=ps.executeUpdate();
		return rowCount;
	}
	
	public int deleteEnquiry(Integer enquiryId) throws SQLException {
		ps=con.prepareStatement(SQLConstants.DELETE_ENQUIRY);
		ps.setInt(1,enquiryId);
		int rowCount=ps.executeUpdate();
		return rowCount;
	}
	
	public Integer updateEnquiry(Enquiry eq) throws SQLException {
		ps=con.prepareStatement(SQLConstants.UPDATE_ENQUIRY);
		ps.setString(1,eq.getMobileNo());
		ps.setString(2,eq.getEmail());
		ps.setInt(3,Integer.parseInt(eq.getCourse()));
		ps.setString(4,eq.getMessage());
		ps.setInt(5,Integer.parseInt(eq.getStatus()));
		ps.setString(6,eq.getAddress());
		ps.setInt(7,eq.getEnquiryId());
		int rowCount=ps.executeUpdate();
		return rowCount;
	}
	
}
