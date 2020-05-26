package it.italiancoders.activemq;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerPlugin;

public class MyAuthPlugin implements BrokerPlugin {

	public String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Broker installPlugin(Broker broker) throws Exception {
		return new MyAuthBroker(broker, username);
	}

}
