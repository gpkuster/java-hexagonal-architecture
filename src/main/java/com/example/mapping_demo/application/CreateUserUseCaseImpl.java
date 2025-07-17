// application/CreateUserUseCaseImpl.java
package com.example.mapping_demo.application;

import com.example.mapping_demo.domain.model.User;
import com.example.mapping_demo.domain.port.in.CreateUserUseCase;
import com.example.mapping_demo.domain.port.out.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
