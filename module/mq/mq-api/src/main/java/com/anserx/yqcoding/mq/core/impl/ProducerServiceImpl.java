package com.anserx.yqcoding.mq.core.impl;

import cn.hutool.json.JSONUtil;
import com.anserx.yqcoding.mq.bean.BaseMessage;
import com.anserx.yqcoding.mq.bean.QueueDefinition;
import com.anserx.yqcoding.mq.core.ProducerService;
import com.anserx.yqcoding.mq.dto.ProducerLogDto;
import com.anserx.yqcoding.mq.enums.QueueDefinitionEnum;
import com.anserx.yqcoding.mq.service.ProducerLogService;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Map;

@Service
@Slf4j
public class ProducerServiceImpl<D>implements ProducerService<D> {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ProducerLogService producerLogService;

    @Override
    public void producer(QueueDefinitionEnum queueDefinitionEnum, BaseMessage<D> dto) {
        // 设置消息主体
        try {
            Message message = MessageBuilder.withBody(JSONUtil.toJsonStr(dto.getData()).getBytes("UTF-8")).setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setContentEncoding("utf-8").build();
            QueueDefinition definition = queueDefinitionEnum.getQueueDefinition();
            Gson gson = new Gson();
            String queueDefinition = gson.toJson(definition);
            String param = gson.toJson(dto);

            Map<String, Object> headers = message.getMessageProperties().getHeaders();
            headers.put("queueDefinition",queueDefinition);
            headers.put("messageId",dto.getMessageId());

            Map<String, Object> params = Maps.newHashMap();
            params.put("message_id",dto.getMessageId());
            params.put("ack",false);
            boolean exits = producerLogService.exits(params);
            if (exits){
                log.error("{} 消息重复发送",dto.getMessageId());
                return;
            }

            ProducerLogDto log = new ProducerLogDto()
                .setMessageId(dto.getMessageId())
                .setAck(false)
                .setRequestParam(queueDefinition)
                .setQueueInfo(param);
            log.setCreator(0L).setCreateTime(LocalDateTime.now());
            producerLogService.insert(log);
            CorrelationData correlationData = new CorrelationData(dto.getMessageId().toString());
            if (ExchangeTypes.DIRECT.equals(definition.getType())){
                rabbitTemplate.convertAndSend(definition.getQueue(),definition.getQueue(),message,correlationData);
            }
            if (ExchangeTypes.TOPIC.equals(definition.getType())){
                rabbitTemplate.convertAndSend(definition.getExchange(),definition.getKey(),message,correlationData);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
