package com.sims.dto;

public class Courses implements Comparable<Courses>{
	private Integer courseId;
	private String courseName;
	
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + "]";
	}
	@Override
	public int compareTo(Courses o) {
		// TODO Auto-generated method stub
		return this.courseId-o.getCourseId();
	}	
}
