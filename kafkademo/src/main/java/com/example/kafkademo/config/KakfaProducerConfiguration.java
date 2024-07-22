package com.example.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KakfaProducerConfiguration {

    @Bean
    public NewTopic createNewTopic(){
        return new NewTopic("kafkaproducerTopic1",3, (short) 1);
    }
}
