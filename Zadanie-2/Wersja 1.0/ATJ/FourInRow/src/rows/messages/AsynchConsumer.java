package rows.messages;

import javax.jms.JMSException;
import javax.jms.Message ; 
import javax.jms.MessageListener ; 
import javax.jms.TextMessage ; 

public class AsynchConsumer implements MessageListener {
	@Override 
	public void onMessage(Message message) {
		if (message instanceof TextMessage)
			try {
				System.out.printf("Odebrano: '%s'%n",
						((TextMessage) message).getText()) ; 
			}
			catch ( JMSException e ) {
				e.printStackTrace();
			}
	}

}
