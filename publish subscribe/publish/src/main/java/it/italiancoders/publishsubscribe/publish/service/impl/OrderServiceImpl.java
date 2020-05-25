package it.italiancoders.publishsubscribe.publish.service.impl;

import it.italiancoders.publishsubscribe.publish.model.Order;
import it.italiancoders.publishsubscribe.publish.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("orderTopic")
    ActiveMQTopic orderTopic;

    @Override
    public void publish(Order o) {
        this.jmsTemplate.convertAndSend(orderTopic, o);
    }
}
