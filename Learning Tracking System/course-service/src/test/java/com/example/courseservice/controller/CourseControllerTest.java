package com.example.courseservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.courseservice.dto.CourseDto;
import com.example.courseservice.entity.Course;
import com.example.courseservice.repository.CourseRepository;
import com.example.courseservice.service.serviceImpl.CourseServiceImpl;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

class CourseControllerTest {
  
    @Test
    void testCreateCourse() {

        CourseRepository courseRepository = mock(CourseRepository.class);
        when(courseRepository.save(Mockito.<Course>any())).thenReturn(new Course());
        CourseController courseController = new CourseController(
                new CourseServiceImpl(courseRepository, new ModelMapper()));
        ResponseEntity<CourseDto> actualCreateCourseResult = courseController.createCourse(new CourseDto());
        assertTrue(actualCreateCourseResult.hasBody());
        assertTrue(actualCreateCourseResult.getHeaders().isEmpty());
        assertEquals(201, actualCreateCourseResult.getStatusCodeValue());
        CourseDto body = actualCreateCourseResult.getBody();
        assertNull(body.getCourseName());
        assertEquals(0, body.getCourseId());
        assertNull(body.getCourseTime());
        verify(courseRepository).save(Mockito.<Course>any());
    }

 
    @Test
    void testGetUserById() {
        

        CourseRepository courseRepository = mock(CourseRepository.class);
        when(courseRepository.findById(Mockito.<Integer>any())).thenReturn(Optional.of(new Course()));
        ResponseEntity<CourseDto> actualUserById = (new CourseController(
                new CourseServiceImpl(courseRepository, new ModelMapper()))).getUserById(1);
        assertTrue(actualUserById.hasBody());
        assertTrue(actualUserById.getHeaders().isEmpty());
        assertEquals(200, actualUserById.getStatusCodeValue());
        CourseDto body = actualUserById.getBody();
        assertNull(body.getCourseName());
        assertEquals(0, body.getCourseId());
        assertNull(body.getCourseTime());
        verify(courseRepository).findById(Mockito.<Integer>any());
    }

    @Test
    void testGetAllCourses() {

        CourseRepository courseRepository = mock(CourseRepository.class);
        ArrayList<Course> courseList = new ArrayList<>();
        when(courseRepository.findAll()).thenReturn(courseList);
        ResponseEntity<List<CourseDto>> actualAllCourses = (new CourseController(
                new CourseServiceImpl(courseRepository, new ModelMapper()))).getAllCourses();
        assertEquals(courseList, actualAllCourses.getBody());
        assertEquals(200, actualAllCourses.getStatusCodeValue());
        assertTrue(actualAllCourses.getHeaders().isEmpty());
        verify(courseRepository).findAll();
    }

    @Test
    void testUpdateUser() {

        CourseRepository courseRepository = mock(CourseRepository.class);
        when(courseRepository.save(Mockito.<Course>any())).thenReturn(new Course());
        when(courseRepository.findById(Mockito.<Integer>any())).thenReturn(Optional.of(new Course()));
        CourseController courseController = new CourseController(
                new CourseServiceImpl(courseRepository, new ModelMapper()));
        CourseDto course = new CourseDto();
        ResponseEntity<CourseDto> actualUpdateUserResult = courseController.updateUser(1, course);
        assertTrue(actualUpdateUserResult.hasBody());
        assertTrue(actualUpdateUserResult.getHeaders().isEmpty());
        assertEquals(200, actualUpdateUserResult.getStatusCodeValue());
        CourseDto body = actualUpdateUserResult.getBody();
        assertNull(body.getCourseName());
        assertEquals(0, body.getCourseId());
        assertNull(body.getCourseTime());
        verify(courseRepository).save(Mockito.<Course>any());
        verify(courseRepository).findById(Mockito.<Integer>any());
        assertEquals(1, course.getCourseId());
    }

    @Test
    void testDeleteUser() {

        CourseRepository courseRepository = mock(CourseRepository.class);
        doNothing().when(courseRepository).deleteById(Mockito.<Integer>any());
        when(courseRepository.findById(Mockito.<Integer>any())).thenReturn(Optional.of(new Course()));
        ResponseEntity<String> actualDeleteUserResult = (new CourseController(
                new CourseServiceImpl(courseRepository, new ModelMapper()))).deleteUser(1);
        assertEquals("Course Deleted Successfully", actualDeleteUserResult.getBody());
        assertEquals(200, actualDeleteUserResult.getStatusCodeValue());
        assertTrue(actualDeleteUserResult.getHeaders().isEmpty());
        verify(courseRepository).findById(Mockito.<Integer>any());
        verify(courseRepository).deleteById(Mockito.<Integer>any());
    }

}