package com.sims.utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sims.dao.CommonDAO;
import com.sims.dto.enquiry.Status;
import com.sims.dto.generic.Course;
import com.sims.dto.generic.Generic;

public interface Cache {
	ArrayList<Generic> gender=new ArrayList<>();
	ArrayList<Course> course=new ArrayList<>();
	ArrayList<Status> status=new ArrayList<>();
	
	public static void cacheGender() throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, SQLException {
		gender.addAll(CommonDAO.fetchGeneric("Gender",Generic.class));
	}
	
	public static void cacheCourse() throws ClassNotFoundException, SQLException {
		course.addAll(CommonDAO.fetchCourses());
	}
	
	public static void cacheStatus() throws ClassNotFoundException, SQLException {
		status.addAll(CommonDAO.fetchStatus());
	}
}
