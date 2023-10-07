package com.app.emotionapp.controller.model;

import com.app.emotionapp.persistance.entity.MessageEntity;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDto {

     private String emotion;
     private LocalDateTime lastUpdatedTimestamp;
     private String name;

     public static MessageDto from(MessageEntity messageEntity) {
          return MessageDto.builder()
              .emotion(messageEntity.getEmotion())
              .name(messageEntity.getName())
              .lastUpdatedTimestamp(messageEntity.getLastUpdatedTimestamp())
              .build();
     }
}
