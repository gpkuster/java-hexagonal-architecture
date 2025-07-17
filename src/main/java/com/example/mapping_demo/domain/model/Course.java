package com.example.mapping_demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getters are needed for jackson serialization
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private String name;
    private int duration;
    private String timetable;
    
}
