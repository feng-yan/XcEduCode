package com.xuecheng.test.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.xuecheng.test.rabbitmq.config.ConfirmCallBackConfig;
import com.xuecheng.test.rabbitmq.config.RabbitmqConfig;
import com.xuecheng.test.rabbitmq.config.ReturnCallbackConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest
@RunWith(SpringRunner.class)
public class Producer05_topics_springboot {

    @Autowired
    RabbitTemplate rabbitTemplate;



    //使用rabbitTemplate发送消息
    @Test
    public void testSendEmail(){

        String message = "send email message to 他";
        /**
         * 参数：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */

        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPICS_INFORM,"inform.sms",message);

//        CorrelationData correlationData = new CorrelationData();
//        correlationData.setId("123");

   //     rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPICS_INFORM,"inform.sms",message,correlationData);

    }



    //使用rabbitTemplate发送消息 5d3d662360288823d0257765
    @Test
    public void testSendPostPage(){

        Map message = new HashMap<>();
        message.put("pageId","5d3d662360288823d0257765");
        //将消息对象转成json串
        String messageString = JSON.toJSONString(message);
        //路由key，就是站点ID
        String routingKey = "5a751fab6abb5044e0d19ea1";
        /**
         * 参数：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */
        rabbitTemplate.convertAndSend("ex_routing_cms_postpage",routingKey,messageString);

    }

}
