package it.italiancoders.publishsubscribe.publish.service.impl;

import it.italiancoders.publishsubscribe.publish.model.Order;
import it.italiancoders.publishsubscribe.publish.service.OrderService;
import it.italiancoders.publishsubscribe.publish.utils.MQTTQoSMessagePostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.command.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    @Qualifier("jmsTemplatePubSub")
    JmsTemplate jmsTemplatePubSub;

    @Override
    public void publish(Order o) {
        this.jmsTemplatePubSub.convertAndSend("PIPPO", o,  MQTTQoSMessagePostProcessor.AT_LEAST_ONCE);
    }

    @Override
    public void publish2(Order o) {
        this.jmsTemplatePubSub.convertAndSend("PIPPO2", o,  MQTTQoSMessagePostProcessor.AT_LEAST_ONCE);
    }
}
