package com.springexample.restdemo.KafkaServices;

import com.springexample.restdemo.Structure;
import com.springexample.restdemo.controller.StructureAPIService;
import com.springexample.restdemo.rep.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {
    @Autowired
    private StudentRepository studentRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "KafkaDemo", groupId = "kafka-group")
    public void listenToCodeDecodeKafkaTopic(Structure s) {
        LOGGER.info("message Recieved -> " + s);
        studentRepository.save(s);


    }
}
