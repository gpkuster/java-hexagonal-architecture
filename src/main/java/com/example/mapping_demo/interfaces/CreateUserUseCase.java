package com.example.mapping_demo.interfaces;

import com.example.mapping_demo.model.UserDto;

public interface CreateUserUseCase {
    void createUser(UserDto userDto);
}