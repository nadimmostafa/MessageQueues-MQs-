package org.nadim.messageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {
	@Autowired
	private JmsTemplate jt;
	
	@Value("${my.app.desti-name}")
	private String destinationName;
	
	public void sendMessage(String message) {
		jt.send(destinationName,
				session->session.createTextMessage(message));
		System.out.println("Message sending....");
	}
}
