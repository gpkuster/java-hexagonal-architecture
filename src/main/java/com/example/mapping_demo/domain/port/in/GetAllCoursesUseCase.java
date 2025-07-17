package com.example.mapping_demo.domain.port.in;

import com.example.mapping_demo.domain.model.Course;

import java.util.List;

// Primary port - Use case interface
public interface GetAllCoursesUseCase {
    List<Course> findAll();
}
