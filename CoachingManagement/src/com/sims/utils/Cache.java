package com.sims.utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.sims.dao.CommonDAO;
import com.sims.dto.enquiry.Status;
import com.sims.dto.generic.Course;
import com.sims.dto.generic.Generic;

public interface Cache {
	ArrayList<Generic> gender=new ArrayList<>();
	ArrayList<Course> course=new ArrayList<>();
	ArrayList<Status> status=new ArrayList<>();
	ArrayList<Generic> referralBy=new ArrayList<>();
	ArrayList<Generic> paymentType=new ArrayList<>();
	
	public static void cacheGender() throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, SQLException {
		gender.addAll(CommonDAO.fetchGeneric("Gender",Generic.class));
	}
	
	public static void cacheReferralBy() throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, SQLException {
		referralBy.addAll(CommonDAO.fetchGeneric("Referral",Generic.class));
	}
	
	public static void cachePaymentType() throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, SQLException {
		paymentType.addAll(CommonDAO.fetchGeneric("PaymentType",Generic.class));
	}
	
	public static void cacheCourse() throws ClassNotFoundException, SQLException {
		course.addAll(CommonDAO.fetchCourses());
	}
	
	public static void cacheStatus() throws ClassNotFoundException, SQLException {
		status.addAll(CommonDAO.fetchStatus());
	}
	
	public static Generic getGender(String val) {
		Iterator<Generic> it=gender.iterator();
		Generic obj = null;
		while(it.hasNext()) {
			obj=it.next();
			if(obj.getValue().compareTo(val)==0)
				break;
		}
		return obj;
	}
	
	public static Generic getReferral(String ref) {
		Iterator<Generic> it=referralBy.iterator();
		Generic obj = null;
		while(it.hasNext()) {
			obj=it.next();
			if(obj.getValue().compareTo(ref)==0);
				break;
		}
		return obj;
	}
	
	public static Course getCourse(int courseId) {
		Iterator<Course> it=course.iterator();
		Course obj = null;
		while(it.hasNext()) {
			obj=it.next();
			if(obj.getCourseId()==courseId)
				break;
		}
		return obj;
	}
	
	public static Generic getPaymentType(String payCode) {
		Iterator<Generic> it=paymentType.iterator();
		Generic obj = null;
		while(it.hasNext()) {
			obj=it.next();
			if(obj.getValue().compareTo(payCode)==0)
				break;
		}
		return obj;
	}
}
