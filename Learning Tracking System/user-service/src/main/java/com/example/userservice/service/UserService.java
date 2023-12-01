package com.example.userservice.service;

import java.util.List;

import com.example.userservice.dto.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto getUserById(int id);
	
	List<UserDto> getAllUsers();
	
	UserDto updateUser(UserDto user);
	
	void deleteUser(int id);
}
