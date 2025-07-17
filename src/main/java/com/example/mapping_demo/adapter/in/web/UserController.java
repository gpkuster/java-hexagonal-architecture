package com.example.mapping_demo.adapter.in.web;

import com.example.mapping_demo.domain.port.in.CreateUserUseCase;
import com.example.mapping_demo.domain.model.User;
import com.example.mapping_demo.adapter.in.web.dto.UserDto;
import org.springframework.web.bind.annotation.*;


// Primary adapter - controller
@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public User createUser(@RequestBody UserDto dto) {
        User user = new User(null, dto.getName(), dto.getEmail());
        return createUserUseCase.createUser(user);
    }
}
