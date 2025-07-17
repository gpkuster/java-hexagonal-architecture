package com.example.mapping_demo.adapter.out.persistence;

import com.example.mapping_demo.adapter.out.persistence.entity.CourseEntity;
import com.example.mapping_demo.adapter.out.persistence.repository.JpaCourseRepository;
import com.example.mapping_demo.domain.model.Course;
import com.example.mapping_demo.domain.port.out.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

// Secondary adapter - implements a port
@Repository
@AllArgsConstructor
public class CourseRepositoryImpl implements CourseRepository {

    private final JpaCourseRepository jpaCourseRepository;

    @Override
    public Course save(Course course) {
        if (course.getId() == null) {
            course.setId(UUID.randomUUID().toString());
        }

        val entity = new CourseEntity();
        entity.setId(course.getId());
        entity.setName(course.getName());
        entity.setDuration(course.getDuration());
        entity.setTimetable(course.getTimetable());

        CourseEntity saved = jpaCourseRepository.save(entity);

        return new Course(saved.getId(), saved.getName(), saved.getDuration(), saved.getTimetable());
    }

    @Override
    public List<Course> findAll() {
        List<CourseEntity> entities = jpaCourseRepository.findAll();
        return entities.stream()
                .map(e -> new Course(e.getId(), e.getName(), e.getDuration(), e.getTimetable()))
                .toList();
    }
}
