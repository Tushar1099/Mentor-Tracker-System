package com.casestudy.courseservice.mapper;

import com.casestudy.courseservice.dto.CourseDto;
import com.casestudy.courseservice.entity.Course;

public class CourseMapper {
	
public static CourseDto mapToCourseDto(Course course) {
		
		CourseDto courseDto = new CourseDto(
			course.getCourseId(),
			course.getCourseName(),
			course.getCourseTime()
		);
		return courseDto;
	}
	
	public static Course mapToCourse(CourseDto courseDto) {
		
		Course course = new Course(
				courseDto.getCourseId(),
				courseDto.getCourseName(),
				courseDto.getCourseTime()
			);
		return course;
	}
}
