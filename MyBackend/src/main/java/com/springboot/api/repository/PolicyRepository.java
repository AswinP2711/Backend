package com.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long>{

}
