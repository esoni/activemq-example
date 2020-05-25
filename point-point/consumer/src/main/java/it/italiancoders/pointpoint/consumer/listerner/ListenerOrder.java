package it.italiancoders.pointpoint.consumer.listerner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.italiancoders.pointpoint.consumer.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ListenerOrder {
    @Autowired
    ObjectMapper objectMapper;

    @JmsListener(destination = "order.queue")
    public void receive(String message) throws JsonProcessingException {
        Order order = objectMapper.readValue(message, Order.class);
        log.info("received message='{}'", order);
    }
}
