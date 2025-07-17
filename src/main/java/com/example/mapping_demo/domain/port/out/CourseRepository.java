package com.example.mapping_demo.domain.port.out;

import com.example.mapping_demo.domain.model.Course;

import java.util.List;

// Secondary port - Repository interface
public interface CourseRepository {
    Course save(Course course);

    List<Course> findAll();
}
