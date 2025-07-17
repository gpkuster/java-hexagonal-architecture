package com.example.mapping_demo.adapter.in.web;

import com.example.mapping_demo.adapter.in.web.dto.CourseDto;
import com.example.mapping_demo.domain.model.Course;
import com.example.mapping_demo.domain.port.in.CreateCourseUseCase;
import com.example.mapping_demo.domain.port.in.GetAllCoursesUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController {

    private final CreateCourseUseCase createCourseUseCase;
    private final GetAllCoursesUseCase getAllCoursesUseCase;

    // Primary adapters call interfaces

    @PostMapping
    public Course createUser(@RequestBody CourseDto dto) {
        Course course = new Course(null, dto.getName(), dto.getDuration(), dto.getTimetable());
        return createCourseUseCase.createCourse(course);
    }

    @GetMapping
    public List<Course> getAllUsers() {
        return getAllCoursesUseCase.findAll();
    }
}
