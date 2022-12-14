package com.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.api.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

	@Query("select v from Vendor v where v.user.username=?1")
	Vendor getVendorDetails(String username);

}
