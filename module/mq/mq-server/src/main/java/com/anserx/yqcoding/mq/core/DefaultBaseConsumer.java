package com.anserx.yqcoding.mq.core;

import com.anserx.yqcoding.common.util.ExceptionUtils;
import com.anserx.yqcoding.mq.MqConstant;
import com.anserx.yqcoding.mq.bean.BaseMessage;
import com.anserx.yqcoding.mq.bean.QueueDefinition;
import com.anserx.yqcoding.mq.config.RabbitmqConfig;
import com.anserx.yqcoding.mq.dto.ConsumerErrorLogDto;
import com.anserx.yqcoding.mq.dto.ConsumerLogDto;
import com.anserx.yqcoding.mq.dto.ProducerLogDto;
import com.anserx.yqcoding.mq.service.ConsumerErrorLogService;
import com.anserx.yqcoding.mq.service.ConsumerLogService;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Map;


@Component
@Slf4j
public class DefaultBaseConsumer {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ConsumerLogService consumerLogService;
    
    @Autowired
    private ConsumerErrorLogService consumerErrorLogService;


    @RabbitListener(queues = {"#{rabbitmqConfig.getAllQueue()}"},concurrency = "2",errorHandler = "defaultRabbitListenerErrorHandler")
    public void consumerMoreQueue(Message message, Channel channel) throws IOException {
        // 获取队列参数
        MessageProperties messageProperties = message.getMessageProperties();
        Map<String, Object> headers = messageProperties.getHeaders();
        String consumerQueue = messageProperties.getConsumerQueue();
        // 获取消息header
        Long messageId = Long.parseLong(String.valueOf(headers.get(MqConstant.MQ_HEADER_MESSAGE_ID)));
        String queueDefinitionHeader = headers.get(MqConstant.MQ_HEADER_QUEUE_DEFINITION).toString();
        // 获取消息
        String messageBody = new String(message.getBody(), StandardCharsets.UTF_8);
        try {
            Map<String, Object> params = Maps.newHashMap();
            params.put(ConsumerLogDto.MESSAGE_ID,messageId);
            boolean exits = consumerLogService.exits(params);
            if (exits){
                log.error("队列：{} 消息ID:{} 消息重复消费",messageProperties.getConsumerQueue(),messageId);
                return;
            }
            ConsumerLogDto log = new ConsumerLogDto()
                    .setMessageId(messageId)
                    .setRequestParam(messageBody)
                    .setQueueInfo(queueDefinitionHeader);
            log.setCreator(0L).setCreateTime(LocalDateTime.now());
            consumerLogService.insert(log);

            QueueDefinition queueDefinition = RabbitmqConfig.getQueueDefinition(consumerQueue);
            BaseConsumer baseConsumer = (BaseConsumer) applicationContext.getBean(queueDefinition.getConsumerBeanName());
            Class clazz = ReflectionKit.getSuperClassGenericType(baseConsumer.getClass(), 0);
            Gson gson = new Gson();
            baseConsumer.handle(gson.fromJson(messageBody,clazz));
        } catch (Exception exception){
            exception.printStackTrace();
            log.error("队列：{} 消息ID:{} 消费异常 原因：{}",messageProperties.getConsumerQueue(),messageId, exception.getMessage());
            ConsumerErrorLogDto errorLogDto = new ConsumerErrorLogDto()
                    .setMessageId(messageId)
                    .setRequestParam(messageBody)
                    .setQueueInfo(queueDefinitionHeader)
                    .setFailureReason(ExceptionUtils.getStackTrace(exception.getCause()));
            errorLogDto.setCreator(0L).setCreateTime(LocalDateTime.now());
            consumerErrorLogService.insert(errorLogDto);
        } finally {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }


}
