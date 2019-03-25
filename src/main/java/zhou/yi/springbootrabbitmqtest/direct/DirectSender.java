package zhou.yi.springbootrabbitmqtest.direct;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendDirect() throws InterruptedException {
		for(int i=0;i<20;i++) {
			Thread.sleep(600);
			String msg = "direct msg22 "+i;
			String routingKey=null;
			if(i%2==0){
				System.out.println("Sender发送-偶数-的消息： "+msg);
				routingKey = "direct1";
			}else {
				System.out.println("Sender发送-奇数-的消息： "+msg);
				routingKey = "direct2";
			}
			rabbitTemplate.convertAndSend("direct", routingKey, msg);
		}
	}
	
}
