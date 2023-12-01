package com.example.taskservice.service;

import java.util.List;

import com.example.taskservice.dto.TaskCourseDto;
import com.example.taskservice.dto.TaskDto;

public interface TaskService {

	TaskDto createTask(TaskDto task);
	
	TaskDto getTaskById(int taskId);
	
	List<TaskDto> getAllTasks();
	
	void deleteTask(int taskId);

	List<TaskCourseDto> getTaskListById(int taskId);
}

