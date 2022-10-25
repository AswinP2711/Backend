package com.springboot.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.api.model.Employee;
import com.springboot.api.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee inserEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees(Pageable pageable) {
		return employeeRepository.findAll();
	}

	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}

	public Employee findEmployeeById(long id) {
		Optional<Employee> optional=employeeRepository.findById(id);
		if (optional.isPresent()) {
			Employee employee=optional.get();
			return employee;
		}
		return null;
	}

	public List<Employee> getEmployeeByCity(String city) {
		return employeeRepository.findByCity(city);
	}

	public List<Employee> getEmployeeByDepartment(Long did) {
		return employeeRepository.findByDepartmentId(did);
	}

	public List<Employee> getEmployeeByCityV2(String city) {
		return employeeRepository.findEmployeeByCityV2(city);
	}

	public List<Employee> getEmployeeByDepartmentV2(Long did) {
		return employeeRepository.findByDepartmentIdV2(did);
	}
}
