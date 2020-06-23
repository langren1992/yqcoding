package com.anserx.yqcoding.mq.config;

import com.anserx.yqcoding.common.util.ExceptionUtils;
import com.anserx.yqcoding.mq.MqConstant;
import com.anserx.yqcoding.mq.dto.ConsumerErrorLogDto;
import com.anserx.yqcoding.mq.service.ConsumerErrorLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.listener.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Map;

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

    @Autowired
    private ConsumerErrorLogService consumerErrorLogService;

    @Override
    public Object handleError(Message amqpMessage, org.springframework.messaging.Message<?> message, ListenerExecutionFailedException exception) throws Exception {
        // 获取队列参数
        MessageProperties messageProperties = amqpMessage.getMessageProperties();
        Map<String, Object> headers = messageProperties.getHeaders();
        // 获取消息header
        Long messageId = Long.parseLong(String.valueOf(headers.get(MqConstant.MQ_HEADER_MESSAGE_ID)));
        String queueDefinitionHeader = headers.get(MqConstant.MQ_HEADER_QUEUE_DEFINITION).toString();
        // 获取消息
        String messageBody = new String(amqpMessage.getBody(), StandardCharsets.UTF_8);
        log.error("队列：{} 消息ID:{} 消费异常 原因：{}",messageProperties.getConsumerQueue(),messageId, exception.getMessage());
        ConsumerErrorLogDto errorLogDto = new ConsumerErrorLogDto()
                .setMessageId(messageId)
                .setRequestParam(messageBody)
                .setQueueInfo(queueDefinitionHeader)
                .setFailureReason(ExceptionUtils.getStackTrace(exception.getCause()));
        errorLogDto.setCreator(0L).setCreateTime(LocalDateTime.now());
        consumerErrorLogService.insert(errorLogDto);
        return null;
    }
}
