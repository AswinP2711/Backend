package com.springboot.api.dto;

import java.util.List;

public class InstructorCourseDto {
	private long instructorId;
	private List<Long> courseIds;
	private String year;
	public long getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(long instructorId) {
		this.instructorId = instructorId;
	}
	public List<Long> getCourseIds() {
		return courseIds;
	}
	public void setCourseIds(List<Long> courseIds) {
		this.courseIds = courseIds;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "InstructorCourseDto [instructorId=" + instructorId + ", courseIds=" + courseIds + ", year=" + year
				+ "]";
	}
	
	
	
}
