package com.example.taskservice.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
	
	private int taskId;
	
	private int userId;
	private int courseId;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalTime hoursPerDay;
}
