package com.anserx.yqcoding.mq.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * 消息发送异常处理exchange==>queue
 *
 * @author zengrui
 * @date 2020-6-14
 */
@Component
public class DefaultReturnCallback implements RabbitTemplate.ReturnCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public DefaultReturnCallback(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setReturnCallback(this);
    }
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("return exchange: " + exchange + ", routingKey: "
            + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
    }
}
