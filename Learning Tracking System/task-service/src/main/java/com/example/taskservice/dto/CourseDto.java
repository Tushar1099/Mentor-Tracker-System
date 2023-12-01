package com.example.taskservice.dto;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int courseId;
	private String courseName;
	private LocalTime courseTime;
}
