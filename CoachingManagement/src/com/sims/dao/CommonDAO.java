package com.sims.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;

import com.sims.dto.enquiry.Status;
import com.sims.dto.generic.Course;
import com.sims.dto.generic.Generic;
import com.sims.utils.SQLConstants;


public interface CommonDAO {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection con=null;
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/coaching","postgres","25009717");
		return con;
	}
	
	public static ArrayList<Course> fetchCourses() throws SQLException, ClassNotFoundException{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement(SQLConstants.FETCH_COURSES);
		ResultSet rs=ps.executeQuery();
		ArrayList<Course> courses=new ArrayList<>();
		while(rs.next()) {
			Course obj=new Course();
			obj.setCourseId(rs.getInt("id"));
			obj.setCourseName(rs.getString("name"));
			obj.setDuration(rs.getInt("duration"));
			obj.setFee(rs.getFloat("fee"));
			courses.add(obj);
		}
		return courses;
	}
	
	public static ArrayList<Status> fetchStatus() throws SQLException, ClassNotFoundException{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement(SQLConstants.FETCH_STATUS);
		ResultSet rs=ps.executeQuery();
		ArrayList<Status> status=new ArrayList<>();
		while(rs.next()) {
			Status obj=new Status();
			obj.setStatusId(rs.getInt("id"));
			obj.setStatusName(rs.getString("status"));
			status.add(obj);
		}
		return status;
	}
	
	public static <T> ArrayList<T> fetchGeneric(String key,Class<T> type) throws ClassNotFoundException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement(SQLConstants.FETCH_GENERIC);
		ps.setString(1,key);
		ResultSet rs=ps.executeQuery();
		ArrayList<T> generic=new ArrayList<>();
		Method method;
		while(rs.next()) {
			T obj=type.getDeclaredConstructor().newInstance();
			method=obj.getClass().getDeclaredMethod("setDesc",String.class);
			method.invoke(obj,rs.getString("descr"));
			method=obj.getClass().getDeclaredMethod("setValue",Character.class);
			method.invoke(obj,rs.getString("value").charAt(0));
			generic.add(obj);
		}
		return generic;
	}
}
