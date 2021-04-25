package com.cang.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Topic1Consumer {

    @KafkaListener(topics = "topic1")
    public void consume(ConsumerRecord<?, ?> record){
        System.out.println("topic:"+record.topic() + ",partition:" + record.partition() + ",offset:" + record.offset() + ",value:" + record.value());
    }
}
