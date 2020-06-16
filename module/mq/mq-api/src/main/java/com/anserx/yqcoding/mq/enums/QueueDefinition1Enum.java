package com.anserx.yqcoding.mq.enums;

import com.anserx.yqcoding.mq.bean.*;
import com.anserx.yqcoding.mq.bean.QueueDefinition;
import com.anserx.yqcoding.mq.bo.TestPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * 队列定于枚举类
 *
 * @author zengrui
 * @date 2020-6-14
 */
public enum QueueDefinition1Enum implements BaseQueueDefinition {
    /**
     * 测试1号队列
     */
    AAA(new QueueDefinition("AAA","testConsumer", TestPerson.class)),
    /**
     * 测试2号队列
     */
    BBB(new QueueDefinition("BBB","testConsumer",TestPerson.class));

    private QueueDefinition queueDefinition;

    QueueDefinition1Enum(QueueDefinition queueDefinition) {
        this.queueDefinition = queueDefinition;
    }

    public QueueDefinition getQueueDefinition() {
        return queueDefinition;
    }

    @Override
    public List<QueueDefinition> getAllQueueDefinition(){
        List<QueueDefinition> queueDefinitions = new ArrayList<>();
        for (QueueDefinition1Enum value : QueueDefinition1Enum.values()) {
            queueDefinitions.add(value.queueDefinition);
        }
        return queueDefinitions;
    }
}
