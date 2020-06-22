package com.anserx.yqcoding.mq.core;

import com.anserx.yqcoding.mq.bean.BaseMessage;
import com.anserx.yqcoding.mq.bean.QueueDefinition;
import com.anserx.yqcoding.mq.config.RabbitmqConfig;
import com.anserx.yqcoding.mq.dto.ConsumerLogDto;
import com.anserx.yqcoding.mq.dto.ProducerLogDto;
import com.anserx.yqcoding.mq.service.ConsumerLogService;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;


@Component
@Slf4j
public class DefaultBaseConsumer {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ConsumerLogService consumerLogService;


    @RabbitListener(queues = {"#{rabbitmqConfig.getAllQueue()}"},concurrency = "2",errorHandler = "defaultRabbitListenerErrorHandler")
    public void consumerMoreQueue1(Message message, Channel channel) throws IOException {
        try {
            String consumerQueue = message.getMessageProperties().getConsumerQueue();
            QueueDefinition queueDefinition = RabbitmqConfig.getQueueDefinition(consumerQueue);
            String messageBody = new String(message.getBody(), "UTF-8");
            Gson gson = new Gson();
            BaseConsumer baseConsumer = (BaseConsumer) applicationContext.getBean(queueDefinition.getConsumerBeanName());
            Map map = gson.fromJson(messageBody, Map.class);
            Long messageId = BigDecimal.valueOf((double)map.get("messageId")).longValue();
            Map<String, Object> params = Maps.newHashMap();
            params.put("message_id",messageId);
            boolean exits = consumerLogService.exits(params);
            if (exits){
                log.error("{} 消息重复消费",messageId);
                return;
            }
            ConsumerLogDto log = new ConsumerLogDto()
                    .setMessageId(messageId)
//                    .setRequestParam(queueDefinitionEnum.getClass().getName()+"."+queueDefinitionEnum.name())
                    .setQueueInfo(messageBody);
            log.setCreator(0L).setCreateTime(LocalDateTime.now());
            consumerLogService.insert(log);
            baseConsumer.handle(gson.fromJson(map.get("data").toString(),queueDefinition.getBoClass()));
        } catch (RuntimeException exception){
            exception.printStackTrace();
            log.error("消费失败");
            throw new RuntimeException(exception.getCause());
        } finally {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }


}
