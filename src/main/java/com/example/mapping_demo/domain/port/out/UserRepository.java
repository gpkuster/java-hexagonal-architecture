package com.example.mapping_demo.domain.port.out;

import com.example.mapping_demo.domain.model.User;

import java.util.List;

// Secondary port - Repository interface
public interface UserRepository {
    User save(User user);
    List<User> findAll();
}