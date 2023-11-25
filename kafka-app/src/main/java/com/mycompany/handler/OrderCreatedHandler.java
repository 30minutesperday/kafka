package com.mycompany.handler;

import com.mycompany.message.OrderCreated;
import com.mycompany.service.OrderCreatedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderCreatedHandler {

    private final OrderCreatedService service;


    @KafkaListener(
            id="orderConsumer",
            topics="order.created"
    )
    public void listen(OrderCreated order, Acknowledgment acknowledgment) {
            log.info("Message Received: {}", order.getId());
            service.process(order);
            acknowledgment.acknowledge();
    }
}
