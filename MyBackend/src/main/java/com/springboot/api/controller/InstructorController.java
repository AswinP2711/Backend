package com.springboot.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.model.Instructor;
import com.springboot.api.repository.InstructorRepository;

@RestController
public class InstructorController {
	
	@Autowired
	InstructorRepository instructorRepository;
	
	@PostMapping("/instructor/add")
	public Instructor postInstructor(@RequestBody Instructor instructor) {
		return instructorRepository.save(instructor);
	}
	
	@GetMapping("/instructor/all")
	public List<Instructor> getAllInstructors(){
		return instructorRepository.findAll();
	}
	
	
}
