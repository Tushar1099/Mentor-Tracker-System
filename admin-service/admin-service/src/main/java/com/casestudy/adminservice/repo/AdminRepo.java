package com.casestudy.adminservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.adminservice.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long>{
	
}
