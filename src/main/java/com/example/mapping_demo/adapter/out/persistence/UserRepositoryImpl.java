// adapter/out/persistence/UserRepositoryImpl.java
package com.example.mapping_demo.adapter.out.persistence;

import com.example.mapping_demo.adapter.out.persistence.entity.UserEntity;
import com.example.mapping_demo.adapter.out.persistence.repository.JpaUserRepository;
import com.example.mapping_demo.domain.model.User;
import com.example.mapping_demo.domain.port.out.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID().toString());
        }

        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());

        UserEntity saved = jpaUserRepository.save(entity);

        return new User(saved.getId(), saved.getName(), saved.getEmail());
    }
}
