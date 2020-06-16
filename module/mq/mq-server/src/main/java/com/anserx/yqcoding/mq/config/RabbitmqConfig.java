package com.anserx.yqcoding.mq.config;

import com.anserx.yqcoding.mq.bean.BaseQueueDefinition;
import com.anserx.yqcoding.mq.bean.QueueDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据QueueDefinitionEnum中定义的队列进行初始化操作
 *
 * @author zengrui
 * @date 2020-6-14
 */
@Component
@Slf4j
@ConfigurationProperties(prefix = "yqcoding.mq")
public class RabbitmqConfig{

    private List<Class<?>> definitions;

    private final static List<QueueDefinition> queueDefinitionList = new ArrayList<>();

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Autowired
    private RabbitmqConfig rabbitmqConfig;

    public List<Class<?>> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Class<?>> definitions) {
        this.definitions = definitions;
    }

    /**
     * 初始化所有定义的队列
     */
    @PostConstruct
    public void initQueue(){
        for (Class<?> clazz : rabbitmqConfig.getDefinitions()) {
            Object[] constants = clazz.getEnumConstants();
            List<QueueDefinition> definitionList = ((BaseQueueDefinition)constants[0]).getAllQueueDefinition();
            for (QueueDefinition definition : definitionList) {
                Queue queue = new Queue(definition.getQueue());
                Binding binding;
                if (ExchangeTypes.DIRECT.equals(definition.getType())){
                    DirectExchange directExchange = new DirectExchange(definition.getQueue());
                    amqpAdmin.declareQueue(queue);
                    amqpAdmin.declareExchange(directExchange);
                    binding = BindingBuilder.bind(queue).to(directExchange).with(definition.getQueue());
                    amqpAdmin.declareBinding(binding);
                }
                if (ExchangeTypes.TOPIC.equals(definition.getType())){
                    TopicExchange topicExchange = new TopicExchange(definition.getExchange());
                    amqpAdmin.declareQueue(queue);
                    amqpAdmin.declareExchange(topicExchange);
                    binding = BindingBuilder.bind(queue).to(topicExchange).with(definition.getKey());
                    amqpAdmin.declareBinding(binding);
                }
            }
            queueDefinitionList.addAll(definitionList);
        }
    }

    public static String[] getAllQueue(){
        return queueDefinitionList.stream().map(QueueDefinition::getQueue).toArray(String[]::new);
    }

    public static QueueDefinition getQueueDefinition(String queueName){
        return queueDefinitionList.stream().filter(item -> queueName.equals(item.getQueue())).findFirst().orElse(null);
    }
}
