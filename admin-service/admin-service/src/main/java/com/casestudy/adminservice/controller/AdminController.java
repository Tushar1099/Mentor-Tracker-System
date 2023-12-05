package com.casestudy.adminservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.adminservice.dto.AdminDto;
import com.casestudy.adminservice.service.AdminService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/admin-data")
@RestController
public class AdminController {

	private AdminService adminService;
	
	@PostMapping
	public ResponseEntity<AdminDto> saveAdmin(@RequestBody AdminDto adminDto){
		AdminDto saveAdminDto = adminService.saveAdminAdo(adminDto);
		return new ResponseEntity<>(saveAdminDto,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/get-admin/{adminId}")
	public ResponseEntity<AdminDto> getAdmin(@PathVariable Long adminId){
		AdminDto getAdminDto = adminService.getAdminById(adminId);
		return new ResponseEntity<>(getAdminDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{adminId}")
	public ResponseEntity<String> deleteAdmin(@PathVariable Long userId){
		adminService.deleteAdmin(userId);
		return new ResponseEntity<>("Admin deleted successfully", HttpStatus.OK);
	}
}
