package com.example.taskservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskservice.dto.TaskDto;
import com.example.taskservice.service.TaskService;
import com.example.taskservice.dto.TaskCourseDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tasks")

public class TaskController {
	
	private TaskService taskService;

	
	
	@PostMapping("/{id}/{courseId}")
	public ResponseEntity<TaskDto> postTask(@RequestBody TaskDto taskDto,
				@PathVariable int id,
				@PathVariable int courseId) {
		
		taskDto.setUserId(id);
		taskDto.setCourseId(courseId);
		TaskDto savedTask = taskService.createTask(taskDto);
		return new ResponseEntity<>(savedTask,HttpStatus.OK);
		
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<List<TaskCourseDto>> getAllTaskByUserId(@PathVariable int id) {
		
		List<TaskCourseDto> savedTask = taskService.getTaskListById(id);
		return new ResponseEntity<>(savedTask,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{courseId}")
	public ResponseEntity<String> deleteUser(@PathVariable int taskId){
		taskService.deleteTask(taskId);
		return new ResponseEntity<>("Course Deleted Successfully",HttpStatus.OK);
	}
	
	@GetMapping("/byid/{taskId}")
	public ResponseEntity<TaskDto> getTaskById(@PathVariable int taskId) {
		
		TaskDto savedTask = taskService.getTaskById(taskId);
		return new ResponseEntity<>(savedTask,HttpStatus.OK);
	}
}