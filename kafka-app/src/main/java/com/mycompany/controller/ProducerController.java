package com.mycompany.controller;

import com.mycompany.message.OrderCreated;
import com.mycompany.service.OrderCreatedProducer;
import com.mycompany.service.OrderCreatedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProducerController {

    private final OrderCreatedProducer producer;

    @PostMapping
    public void send(@RequestBody OrderCreated orderCreated) {
        producer.publish(orderCreated);
    }
}
