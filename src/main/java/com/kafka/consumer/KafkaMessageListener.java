package com.kafka.consumer;

import com.kafka.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "user",groupId = "dyp-group")
    public void consumeEvents(String customer) {
        log.info("consumer consume the events {} ", customer);
    }

    @KafkaListener(topics = "user",groupId = "dyp-group")
    public void consume2(String message) {
        log.info("consumer2 consume the message {} ", message);
    }

    @KafkaListener(topics = "user",groupId = "dyp-group")
    public void consume3(String message) {
        log.info("consumer3 consume the message {} ", message);
    }

    @KafkaListener(topics = "user",groupId = "dyp-group")
    public void consume4(String message) {
        log.info("consumer4 consume the message {} ", message);
    }

    @KafkaListener(topics = "user",groupId = "dyp-group")
    public void consume5(String message) {
        log.info("consumer5 consume the message {} ", message);
    }
}
