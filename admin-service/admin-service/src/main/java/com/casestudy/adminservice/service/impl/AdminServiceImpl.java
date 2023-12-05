package com.casestudy.adminservice.service.impl;

import org.springframework.stereotype.Service;

import com.casestudy.adminservice.dto.AdminDto;
import com.casestudy.adminservice.entity.Admin;
import com.casestudy.adminservice.mapper.AdminMapper;
import com.casestudy.adminservice.repo.AdminRepo;
import com.casestudy.adminservice.service.AdminService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService{

	public AdminRepo adminRepo;
	@Override
	public AdminDto saveAdminAdo(AdminDto adminDto) {
		Admin admin = AdminMapper.mapToAdmin(adminDto);
		Admin savedAdmin =  adminRepo.save(admin);
		AdminDto savedAdminDto = AdminMapper.mapToAdminDto(savedAdmin);
		return savedAdminDto;
	}
	
	@Override
	public AdminDto getAdminById(Long adminId) {
		Admin admin = adminRepo.findById(adminId).get();
		AdminDto foundAdmin = AdminMapper.mapToAdminDto(admin);
		return foundAdmin;
	}

	@Override
	public void deleteAdmin(Long adminId) {
		adminRepo.deleteById(adminId);		
	}
	
	
	

	
}
