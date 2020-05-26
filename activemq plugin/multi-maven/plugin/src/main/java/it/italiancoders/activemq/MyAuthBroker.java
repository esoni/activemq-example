package it.italiancoders.activemq;


import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerFilter;
import org.apache.activemq.broker.ConnectionContext;
import org.apache.activemq.command.ConnectionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAuthBroker extends BrokerFilter {
	private static final Logger LOG = LoggerFactory.getLogger(MyAuthBroker.class);

	String username;
	int loginTry = 0;

	public MyAuthBroker(Broker next, String username) {
		super(next);
		this.username = username;
	}
	
	
	public void addConnection(ConnectionContext context, ConnectionInfo info) throws Exception {
		LOG.info("DEBUG FRONGIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII [{}] [{}]", context, info);
		loginTry++;
		LOG.info("DEBUG loginTry [{}]", loginTry);

		String username = info.getUserName();
			if (!username.equals(this.username)) {
				throw new SecurityException("invalid username or password from deviceID : " + info.getClientId());
			}
			super.addConnection(context, info);
	}

}
