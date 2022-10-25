package com.springboot.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.model.Department;
import com.springboot.api.model.Employee;
import com.springboot.api.service.DepartmentService;
import com.springboot.api.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/employee/add/{did}")
	public Employee insertEmployee(@RequestBody Employee employee,@PathVariable("did") Long did) {
		Department department=departmentService.getDepartmentById(did);
		employee.setDepartment(department);
		employee= employeeService.inserEmployee(employee);
		return employee;
	}
	
	@GetMapping("/employee/all")
	public List<Employee> getAllEmployees(@RequestParam("page") Integer page,@RequestParam("size") Integer size){
		Pageable pageable=PageRequest.of(page, size);
		List<Employee> list=employeeService.getAllEmployees(pageable);
		return list;
	}
	
	@DeleteMapping("/employee/delete/v1/{id}")
	public void deleteByIdV1(@PathVariable("id") Long id) {
		employeeService.deleteById(id);
	}
	
	@DeleteMapping("/employee/delete/v2")
	public void deleteByIdV2(@RequestParam("id") Long id) {
		employeeService.deleteById(id);
	}
	
	@PutMapping("/employee/edit/{id}")
	public Employee ediEmployee(@PathVariable("id") Long id,@RequestBody Employee employeeNew) {
		Employee employeeDB=employeeService.findEmployeeById(id);
		if (employeeDB == null) {
			throw new RuntimeException("Id Invalid");
		}
		employeeDB.setName(employeeNew.getName());
		employeeDB.setCity(employeeNew.getCity());
		employeeDB.setSalary(employeeNew.getSalary());
		
		employeeDB=employeeService.inserEmployee(employeeDB);
		return employeeDB;
	}
	
	@GetMapping("/employee/city/v1")
	public List<Employee> getEmployeeByCity(@RequestParam("city") String city){
		return employeeService.getEmployeeByCity(city);
	}
	
	@GetMapping("/employee/department/{did}")
	public List<Employee> getEmployeeByDepartment(@PathVariable("did") Long did){
		return employeeService.getEmployeeByDepartment(did);
	}
	
	/* Get all employee that belong to certain city JPQL*/
	@GetMapping("/employee/city/v2")
	public List<Employee> getEmployeeByCityV2(@RequestParam("city") String city){
		return employeeService.getEmployeeByCityV2(city);
	}
	
	/* Get all employee that belong to certain department JPQL*/
	@GetMapping("/employee/department/v2/{did}")
	public List<Employee> getEmployeeByDepartmentV2(@PathVariable("did") Long did){
		return employeeService.getEmployeeByDepartmentV2(did);
	}
}

