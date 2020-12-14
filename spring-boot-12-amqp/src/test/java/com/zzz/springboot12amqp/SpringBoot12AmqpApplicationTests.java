package com.zzz.springboot12amqp;

import com.zzz.springboot12amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBoot12AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange(){
        //创建交换机
		amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
		System.out.println("创建完成");

		//创建消息队列 true代表是持久化的
		amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));

        //创建绑定规则       Routing key  =  "amqp.haha"
		amqpAdmin.declareBinding(new Binding("amqpadmin.queue",
                Binding.DestinationType.QUEUE,"amqpadmin.exchange",
                "amqp.haha",null));

		//删除
//        amqpAdmin.deleteExchange()
    }
    /**
     * 1、单播（点对点） 发送数据  如何将数据自动的转为json发送出去？？ 去配置文件
     */
    @Test
    void contextLoads() {
        //Message需要自己构造一个;定义消息体内容和消息头
        //rabbitTemplate.send(exchage,routeKey,message);
        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
        //rabbitTemplate.convertAndSend(exchage,routeKey,object);

        //对象被默认序列化以后发送出去
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloWorld" ,123, true));
        Book book = new Book("西游记", "吴承恩");
        rabbitTemplate.convertAndSend("exchange.direct", "zzz.news", book);
    }

    /**
     * 1、单播（点对点） 接受数据,
     */
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("zzz.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("红楼梦","曹雪芹"));

    }

}
