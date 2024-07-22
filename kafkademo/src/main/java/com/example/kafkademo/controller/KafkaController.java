package com.example.kafkademo.controller;

import com.example.kafkademo.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishKakfaMessage(@PathVariable String message){
        for(int i=0;i<10000;i++)
        kafkaMessagePublisher.sendMessageToTopic(message + " :: " +i);
        return ResponseEntity.ok("Message Sent");
    }

}
