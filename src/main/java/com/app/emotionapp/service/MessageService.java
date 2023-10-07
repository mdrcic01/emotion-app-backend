package com.app.emotionapp.service;

import com.app.emotionapp.controller.model.MessageDto;
import com.app.emotionapp.persistance.entity.MessageEntity;
import com.app.emotionapp.persistance.repository.MessageRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

     @Autowired
     private MessageRepository messageRepository;

     public MessageDto getMessage(String name) {
          Optional<MessageEntity> message = messageRepository.findMessageEntityByName(name);

          if (message.isEmpty()) {
               return null;
          }
          return MessageDto.from(message.get());
     }

     public void postOrUpdateMessage(MessageDto messageDto) {
          Optional<MessageEntity> message = messageRepository.findMessageEntityByName(messageDto.getName());

          messageRepository.save(MessageEntity.builder()
              .id(message.isEmpty() ? null : message.get().getId())
              .name(messageDto.getName())
              .emotion(messageDto.getEmotion())
              .lastUpdatedTimestamp(LocalDateTime.now())
              .build());
     }
}
