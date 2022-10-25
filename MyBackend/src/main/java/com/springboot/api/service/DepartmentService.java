package com.springboot.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.model.Department;
import com.springboot.api.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department insertDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	public Department getDepartmentById(long did) {
		Optional<Department> optional=departmentRepository.findById(did);
		if (optional.isPresent()) {
			Department department=optional.get();
			return department;
		}
		return null;
	}

}
