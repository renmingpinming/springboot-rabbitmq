package zhou.yi.springbootrabbitmqtest.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zhou.yi.springbootrabbitmqtest.direct.DirectSender;
import zhou.yi.springbootrabbitmqtest.fanout.FanoutSender;
import zhou.yi.springbootrabbitmqtest.hello.HelloSender;
import zhou.yi.springbootrabbitmqtest.topic.TopicSender;

/**
 * @Author: XiaoLang
 * @Date: 2019/3/25 17:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {
    @Autowired
    private HelloSender helloSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private DirectSender directSender;
    @Autowired
    private TopicSender topicSender;

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }

    @Test
    public void fanout() throws Exception {
        fanoutSender.send();
    }

    @Test
    public void direct() throws Exception {
        directSender.sendDirect();
    }

    @Test
    public void topic() throws Exception {
        topicSender.send();
    }
}
