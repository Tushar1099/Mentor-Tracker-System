package com.example.courseservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class CourseTest {
    
    @Test
    void testConstructor() {
        Course actualCourse = new Course();
        actualCourse.setCourseId(1);
        actualCourse.setCourseName("Course Name");
        LocalTime courseTime = LocalTime.MIDNIGHT;
        actualCourse.setCourseTime(courseTime);
        assertEquals(1, actualCourse.getCourseId());
        assertEquals("Course Name", actualCourse.getCourseName());
        LocalTime expectedCourseTime = courseTime.MIN;
        assertSame(expectedCourseTime, actualCourse.getCourseTime());
    }

    @Test
    void testConstructor2() {
        Course actualCourse = new Course(1, "Course Name", LocalTime.MIDNIGHT);
        actualCourse.setCourseId(1);
        actualCourse.setCourseName("Course Name");
        LocalTime courseTime = LocalTime.MIDNIGHT;
        actualCourse.setCourseTime(courseTime);
        assertEquals(1, actualCourse.getCourseId());
        assertEquals("Course Name", actualCourse.getCourseName());
        LocalTime expectedCourseTime = courseTime.MIN;
        assertSame(expectedCourseTime, actualCourse.getCourseTime());
    }
}