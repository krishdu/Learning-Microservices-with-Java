package com.krish.microservice.kafkademo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "demo_Topic", groupId = "group1")
    public void listenToTopic(String receiveMessage) {
        System.out.println("The received message is - " + receiveMessage);
    }
}
