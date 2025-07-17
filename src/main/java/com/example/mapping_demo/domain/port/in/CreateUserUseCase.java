package com.example.mapping_demo.domain.port.in;

import com.example.mapping_demo.domain.model.User;

public interface CreateUserUseCase {
    User createUser(User userDto);
}