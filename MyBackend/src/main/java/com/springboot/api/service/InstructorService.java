package com.springboot.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.repository.InstructorRepository;

@Service
public class InstructorService {
	
	@Autowired
	InstructorRepository instructorRepository;

}
