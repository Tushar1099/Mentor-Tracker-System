package com.example.taskservice.dto;

import java.time.LocalDate;
import java.time.LocalTime;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskCourseDto {
	
	private int taskId;
	
	private int userId;
	
	private CourseDto courseDto;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private LocalTime hoursAPerDay;
}
