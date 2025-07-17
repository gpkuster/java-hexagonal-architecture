// adapter/out/persistence/UserRepositoryImpl.java
package com.example.mapping_demo.adapter.out.persistence;

import com.example.mapping_demo.domain.model.User;
import com.example.mapping_demo.domain.port.out.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> db = new HashMap<>();

    @Override
    public User save(User user) {
        // Simulación de persistencia en memoria
        if (user.getId() == null) {
            user.setId(UUID.randomUUID().toString());
        }
        db.put(user.getId(), user);
        return user;
    }
}
