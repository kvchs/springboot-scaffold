package com.cc.kafka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Resource
    KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public void send(){

        Map<String, Long> data = new HashMap<>();
        data.put("dateTime", System.currentTimeMillis());
        kafkaProducer.send(data);
    }
}
