package com.app.emotionapp.controller;

import com.app.emotionapp.controller.model.MessageDto;
import com.app.emotionapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MessageController {

     @Autowired
     private MessageService messageService;

     @PostMapping("message")
     public ResponseEntity<HttpStatus> postMessage(@RequestBody MessageDto messageDto) {
          try {
               System.out.println(messageDto.toString());
               messageService.postOrUpdateMessage(messageDto);
               return ResponseEntity.ok(HttpStatus.ACCEPTED);
          } catch (Exception e) {
               System.out.println("Something happened during post");
               e.printStackTrace();
               return ResponseEntity.badRequest().build();
          }
     }

     @GetMapping("message")
     public ResponseEntity<MessageDto> getMessage(@RequestParam String name) {
          try {
               return ResponseEntity.ok(messageService.getMessage(name));
          } catch (Exception e) {
               System.out.println("Something happened during fetch");
               e.printStackTrace();
               return ResponseEntity.noContent().build();
          }

     }
}
