package zhou.yi.springbootrabbitmqtest.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zhou.yi.springbootrabbitmqtest.model.User;

@Component
public class FanoutSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void send() {
		this.rabbitTemplate.convertAndSend("fanout", "", new User(1,"zhouyi",23).toString());
		System.out.println("fanout send msg");
	}
}
