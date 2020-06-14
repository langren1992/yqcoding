package com.anserx.yqcoding.mq.core;

import com.anserx.yqcoding.mq.bean.QueueDefinition;
import com.anserx.yqcoding.mq.config.RabbitmqConfig;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import java.io.IOException;


@Component
@Slf4j
public class DefaultBaseConsumer {

    @Autowired
    private ApplicationContext applicationContext;

    @RabbitListener(queues = {"#{rabbitmqConfig.getAllQueue()}"},concurrency = "2",errorHandler = "defaultRabbitListenerErrorHandler")
    public void consumerMoreQueue1(Message message, Channel channel) throws IOException {
        try {
            String consumerQueue = message.getMessageProperties().getConsumerQueue();
            QueueDefinition queueDefinition = RabbitmqConfig.getQueueDefinition(consumerQueue);
            String messageBody = new String(message.getBody(), "UTF-8");
            Gson gson = new Gson();
            BaseConsumer baseConsumer = (BaseConsumer) applicationContext.getBean(queueDefinition.getConsumerClass());
            baseConsumer.handle(gson.fromJson(messageBody, queueDefinition.getBoClass()));
        } catch (RuntimeException exception){
            exception.printStackTrace();
            log.error("消费失败");
            throw new RuntimeException(exception.getCause());
        } finally {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }


}
