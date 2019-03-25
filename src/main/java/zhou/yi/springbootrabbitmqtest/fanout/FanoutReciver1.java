package zhou.yi.springbootrabbitmqtest.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="fanoutQueue1")
public class FanoutReciver1 {

	@RabbitHandler
	public void read(String user) {
		System.out.println("fanoutQueue1: "+user);
	}
}
