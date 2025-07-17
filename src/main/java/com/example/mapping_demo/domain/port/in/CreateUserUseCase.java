package com.example.mapping_demo.domain.port.in;

import com.example.mapping_demo.domain.model.User;

// Primary port - Use case interface
public interface CreateUserUseCase {
    User createUser(User user);
}