package com.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
