package it.italiancoders.publishsubscribe.publish.service;


import it.italiancoders.publishsubscribe.publish.model.Order;

public interface OrderService {
    public void publish(Order o);
}
