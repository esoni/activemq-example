package it.italiancoders.publishsubscribe.publish.utils;

import org.springframework.jms.core.MessagePostProcessor;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;

public class MQTTQoSMessagePostProcessor implements MessagePostProcessor {

    public static final MQTTQoSMessagePostProcessor AT_MOST_ONCE = new MQTTQoSMessagePostProcessor(0);
    public static final MQTTQoSMessagePostProcessor AT_LEAST_ONCE = new MQTTQoSMessagePostProcessor(1);
    public static final MQTTQoSMessagePostProcessor EXACTLY_ONCE = new MQTTQoSMessagePostProcessor(2);

    private int qos;

    private MQTTQoSMessagePostProcessor(int qos) {
        this.qos = qos;
    }

    @Override
    public Message postProcessMessage(Message message) throws JMSException {
        message.setIntProperty("ActiveMQ.MQTT.QoS", qos);
        message.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
        return message;
    }
}
