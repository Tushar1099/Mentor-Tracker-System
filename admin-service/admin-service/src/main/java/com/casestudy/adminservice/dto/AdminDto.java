package com.casestudy.adminservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdminDto {
	private Long adminId;
	private String adminName;
	private String adminEmail;
	private String password;
}
