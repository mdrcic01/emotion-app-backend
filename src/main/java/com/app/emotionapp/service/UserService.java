package com.app.emotionapp.service;

import com.app.emotionapp.controller.model.UserDto;
import com.app.emotionapp.persistance.entity.UserEntity;
import com.app.emotionapp.persistance.repository.UserRepository;
import java.util.Optional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

     @Autowired
     private UserRepository userRepository;

     public UserEntity authorizeUser(UserDto userDto) {
          PasswordEncoder encoder = new BCryptPasswordEncoder();
          Optional<UserEntity> userEntity = userRepository.findUserEntityByUsername(userDto.getUsername());

          if (userEntity.isPresent() && userEntity.get().getPassword()
              .equals(encoder.encode(userDto.getPassword()))) {
               return userEntity.get();
          }

          throw new UsernameNotFoundException("Passwords do not match or username does not exist!");

     }
}
