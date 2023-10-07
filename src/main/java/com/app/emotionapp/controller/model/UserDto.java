package com.app.emotionapp.controller.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
     private String username;
     private String password;
}
