package com.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
}
