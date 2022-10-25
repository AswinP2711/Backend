package com.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.model.Course;


public interface CourseRepository extends JpaRepository<Course, Long>{

}
