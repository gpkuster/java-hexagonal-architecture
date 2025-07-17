package com.example.mapping_demo.adapter.out.persistence.repository;

import com.example.mapping_demo.adapter.out.persistence.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCourseRepository extends JpaRepository<CourseEntity, String> {
}
