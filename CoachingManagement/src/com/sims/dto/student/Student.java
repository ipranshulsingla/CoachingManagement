package com.sims.dto.student;

import java.sql.SQLException;
import java.time.LocalDate;

import com.sims.dao.student.StudentDAO;
import com.sims.dto.generic.Course;
import com.sims.dto.generic.Generic;
import com.sims.dto.payment.Payment;

public class Student {
	private LocalDate admissionDate,dob;
	private Long regId;
	private String name,fathersName;
	private Generic gender;
	private String mobNo,email;
	private String address;
	private Course course;
	private Payment payment;
	private Generic referralBy;
	public LocalDate getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Long getRegId() {
		return regId;
	}
	public void setRegId(Long regId) {
		this.regId = regId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public Generic getGender() {
		return gender;
	}
	public void setGender(Generic gender) {
		this.gender = gender;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [admissionDate=" + admissionDate + ", dob=" + dob + ", regId=" + regId + ", name=" + name
				+ ", fathersName=" + fathersName + ", gender=" + gender + ", mobNo=" + mobNo + ", email=" + email
				+ ", address=" + address + ", course=" + course + ", payment=" + payment + ", referralBy=" + referralBy
				+ "]";
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Generic getReferralBy() {
		return referralBy;
	}
	public void setReferralBy(Generic referralBy) {
		this.referralBy = referralBy;
	}
	
	public static long generateRegId() throws ClassNotFoundException, SQLException {
		StudentDAO sd=new StudentDAO();
		long lastRegId=sd.fetchLastRegId();
		String regId=null;
		LocalDate today=LocalDate.now();
		String month=(today.getMonthValue()<10)?("0"+today.getMonthValue()):(""+today.getMonthValue());
		String day=(today.getDayOfMonth()<10)?("0"+today.getDayOfMonth()):(""+today.getDayOfMonth());
		regId=today.getYear()+month+day;
		if((lastRegId+"").startsWith(regId)){
			int temp=(int)(lastRegId%100)+1;
			regId+=""+(temp<10?("0"+temp):temp);
		}
		else {
			regId+="01";
		}
		return Long.parseLong(regId);
	}
	
}
