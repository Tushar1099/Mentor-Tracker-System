package com.example.userservice.dto;

import com.example.userservice.entity.UserRole;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
	
	@Id
	private int id;
	
	@NotEmpty(message = "Name can not be empty")
	private String name;
	
	@Email(message = "email is not valid")
	private String email;
	
	@NotNull
	private UserRole userRole;

}
