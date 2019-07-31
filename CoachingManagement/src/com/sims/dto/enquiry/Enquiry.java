package com.sims.dto.enquiry;


import java.time.LocalDate;

public class Enquiry {
	private Integer enquiryId,age;
	private String firstName,lastName,mobileNo,email,address,course,message,status,color;
	private LocalDate date;
	private char gender;
	
	public Enquiry(Integer enquiryId, Integer age, String firstName, String lastName, String mobileNo, String email,
			String address, String course, String message, String status, String color, LocalDate date, char gender) {
		this.enquiryId = enquiryId;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
		this.course = course;
		this.message = message;
		this.status = status;
		this.color = color;
		this.date = date;
		this.gender= gender;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Enquiry() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Enquiry [enquiryId=" + enquiryId + ", age=" + age + ", firstName=" + firstName + ", lastName="
				+ lastName + ", mobileNo=" + mobileNo + ", email=" + email + ", address=" + address + ", course="
				+ course + ", message=" + message + ", status=" + status + ", color=" + color + ", date=" + date + "]";
	}
	
}
