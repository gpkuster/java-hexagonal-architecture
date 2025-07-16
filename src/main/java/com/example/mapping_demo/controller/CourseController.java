package com.example.mapping_demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapping_demo.model.Course;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class CourseController {

    private List<Course> courses;

    // Method to be executed after Bean's creation and injection (or controller's instantiation), and before the Bean can be used
    @PostConstruct
    public void init() {
        courses = new ArrayList<>();
        courses.add(new Course("Spring", 25, "Evening"));
        courses.add(new Course("Spring", 20, "Morning"));
        courses.add(new Course("Python", 15, "Morning"));
        courses.add(new Course("Cloud", 20, "Morning"));
        courses.add(new Course("SQL", 25, "Evening"));
    }

    @GetMapping(value = "all-courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getAllCoursesJson() {
        return courses;
    }
    
    @GetMapping(value = "course", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getJsonCourse() {
        return new Course("Java", 100, "Evening");
    }

    @GetMapping(value = "all-courses/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findCourses(@PathVariable("name") String name) {
        return courses.stream()
            .filter(c -> c.getName().equalsIgnoreCase(name))
            .toList();
    }

    @DeleteMapping(value = "course/v1/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> deleteCourse(@PathVariable("name") String name) {
        List<Course> aux = new ArrayList<>();
        aux = courses.stream()
            .filter(c -> !c.getName().equalsIgnoreCase(name))
            .toList();
        courses = aux;
        return aux;
    }

    @DeleteMapping(value = "course/v2/{name}")
    public void deleteCoursev2(@PathVariable("name") String name) {
        courses.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }
    
    @PostMapping(value = "course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> postMethodName(@RequestBody Course course) {
        courses.add(course);
        return courses;
    }

    @PutMapping(value = "course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String putMethodName(@RequestBody Course entity) {
        for(int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equalsIgnoreCase(entity.getName())) {
                courses.set(i, entity);
                return "Updated: " + entity.getName();
            }
        }
        return "No such course found to update: " + entity.getName();
    }
    
}
