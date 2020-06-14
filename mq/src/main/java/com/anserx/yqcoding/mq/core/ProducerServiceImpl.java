package com.anserx.yqcoding.mq.core;

import com.anserx.yqcoding.mq.bean.QueueDefinition;
import com.anserx.yqcoding.mq.enums.QueueDefinitionEnum;
import com.google.gson.Gson;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl<D>implements ProducerService<D> {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void producer(QueueDefinitionEnum queueDefinitionEnum,D d) {
        QueueDefinition definition = queueDefinitionEnum.getQueueDefinition();
        if (!d.getClass().getName().equals(definition.getBoClass().getName())){
            throw new RuntimeException("请求参数类型与队列定义不匹配！");
        }
        Gson gson = new Gson();
        if (ExchangeTypes.DIRECT.equals(definition.getType())){
            rabbitTemplate.convertAndSend(definition.getQueue(),definition.getQueue(),gson.toJson(d));
        }
        if (ExchangeTypes.TOPIC.equals(definition.getType())){
            rabbitTemplate.convertAndSend(definition.getExchange(),definition.getKey(),gson.toJson(d));
        }
    }
}
