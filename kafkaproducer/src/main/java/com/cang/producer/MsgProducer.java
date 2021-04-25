package com.cang.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class MsgProducer {

    @Autowired
    private KafkaTemplate<String ,Object> kafkaTemplate;
    @GetMapping("/test/{msg}")
    public void getMsg(@PathVariable("msg") String msg){
        kafkaTemplate.send("topic1",msg);
    }
}
