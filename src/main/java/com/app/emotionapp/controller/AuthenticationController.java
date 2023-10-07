package com.app.emotionapp.controller;

import com.app.emotionapp.controller.model.UserDto;
import com.app.emotionapp.controller.model.UserExtendedDto;
import com.app.emotionapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthenticationController {

     @Autowired
     private UserService userService;

     @PostMapping("authenticate")
     public ResponseEntity<UserExtendedDto> authenticate(@RequestBody UserDto userDto) {
          try {
               return ResponseEntity.ok(UserExtendedDto.from(userService.authorizeUser(userDto)));
          } catch (UsernameNotFoundException e) {
               return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
          }
     }
}
