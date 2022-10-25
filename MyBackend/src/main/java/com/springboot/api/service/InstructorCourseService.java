package com.springboot.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.repository.InstructorCourseRepository;

@Service
public class InstructorCourseService {

	@Autowired
	InstructorCourseRepository instructorCourseRepository;
}
