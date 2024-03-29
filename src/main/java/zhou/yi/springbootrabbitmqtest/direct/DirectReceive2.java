package zhou.yi.springbootrabbitmqtest.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="direct2")
public class DirectReceive2 {

	@RabbitHandler
	public void process(String msg) throws InterruptedException {
		System.out.println("Receive2接受的消息： "+msg);
		Thread.sleep(500);
	}
}
