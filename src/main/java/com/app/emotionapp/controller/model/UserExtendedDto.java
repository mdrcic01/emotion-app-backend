package com.app.emotionapp.controller.model;

import com.app.emotionapp.persistance.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserExtendedDto {

     private String username;
     private String firstName;
     private String lastName;

     public static UserExtendedDto from(UserEntity userEntity) {
          return UserExtendedDto.builder()
              .username(userEntity.getUsername())
              .firstName(userEntity.getFirstName())
              .lastName(userEntity.getLastName())
              .build();
     }
}
