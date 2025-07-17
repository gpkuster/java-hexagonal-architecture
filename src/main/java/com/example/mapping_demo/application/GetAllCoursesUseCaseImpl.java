package com.example.mapping_demo.application;

import com.example.mapping_demo.domain.model.Course;
import com.example.mapping_demo.domain.port.in.GetAllCoursesUseCase;
import com.example.mapping_demo.domain.port.out.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllCoursesUseCaseImpl implements GetAllCoursesUseCase {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
