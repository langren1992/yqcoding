package com.anserx.yqcoding.mq.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * 消息发送确认主要从person==>exchange
 * 目前将消息发送设置为手动确认
 *
 * @author zengrui
 * @date 2020-6-14
 */
@Component
public class DefaultConfirmCallback implements RabbitTemplate.ConfirmCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public DefaultConfirmCallback(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("correlationData: " + correlationData);
        System.out.println("cause: " + cause);
        System.out.println("ack: " + ack);
        if(!ack){
            System.out.println("异常处理....");
        }
    }
}
