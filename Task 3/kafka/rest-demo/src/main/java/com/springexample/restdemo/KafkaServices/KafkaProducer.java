package com.springexample.restdemo.KafkaServices;

import com.springexample.restdemo.Structure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String,Structure> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String,Structure> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(Structure s){
        LOGGER.info(String.format("Message sent -> %s", s));

        Message<Structure> message = MessageBuilder.withPayload(s).setHeader(KafkaHeaders.TOPIC,"KafkaDemo").build();

        kafkaTemplate.send(message);
    }
}
