package com.example.mapping_demo.application;

import com.example.mapping_demo.domain.model.User;
import com.example.mapping_demo.domain.port.in.GetAllUsersUseCase;
import com.example.mapping_demo.domain.port.out.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {

    private final UserRepository userRepository;

    public GetAllUsersUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}