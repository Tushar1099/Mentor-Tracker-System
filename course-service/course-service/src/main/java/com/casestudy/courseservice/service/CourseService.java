package com.casestudy.courseservice.service;

import java.util.List;

import com.casestudy.courseservice.dto.CourseDto;

public interface CourseService {
	
	CourseDto createCourse(CourseDto courseDto);

	CourseDto getCourseByID(Long courseId);

	List<CourseDto> getAllCourses();

	CourseDto updateCourse(CourseDto courseDto);

	void deleteCourse(Long courseId);
}
