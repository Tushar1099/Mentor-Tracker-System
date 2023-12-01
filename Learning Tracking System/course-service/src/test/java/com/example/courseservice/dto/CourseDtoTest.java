package com.example.courseservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class CourseDtoTest {
    
    @Test
    void testConstructor() {
        CourseDto actualCourseDto = new CourseDto();
        actualCourseDto.setCourseId(1);
        actualCourseDto.setCourseName("Course Name");
        LocalTime courseTime = LocalTime.MIDNIGHT;
        actualCourseDto.setCourseTime(courseTime);
        assertEquals(1, actualCourseDto.getCourseId());
        assertEquals("Course Name", actualCourseDto.getCourseName());
        LocalTime expectedCourseTime = courseTime.MIN;
        assertSame(expectedCourseTime, actualCourseDto.getCourseTime());
    }

   
    @Test
    void testConstructor2() {
        CourseDto actualCourseDto = new CourseDto(1, "Course Name", LocalTime.MIDNIGHT);
        actualCourseDto.setCourseId(1);
        actualCourseDto.setCourseName("Course Name");
        LocalTime courseTime = LocalTime.MIDNIGHT;
        actualCourseDto.setCourseTime(courseTime);
        assertEquals(1, actualCourseDto.getCourseId());
        assertEquals("Course Name", actualCourseDto.getCourseName());
        LocalTime expectedCourseTime = courseTime.MIN;
        assertSame(expectedCourseTime, actualCourseDto.getCourseTime());
    }
}