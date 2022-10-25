package com.springboot.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.model.Course;
import com.springboot.api.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/course/add")
	public Course postCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
	
	@GetMapping("/course/all")
	public List<Course> getAllCourse(){
		return courseRepository.findAll();
	}
}
