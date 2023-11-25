package com.mycompany.service;

import com.mycompany.message.OrderCreated;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderCreatedProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;


    public void publish(OrderCreated order) {
        log.info("Sending order: {}",order.toString());
        kafkaTemplate.send("order.created", order);
    }
}
