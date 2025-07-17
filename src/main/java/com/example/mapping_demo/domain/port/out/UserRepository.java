package com.example.mapping_demo.domain.port.out;

import java.util.List;

import com.example.mapping_demo.domain.model.User;

public interface UserRepository {
    User save(User user);
    List<User> findAll();
}