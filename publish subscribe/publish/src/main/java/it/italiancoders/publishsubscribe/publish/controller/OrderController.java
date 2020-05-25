package it.italiancoders.publishsubscribe.publish.controller;

import it.italiancoders.publishsubscribe.publish.model.Order;
import it.italiancoders.publishsubscribe.publish.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<?> postOrder(@RequestBody Order order)  {
        this.orderService.publish(order);
        return ResponseEntity.noContent().build();
    }
}
