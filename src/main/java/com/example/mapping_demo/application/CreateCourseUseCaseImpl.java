package com.example.mapping_demo.application;

import com.example.mapping_demo.domain.model.Course;
import com.example.mapping_demo.domain.port.in.CreateCourseUseCase;
import com.example.mapping_demo.domain.port.out.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCourseUseCaseImpl implements CreateCourseUseCase {
    private final CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
}
