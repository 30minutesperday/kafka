package com.mycompany.service;

import com.mycompany.message.OrderCreated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderCreatedService {

    public void process(OrderCreated orderCreated) {
        log.info("OrderCreated: {}",orderCreated.toString());
    }
}
