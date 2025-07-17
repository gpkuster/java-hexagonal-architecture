// adapter/out/persistence/repository/JpaUserRepository.java
package com.example.mapping_demo.adapter.out.persistence.repository;

import com.example.mapping_demo.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, String> {
}
