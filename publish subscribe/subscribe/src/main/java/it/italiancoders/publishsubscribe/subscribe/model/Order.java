package it.italiancoders.publishsubscribe.subscribe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private long id;
    private long customerId;
    private int qty;
    private String isin;
}
