package com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Properties;
import java.util.concurrent.Future;
@Component
public class KafkaProducers {

    @Autowired
    private  KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String value) {
        kafkaTemplate.send(topic, "payment-request" ,value);
    }

}
