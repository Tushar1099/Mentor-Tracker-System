package com.casestudy.courseservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.courseservice.dto.CourseDto;
import com.casestudy.courseservice.entity.Course;
import com.casestudy.courseservice.mapper.CourseMapper;
import com.casestudy.courseservice.repo.CourseRepo;
import com.casestudy.courseservice.service.CourseService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{

	private CourseRepo courseRepo;
	
	@Override
	public CourseDto createCourse(CourseDto courseDto) {
		
		Course course = CourseMapper.mapToCourse(courseDto);
		Course savedCourse = courseRepo.save(course);
		CourseDto savedCourseDto = CourseMapper.mapToCourseDto(savedCourse);
		return savedCourseDto;
	}

	@Override
	public CourseDto getCourseByID(Long courseId) {
		Course course = courseRepo.findById(courseId).get();
		CourseDto courseDto = CourseMapper.mapToCourseDto(course);
		return courseDto;
	}

	@Override
	public List<CourseDto> getAllCourses() {
		List<Course> allCourses = courseRepo.findAll();
		List<CourseDto> courseList = new ArrayList(); 
		for (Course course : allCourses) {
			courseList.add(CourseMapper.mapToCourseDto(course));
		}
		return courseList;
	}

	@Override
	public CourseDto updateCourse(CourseDto courseDto) {
		Course courseExist = courseRepo.findById(courseDto.getCourseId()).get();
		courseExist.setCourseName(courseDto.getCourseName());
		courseExist.setCourseId(courseDto.getCourseId());
		courseExist.setCourseTime(courseDto.getCourseTime());
		Course updateCourse = courseRepo.save(courseExist);
		
		return CourseMapper.mapToCourseDto(updateCourse);
	}

	@Override
	public void deleteCourse(Long courseId) {
		courseRepo.deleteById(courseId);
		
	}
	
}
