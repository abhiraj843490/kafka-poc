package com.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaPartitionController {

    @Autowired
    private KafkaPartitionService kafkaPartitionService;

    @Autowired
    private KafkaProducers kafkaProducers;

    @PostMapping("/addPartitions")
    public String addPartitions(@RequestParam String topic, @RequestParam int partitionCount) {
        kafkaPartitionService.addPartitions(topic, partitionCount);
        return "Request to add partitions received.";
    }
    @GetMapping
    public void sendMessage() {
        for (int i = 0; i < 10000; i++) {
            kafkaProducers.sendMessage("user", "message for specific partition "+i);
        }
    }
}

