// adapter/out/persistence/entity/UserEntity.java
package com.example.mapping_demo.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {

    @Id
    private String id;

    private String name;
    private int duration;
    private String timetable;

}
