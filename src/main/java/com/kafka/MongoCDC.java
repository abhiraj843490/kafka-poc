package com.kafka;
import com.mongodb.kafka.connect.source.MongoSourceConfig;
import org.apache.flink.cdc.connectors.mongodb.source.MongoDBSource;
import org.apache.flink.cdc.debezium.JsonDebeziumDeserializationSchema;
import org.apache.flink.cdc.debezium.JsonDebeziumDeserializationSchema;


public class MongoCDC {
    public static void main(String[] args) { MongoDBSource<String> mongoSource =
            MongoDBSource.<String>builder()
                    .hosts("localhost:27017")
                    .databaseList("inventory") // set captured database, support regex
                    .collectionList("inventory.products", "inventory.orders") //set captured collections, support regex
                    .username("flink")
                    .password("flinkpw")
                    .deserializer(new JsonDebeziumDeserializationSchema())
                    .build();

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // enable checkpoint
        env.enableCheckpointing(3000);
        // set the source parallelism to 2
        env.fromSource(mongoSource, WatermarkStrategy.noWatermarks(), "MongoDBIncrementalSource")
                .setParallelism(2)
                .print()
                .setParallelism(1);

        env.execute("Print MongoDB Snapshot + Change Stream");
    }
}

