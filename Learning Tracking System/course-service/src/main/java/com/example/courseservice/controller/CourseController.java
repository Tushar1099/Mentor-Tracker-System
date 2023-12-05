package com.example.courseservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courseservice.dto.CourseDto;
import com.example.courseservice.service.CourseService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/courses")
public class CourseController {
	
	private CourseService courseService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

	@PostMapping("/add")
	public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto course){
		LOGGER.info("Inside CourseController - createCourse");
		CourseDto savedCourse = courseService.createCourse(course);
		return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{courseId}")
	public ResponseEntity<CourseDto> getUserById(@PathVariable int courseId){
		LOGGER.info("Inside CourseController - getUserById");
		CourseDto user = courseService.getCourseById(courseId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CourseDto>> getAllCourses(){
		LOGGER.info("Inside CourseController - getAllCourses");
		List<CourseDto> users = courseService.getAllCourses();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PutMapping("/update/{courseId}")
	public ResponseEntity<CourseDto> updateUser(@PathVariable int courseId, 
												 @RequestBody CourseDto course){
		LOGGER.info("Inside CourseController - updateCourse");
		course.setCourseId(courseId);
		CourseDto updatedUser  = courseService.updateCourse(course);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{courseId}")
	public ResponseEntity<String> deleteUser(@PathVariable int courseId){
		LOGGER.info("Inside CourseController - deleteCourse");
		courseService.deleteCourse(courseId);
		return new ResponseEntity<>("Course Deleted Successfully",HttpStatus.OK);
	}
}