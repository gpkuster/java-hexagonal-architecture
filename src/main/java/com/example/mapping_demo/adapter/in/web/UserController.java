package com.example.mapping_demo.adapter.in.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapping_demo.adapter.in.web.dto.UserDto;
import com.example.mapping_demo.domain.port.in.CreateUserUseCase;

// Adaptador primario - controlador
@RestController
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody UserDto userDto) {
        createUserUseCase.createUser(userDto); // LLAMA a una interfaz
    }
    
}
