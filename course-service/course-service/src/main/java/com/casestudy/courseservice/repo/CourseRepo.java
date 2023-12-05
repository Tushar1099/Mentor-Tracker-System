package com.casestudy.courseservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.courseservice.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long>{

}
