package com.springboot.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.InstructorCourseDto;
import com.springboot.api.model.Course;
import com.springboot.api.model.Instructor;
import com.springboot.api.model.InstructorCourse;
import com.springboot.api.repository.CourseRepository;
import com.springboot.api.repository.InstructorCourseRepository;
import com.springboot.api.repository.InstructorRepository;

@RestController
public class InstructorCourseController {
	
	@Autowired
	InstructorCourseRepository instructorCourseRepository;
	
	@Autowired
	InstructorRepository instructorRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	
	@PostMapping("/instructor/course/assign/multiple")
	public void assignInstructorToCourse(@RequestBody InstructorCourseDto dto) {
		List<InstructorCourse> list=new ArrayList<>();
		Optional<Instructor> optional=instructorRepository.findById(dto.getInstructorId());
		
		if (!optional.isPresent()) {
			throw new RuntimeException();
		}
		Instructor instructor=optional.get();
		
		dto.getCourseIds().stream().forEach(id->{
			InstructorCourse ic=new InstructorCourse();
			ic.setInstructor(instructor);
			
			Optional<Course> optionalc=courseRepository.findById(id);
			if (!optionalc.isPresent()) {
				throw new RuntimeException("Course ID is invalid : "+id);
			}
			Course course=optionalc.get();
			 
			ic.setCourse(course);
			ic.setYear(dto.getYear());
			InstructorCourse icDB=instructorCourseRepository.validate(instructor.getId(),course.getId(),dto.getYear());
			
			if (icDB == null) {
				list.add(ic);
			}
			
		});
		instructorCourseRepository.saveAll(list);
	}
	
	@GetMapping("/instructor/course/{cid}/{year}")
	public List<Instructor> getInstructorByCourseId(@PathVariable("cid") Long cid,
			@PathVariable("year") String year) {
		return instructorCourseRepository.getInstructorByCourseId(cid,year);
	}
	
	@GetMapping("/course/instructor/{Iid}")
	public List<Course> getCourseByInstructorId(@PathVariable("Iid") Long Iid){
		return instructorCourseRepository.getCourseByInstructorId(Iid);
	}

	
}
