package com.anserx.yqcoding.mq.core.impl;

import com.anserx.yqcoding.mq.bean.BaseMessage;
import com.anserx.yqcoding.mq.bean.QueueDefinition;
import com.anserx.yqcoding.mq.core.ProducerService;
import com.anserx.yqcoding.mq.dto.ProducerLogDto;
import com.anserx.yqcoding.mq.enums.QueueDefinitionEnum;
import com.anserx.yqcoding.mq.service.ProducerLogService;
import com.google.gson.Gson;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProducerServiceImpl<D>implements ProducerService<D> {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ProducerLogService producerLogService;

    @Override
    public void producer(QueueDefinitionEnum queueDefinitionEnum, BaseMessage<D> dto) {
        QueueDefinition definition = queueDefinitionEnum.getQueueDefinition();
        if (!dto.getData().getClass().getName().equals(definition.getBoClass().getName())){
            throw new RuntimeException("请求参数类型与队列定义不匹配！");
        }
        Gson gson = new Gson();
        String param = gson.toJson(dto);
        ProducerLogDto log = new ProducerLogDto()
            .setMessageId(dto.getMessageId())
            .setAck(false)
            .setRequestParam(queueDefinitionEnum.getClass().getName()+"."+queueDefinitionEnum.name())
            .setQueueInfo(param);
        log.setCreator(0L).setCreateTime(LocalDateTime.now());
        producerLogService.insert(log);
        CorrelationData correlationData = new CorrelationData(dto.getMessageId().toString());
        if (ExchangeTypes.DIRECT.equals(definition.getType())){
            rabbitTemplate.convertAndSend(definition.getQueue(),definition.getQueue(),param,correlationData);
        }
        if (ExchangeTypes.TOPIC.equals(definition.getType())){
            rabbitTemplate.convertAndSend(definition.getExchange(),definition.getKey(),param,correlationData);
        }
    }
}
