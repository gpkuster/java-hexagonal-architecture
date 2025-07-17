package com.example.mapping_demo.adapter.in.web;

import com.example.mapping_demo.adapter.in.web.dto.UserDto;
import com.example.mapping_demo.domain.model.User;
import com.example.mapping_demo.domain.port.in.CreateUserUseCase;
import com.example.mapping_demo.domain.port.in.GetAllUsersUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// Primary adapter - controller
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;

    // Primary adapters call interfaces

    @PostMapping
    public User createUser(@RequestBody UserDto dto) {
        User user = new User(null, dto.getName(), dto.getEmail());
        return createUserUseCase.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return getAllUsersUseCase.getAllUsers();
    }

}
