package com.example.kafkaconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "kafkaproducerTopic1", groupId = "hrk-group")
    public void consumer(String msg){
        log.info("Cosumer is Able to Consumer:: {}" ,msg);
    }

    @KafkaListener(topics = "kafkaproducerTopic1", groupId = "hrk-group")
    public void consumer1(String msg){
        log.info("Cosumer1 is Able to Consumer:: {}" ,msg);
    }

    @KafkaListener(topics = "kafkaproducerTopic1", groupId = "hrk-group")
    public void consumer2(String msg){
        log.info("Cosumer2 is Able to Consumer:: {}" ,msg);
    }
}
