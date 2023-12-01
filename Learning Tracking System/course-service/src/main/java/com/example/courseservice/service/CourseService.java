package com.example.courseservice.service;

import java.util.List;

import com.example.courseservice.dto.CourseDto;

public interface CourseService {
	

	CourseDto createCourse(CourseDto course);
	
	CourseDto getCourseById(int courseId);
	
	List<CourseDto> getAllCourses();
	
	CourseDto updateCourse(CourseDto course);
	
	void deleteCourse(int courseId);
}