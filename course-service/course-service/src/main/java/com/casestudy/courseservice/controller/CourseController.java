package com.casestudy.courseservice.controller;

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

import com.casestudy.courseservice.dto.CourseDto;
import com.casestudy.courseservice.service.impl.CourseServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/course-data")
@RestController
public class CourseController {

	private CourseServiceImpl courseService;
	
	@PostMapping
	public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
		CourseDto savedCourse = courseService.createCourse(courseDto);
		return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable("id") Long courseId){
		CourseDto courseDto = courseService.getCourseByID(courseId);
		return new ResponseEntity<>(courseDto,HttpStatus.OK);
	}
	
	@GetMapping("/allCourses")
	public ResponseEntity<List<CourseDto>> getAllCourses(){
		List<CourseDto> allCourses = courseService.getAllCourses();
		return new ResponseEntity<>(allCourses,HttpStatus.OK);
	}
	
	@PutMapping("/update-course/{id}")
	public ResponseEntity<CourseDto> updateCourseById(@PathVariable("id") Long courseId, @RequestBody CourseDto courseDto){
		courseDto.setCourseId(courseId);
		CourseDto updatedCourse = courseService.updateCourse(courseDto);
		return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
		
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteById(@PathVariable Long courseId){
		courseService.deleteCourse(courseId);
		return new ResponseEntity<String>("Course deleted successfully.",HttpStatus.OK);
	}
}
