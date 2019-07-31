package com.sims.dto.generic;

public class Course implements Comparable<Course>{
	private Integer courseId;
	private String courseName;
	private Integer duration;
	private Float fee;
	
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Float getFee() {
		return fee;
	}
	public void setFee(Float fee) {
		this.fee = fee;
	}
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
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration + ", fee="
				+ fee + "]";
	}
	@Override
	public int compareTo(Course o) {
		// TODO Auto-generated method stub
		return this.courseId-o.getCourseId();
	}	
}
