package com.springboot.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByCity(String city);

	List<Employee> findByDepartmentId(Long did);
	
	@Query("select e from Employee e where e.city=?1")
	List<Employee> findEmployeeByCityV2(String city);
	
	@Query("select e from Employee e where e.department.id=?1")
	List<Employee> findByDepartmentIdV2(Long did);

}
