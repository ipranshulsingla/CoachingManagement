package com.sims.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.TreeMap;
import java.util.TreeSet;

import com.sims.dto.Courses;
import com.sims.dto.Enquiry;
import com.sims.dto.Status;
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
	
	public TreeSet<Courses> fetchCourses() throws SQLException{
		ps=con.prepareStatement(SQLConstants.FETCH_COURSES);
		rs=ps.executeQuery();
		TreeSet<Courses> courses=new TreeSet<>();
		while(rs.next()) {
			Courses obj=new Courses();
			obj.setCourseId(Integer.parseInt(rs.getString("id")));
			obj.setCourseName(rs.getString("name"));
			courses.add(obj);
		}
		return courses;
	}
	
	public TreeSet<Status> fetchStatus() throws SQLException{
		ps=con.prepareStatement(SQLConstants.FETCH_STATUS);
		rs=ps.executeQuery();
		TreeSet<Status> status=new TreeSet<>();
		while(rs.next()) {
			Status obj=new Status();
			obj.setStatusId(Integer.parseInt(rs.getString("id")));
			obj.setStatusName(rs.getString("status"));
			status.add(obj);
		}
		return status;
	}
	
	public int addEnquiry(Enquiry eq) throws SQLException {
		ps=con.prepareStatement(SQLConstants.INSERT_ENQUIRY);
		ps.setString(1,eq.getFirstName());
		ps.setString(2,eq.getLastName());
		ps.setInt(3,eq.getAge());
		ps.setInt(4,Integer.parseInt(eq.getMobileNo()));
		ps.setString(5,eq.getEmail());
		ps.setString(6,eq.getAddress());
		ps.setInt(7,Integer.parseInt(eq.getCourse()));
		ps.setString(8,eq.getMessage());
		ps.setTimestamp(9,Timestamp.valueOf(eq.getDate().atTime(LocalTime.MIDNIGHT)));
		ps.setInt(10,Integer.parseInt(eq.getStatus()));
		System.out.print(ps.executeUpdate());
		return 0;
	}
}
