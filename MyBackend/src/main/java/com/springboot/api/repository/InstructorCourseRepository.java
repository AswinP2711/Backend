package com.springboot.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.api.model.Course;
import com.springboot.api.model.Instructor;
import com.springboot.api.model.InstructorCourse;

public interface InstructorCourseRepository extends JpaRepository<InstructorCourse, Long>{
	
	@Query("select ic from InstructorCourse ic"
			+ " where ic.instructor.id=?1 AND"
			+ " ic.course.id=?2 AND"
			+ " ic.year=?3")
	InstructorCourse validate(Long instructorID, Long courseId, String year);
	
	@Query("select ic.instructor from InstructorCourse ic"
			+ " where ic.course.id=?1 AND ic.year=?2")
	List<Instructor> getInstructorByCourseId(Long cid, String year);

	@Query("select ic.course from InstructorCourse ic where ic.instructor.id=?1")
	List<Course> getCourseByInstructorId(Long iid);

}
