package com.example.mapping_demo.domain.port.in;

import com.example.mapping_demo.domain.model.Course;

// Primary port - Use case interface
public interface CreateCourseUseCase {
    Course createCourse(Course course);
}
