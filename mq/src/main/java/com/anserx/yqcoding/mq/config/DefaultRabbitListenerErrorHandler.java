package com.anserx.yqcoding.mq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.stereotype.Component;

/**
 *
 * 消费端消息消费异常处理执行
 *
 * @author zengrui
 * @date 2020-6-14
 */
@Component
@Slf4j
public class DefaultRabbitListenerErrorHandler implements RabbitListenerErrorHandler {
    @Override
    public Object handleError(Message amqpMessage, org.springframework.messaging.Message<?> message, ListenerExecutionFailedException exception) throws Exception {
        System.out.println("amqpMessage = " + amqpMessage + ", message = " + message + ", exception = " + exception.getCause());
        return null;
    }
}
