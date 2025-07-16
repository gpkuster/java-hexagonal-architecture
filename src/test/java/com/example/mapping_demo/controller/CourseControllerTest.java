package com.example.mapping_demo.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import lombok.SneakyThrows;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CourseControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @Test
    @SneakyThrows
    @Order(0)
    void testGet () {
        mockMvc.perform(get("/all-courses")).andDo(print());
    }

    @Test
    @SneakyThrows
    @Order(1)
    void deleteCourse() {
        mockMvc.perform(delete("/course/v1/Spring")).andDo(print());
    }

    @Test
    @SneakyThrows
    @Order(1)
    void postCourse() {
        mockMvc.perform(post("/course")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" + //
                                "    \"name\": \"Java\",\n" + //
                                "    \"duration\": 30,\n" + //
                                "    \"timetable\": \"Morning\"\n" + //
                                "}")
        ).andDo(print());
    }

}
