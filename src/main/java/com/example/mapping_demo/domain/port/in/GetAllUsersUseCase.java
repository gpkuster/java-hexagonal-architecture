package com.example.mapping_demo.domain.port.in;

import com.example.mapping_demo.domain.model.User;

import java.util.List;

public interface GetAllUsersUseCase {
    List<User> getAllUsers();
}