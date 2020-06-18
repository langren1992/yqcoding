package com.anserx.yqcoding.mq.core;

import com.anserx.yqcoding.mq.bean.BaseMessage;
import com.anserx.yqcoding.mq.bean.QueueDefinition;
import com.anserx.yqcoding.mq.entity.ProducerLog;
import com.anserx.yqcoding.mq.enums.QueueDefinitionEnum;
import com.anserx.yqcoding.mq.service.IProducerLogService;
import com.google.gson.Gson;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProducerServiceImpl<D>implements ProducerService<D> {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private IProducerLogService iProducerLogService;

    @Override
    public void producer(QueueDefinitionEnum queueDefinitionEnum, BaseMessage<D> d) {
        QueueDefinition definition = queueDefinitionEnum.getQueueDefinition();
        if (!d.getData().getClass().getName().equals(definition.getBoClass().getName())){
            throw new RuntimeException("请求参数类型与队列定义不匹配！");
        }
        Gson gson = new Gson();
        String param = gson.toJson(d);
        ProducerLog log = new ProducerLog()
            .setMessageId(d.getMessageId())
            .setAck(false)
            .setRequestParam(queueDefinitionEnum.getClass().getName()+"."+queueDefinitionEnum.name())
            .setQueueInfo(param);
        log.setCreator(0L).setCreateTime(LocalDateTime.now());
        iProducerLogService.save(log);
        if (ExchangeTypes.DIRECT.equals(definition.getType())){
            rabbitTemplate.convertAndSend(definition.getQueue(),definition.getQueue(),param);
        }
        if (ExchangeTypes.TOPIC.equals(definition.getType())){
            rabbitTemplate.convertAndSend(definition.getExchange(),definition.getKey(),param);
        }
    }
}
