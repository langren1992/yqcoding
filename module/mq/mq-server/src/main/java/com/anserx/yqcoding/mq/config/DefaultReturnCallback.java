package com.anserx.yqcoding.mq.config;

import com.anserx.yqcoding.common.util.ExceptionUtils;
import com.anserx.yqcoding.mq.MqConstant;
import com.anserx.yqcoding.mq.dto.ConsumerErrorLogDto;
import com.anserx.yqcoding.mq.service.ConsumerErrorLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Map;

/**
 *
 * 消息发送异常处理exchange==>queue
 *
 * @author zengrui
 * @date 2020-6-14
 */
@Component
@Slf4j
public class DefaultReturnCallback implements RabbitTemplate.ReturnCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ConsumerErrorLogService consumerErrorLogService;

    public DefaultReturnCallback(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setReturnCallback(this);
    }
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        // 获取队列参数
        MessageProperties messageProperties = message.getMessageProperties();
        Map<String, Object> headers = messageProperties.getHeaders();
        // 获取消息header
        Long messageId = Long.parseLong(String.valueOf(headers.get(MqConstant.MQ_HEADER_MESSAGE_ID)));
        String queueDefinitionHeader = headers.get(MqConstant.MQ_HEADER_QUEUE_DEFINITION).toString();
        // 获取消息
        String messageBody = new String(message.getBody(), StandardCharsets.UTF_8);
        log.error("队列：{} 消息ID:{} 消费异常 原因：{}",messageProperties.getConsumerQueue(),messageId, "消费无法投递queue");
        ConsumerErrorLogDto errorLogDto = new ConsumerErrorLogDto()
                .setMessageId(messageId)
                .setRequestParam(messageBody)
                .setQueueInfo(queueDefinitionHeader)
                .setFailureReason("");
        errorLogDto.setCreator(0L).setCreateTime(LocalDateTime.now());
        consumerErrorLogService.insert(errorLogDto);
    }
}
