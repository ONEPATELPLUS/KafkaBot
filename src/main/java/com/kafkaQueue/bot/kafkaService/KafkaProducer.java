package com.kafkaQueue.bot.kafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    public static final String TOPIC = "latesttopic";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void publishToTopic(String message){
        System.out.println("Publishing to topic " + TOPIC);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
