package com.xuecheng.test.rabbitmq.mq;

import com.rabbitmq.client.Channel;
import com.xuecheng.test.rabbitmq.config.RabbitmqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ReceiveHandler {


    //监听email队列
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_EMAIL})
    public void send_email(String msg, Message message, Channel channel) throws IOException {


        System.err.println("receive message is:" + msg);

    }





    //监听sms队列
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_SMS})
    public void receive_sms(String msg, Message message, Channel channel) throws Exception {


        System.err.println(msg);

        // 手动成功确认
        //  channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        //失败确认
        /**
         *参数1 : 该消息的index
         * 参数2 : 是否批量 true：将一次性拒绝所有小于deliveryTag的消息
         * 参数3 : 被拒绝的是否重新入队列 true 加入
         */
        //   channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
    }


}
