package com.springboot.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.model.Department;
import com.springboot.api.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/department/insert")
	public Department insertDepartment(@RequestBody Department department) {
		return departmentService.insertDepartment(department);
	}
	
	@GetMapping("/department/all")
	public List<Department> getAllDepartments(){
		return departmentService.getAllDepartments();
	}
}
