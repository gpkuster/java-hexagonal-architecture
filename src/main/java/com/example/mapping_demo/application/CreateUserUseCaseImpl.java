// application/CreateUserUseCaseImpl.java
package com.example.mapping_demo.application;

import org.springframework.stereotype.Service;

import com.example.mapping_demo.domain.model.User;
import com.example.mapping_demo.domain.port.in.CreateUserUseCase;
import com.example.mapping_demo.domain.port.out.UserRepository;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
