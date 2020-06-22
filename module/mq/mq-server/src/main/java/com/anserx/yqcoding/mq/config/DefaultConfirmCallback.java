package com.anserx.yqcoding.mq.config;

import com.anserx.yqcoding.mq.dto.ProducerLogDto;
import com.anserx.yqcoding.mq.service.ProducerLogService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 * 消息发送确认主要从person==>exchange
 * 目前将消息发送设置为手动确认
 *
 * @author zengrui
 * @date 2020-6-14
 */
@Component
@Slf4j
public class DefaultConfirmCallback implements RabbitTemplate.ConfirmCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ProducerLogService producerLogService;

    public DefaultConfirmCallback(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("correlationData: " + correlationData);
        Long id = Long.valueOf(correlationData.getId());
        Map<String, Object> params = Maps.newHashMap();
        params.put("message_id",id);
        System.out.println("cause: " + cause);
        System.out.println("ack: " + ack);
        if(ack){
            ProducerLogDto logDto = new ProducerLogDto();
            logDto.setMessageId(id);
            producerLogService.update(logDto);
        }
    }
}
