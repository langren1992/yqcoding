package com.anserx.yqcoding.mq.bean;

import lombok.Data;
import org.springframework.amqp.core.ExchangeTypes;

/**
 * 队列定于规范
 *
 * @author zengrui
 * @date 2020-6-14
 */
@Data
public class QueueDefinition {

    private String exchange;

    private String queue;

    private String key;

    private String type;

    private String consumerBeanName;

    private Class<?> boClass;

    public QueueDefinition(String queue, String consumerBeanName,Class<?> boClass) {
        this.queue = queue;
        this.type = ExchangeTypes.DIRECT;
        this.consumerBeanName = consumerBeanName;
        this.boClass = boClass;

    }
}
