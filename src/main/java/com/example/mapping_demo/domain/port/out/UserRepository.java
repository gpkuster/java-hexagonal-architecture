package com.example.mapping_demo.domain.port.out;

import com.example.mapping_demo.domain.model.User;

public interface UserRepository {
    User save(User user);
}