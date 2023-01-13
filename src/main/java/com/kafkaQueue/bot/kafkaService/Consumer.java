package com.kafkaQueue.bot.kafkaService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class Consumer {

    @KafkaListener(topics = "newtopic", groupId = "groupkafka")
    public void consumeFromTopic(String message){
        System.out.println("Consumed message" +message);
    }
}
