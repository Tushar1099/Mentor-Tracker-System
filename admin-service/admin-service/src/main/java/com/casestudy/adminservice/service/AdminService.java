package com.casestudy.adminservice.service;

import com.casestudy.adminservice.dto.AdminDto;

public interface AdminService {

	AdminDto saveAdminAdo(AdminDto adminDto);
	
	AdminDto getAdminById(Long adminId);
	
	void deleteAdmin(Long adminId);
}
