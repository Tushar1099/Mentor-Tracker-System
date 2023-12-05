package com.casestudy.adminservice.mapper;

import com.casestudy.adminservice.dto.AdminDto;
import com.casestudy.adminservice.entity.Admin;

public class AdminMapper {

	public static Admin mapToAdmin(AdminDto adminDto) {
		Admin admin = new Admin(
				adminDto.getAdminId(),
				adminDto.getAdminName(),
				adminDto.getAdminEmail(),
				adminDto.getPassword()
		);
		return admin;
	}
	
	public static AdminDto mapToAdminDto(Admin admin) {
		AdminDto adminDto = new AdminDto(
				admin.getAdminId(),
				admin.getAdminName(),
				admin.getAdminEmail(),
				admin.getPassword()
		);
		return adminDto;
	}
}
