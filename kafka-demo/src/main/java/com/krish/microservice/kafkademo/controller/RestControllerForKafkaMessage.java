package com.krish.microservice.kafkademo.controller;

import com.krish.microservice.kafkademo.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kafka/v1")
public class RestControllerForKafkaMessage {

    @Autowired
    Producer _producer;

    @GetMapping("/producerMsg")
    public void getMessageFromClient(@RequestParam("message") String message) {
        _producer.sendMsgToTopic(message);
    }
}
