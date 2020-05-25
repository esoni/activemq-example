package it.italiancoders.queue.producer.service.impl;

import it.italiancoders.queue.producer.model.Order;
import it.italiancoders.queue.producer.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    JmsTemplate jmsTemplate;

    @Override
    public void enqueueOrder(Order o) {
        this.jmsTemplate.convertAndSend("order.queue", o);
    }
}
