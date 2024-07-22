package com.example.kafkademo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public void sendMessageToTopic(String msg){
        CompletableFuture<SendResult<String,Object>> msgFuture = kafkaTemplate.send("kafkaproducerTopic1", msg);

        msgFuture.whenComplete((result,ex)-> {
                if(ex == null) {
                    System.out.println("MSG SENT AS EXPECTED");
                } else {
                    System.out.println("MSG FAILED " + ex.getMessage());
                }
        });
    }
}
