package com.example.taskservice.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskservice.dto.CourseDto;
import com.example.taskservice.dto.TaskCourseDto;
import com.example.taskservice.dto.TaskDto;
import com.example.taskservice.dto.UserDto;
import com.example.taskservice.dto.UserRole;
import com.example.taskservice.entity.Task;
import com.example.taskservice.exception.ResourceNotFoundException;
import com.example.taskservice.repository.TaskRepository;
import com.example.taskservice.service.TaskService;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TaskServiceImpl implements TaskService {

	   @Autowired
	    private TaskRepository taskRepository;

	   	@Autowired
	   	private WebClient webClient;
	   	
	    @Autowired
	    private ModelMapper modelMapper;

	    @Override
	    public TaskDto createTask(TaskDto taskDto) {
	    	UserDto user = getUserByWebClient(taskDto.getUserId());
			if (user.getUserRole().equals(UserRole.ADMIN)) {
				throw new RuntimeException("Admin cannnot be enrolled to course");
			}
			getCourseByWebClient(taskDto.getCourseId());
			Task task = modelMapper.map(taskDto, Task.class);
			Task savedTask = taskRepository.save(task);
			return modelMapper.map(savedTask, TaskDto.class);
	    }

	    @Override
		public List<TaskCourseDto> getTaskListById(int taskId) {
			
			List<Task> listTask = taskRepository.findByUserId(taskId);
			
			return listTask.stream().map((task)->
					new TaskCourseDto(
						
							task.getTaskId(),
							task.getUserId(),
							getCourseByWebClient(task.getCourseId()),
							task.getStartDate(),
							task.getEndDate(),
							task.getHoursPerDay()
					))
					.collect(Collectors.toList());
			
		}

	    @Override
	    public List<TaskDto> getAllTasks() {
	        List<Task> tasks = taskRepository.findAll();
	        return tasks.stream()
	                .map(task -> modelMapper.map(task, TaskDto.class))
	                .collect(Collectors.toList());
	    }


	    @Override
	    public void deleteTask(int taskId) {
	        taskRepository.findById(taskId).orElseThrow(
	                () -> new ResourceNotFoundException("Task", "id", taskId));
	        taskRepository.deleteById(taskId);
	    }
	    
	    private UserDto getUserByWebClient(int id) {

			UserDto dto = webClient.get()
					.uri("http://localhost:8080/api/users/get/" + id)
					.retrieve()
					.bodyToMono(UserDto.class).block();

			return dto;

		}
	    
	    private CourseDto getCourseByWebClient(int courseId) {
			CourseDto dto;
			try {
				dto = webClient.get()
						.uri("http://localhost:8082/api/courses/get/" + courseId)
						.retrieve()
						.bodyToMono(CourseDto.class).block();
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
			return dto;
	    }

		@Override
		public TaskDto getTaskById(int taskId) {
//			Task task = taskRepository.findById(taskId).orElseThrow(
//					() -> new ResourceNotFoundException("Task", "id", taskId));
			
			
			Optional<Task> task = taskRepository.findById(taskId);
				Task tasks = task.get();
				
			return modelMapper.map(tasks, TaskDto.class);
		}

}
