package zhou.yi.springbootrabbitmqtest.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: XiaoLang
 * @Date: 2019/3/25 17:17
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello2 " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello2", context);
    }

}
