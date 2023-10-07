package com.app.emotionapp.persistance.repository;

import com.app.emotionapp.persistance.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

     Optional<UserEntity> findUserEntityByUsername(String username);
}
