package zhou.yi.springbootrabbitmqtest.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: XiaoLang
 * @Date: 2019/3/25 17:17
 */
@Component
@RabbitListener(queues = "hello2")
public class HelloReceiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }
}
