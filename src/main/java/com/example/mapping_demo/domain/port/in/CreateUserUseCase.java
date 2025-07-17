package com.example.mapping_demo.domain.port.in;

import com.example.mapping_demo.adapter.in.web.dto.UserDto;

public interface CreateUserUseCase {
    void createUser(UserDto userDto);
}