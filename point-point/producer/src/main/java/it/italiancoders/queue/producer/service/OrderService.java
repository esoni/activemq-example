package it.italiancoders.queue.producer.service;

import it.italiancoders.queue.producer.model.Order;

public interface OrderService {
    public void enqueueOrder(Order o);
}
