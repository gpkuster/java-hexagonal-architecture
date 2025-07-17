// adapter/out/persistence/UserRepositoryImpl.java
package com.example.mapping_demo.adapter.out.persistence;

import com.example.mapping_demo.adapter.out.persistence.entity.UserEntity;
import com.example.mapping_demo.adapter.out.persistence.repository.JpaUserRepository;
import com.example.mapping_demo.domain.model.User;
import com.example.mapping_demo.domain.port.out.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

// Secondary adapter - Repository implementation
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

    @Override
    public List<User> findAll() {
        List<UserEntity> entities = jpaUserRepository.findAll();
        return entities.stream()
            .map(e -> new User(e.getId(), e.getName(), e.getEmail()))
            .toList();
    }
}
