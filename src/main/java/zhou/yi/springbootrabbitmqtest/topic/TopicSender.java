package zhou.yi.springbootrabbitmqtest.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zhou.yi.springbootrabbitmqtest.model.User;

@Component
public class TopicSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send() throws InterruptedException {
		for(int i = 0;i< 10;i++){
			Thread.sleep(600);
			rabbitTemplate.convertAndSend("topic", "rabbit.msg.others", new User(1,"zhou"+i,23).toString());
			rabbitTemplate.convertAndSend("topic", "rabbit.user.others", new User(2,"zhou"+i,22).toString());
		}
	}
	
}
