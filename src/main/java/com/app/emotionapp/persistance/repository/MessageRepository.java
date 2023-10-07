package com.app.emotionapp.persistance.repository;

import com.app.emotionapp.persistance.entity.MessageEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {

     Optional<MessageEntity> findMessageEntityByName(String name);
}
