package com.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewPartitions;
import org.apache.kafka.clients.admin.CreatePartitionsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaPartitionService {

    @Autowired
    private AdminClient adminClient;

    public void addPartitions(String topic, int newPartitionCount) {
        Map<String, NewPartitions> newPartitions = new HashMap<>();
        newPartitions.put(topic, NewPartitions.increaseTo(newPartitionCount));

        CreatePartitionsResult result = adminClient.createPartitions(newPartitions);
        result.all().whenComplete((aVoid, throwable) -> {
            if (throwable != null) {
                // Handle exception
                throwable.printStackTrace();
            } else {
                System.out.println("Partitions added successfully.");
            }
        });
    }
}

