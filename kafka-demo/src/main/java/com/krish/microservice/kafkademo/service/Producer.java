package com.krish.microservice.kafkademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private final String TOPIC = "demo_Topic";
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendMsgToTopic(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
