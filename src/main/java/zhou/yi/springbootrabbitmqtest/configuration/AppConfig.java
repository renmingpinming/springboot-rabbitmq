package zhou.yi.springbootrabbitmqtest.configuration;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: XiaoLang
 * @Date: 2019/3/25 17:21
 */
@Configuration
public class AppConfig {
    private static String routingKey = "direct1";
    private static String routingKey2 = "direct2";
    private static String routingKey3 = "rabbit.msg.others";
    private static String routingKey4 = "rabbit.user.others";
    //hello
    @Bean
    public Queue helloQueue() {
        return new Queue("hello2",false);
    }

    //fanout
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanoutQueue1",false);
    }
    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanoutQueue2",false);
    }
    @Bean
    public Queue fanoutQueue3() {
        return new Queue("fanoutQueue3",false);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout", false, false);
    }

    @Bean
    public Binding bindFanoutQueue1() {
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }
    @Bean
    public Binding bindFanoutQueue2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }
    @Bean
    public Binding bindFanoutQueue3() {
        return BindingBuilder.bind(fanoutQueue3()).to(fanoutExchange());
    }

    //direct
    @Bean
    public Queue directQueue1() {
        return new Queue("direct1", false);
    }
    @Bean
    public Queue directQueue2() {
        return new Queue("direct2", false);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct", false, false);
    }

    @Bean
    public Binding bindDirect() {
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with(routingKey);
    }
    @Bean
    public Binding bindDirect2() {
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with(routingKey2);
    }

    //topic
    @Bean
    public Queue msgQueue2() {
        return new Queue(AppConfig.routingKey3, false);
    }
    @Bean
    public Queue userQueue2() {
        return new Queue(AppConfig.routingKey4, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic", false, false);
    }

    @Bean
    public Binding bindMsgQueue2() {
        return BindingBuilder.bind(msgQueue2()).to(topicExchange()).with("*.msg.*");
    }

    @Bean
    public Binding bindUserQueue2() {
        return BindingBuilder.bind(userQueue2()).to(topicExchange()).with("*.user.*");
    }
}
