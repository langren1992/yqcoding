package com.anserx.yqcoding.mq.enums;

import com.anserx.yqcoding.mq.bean.BaseQueueDefinition;
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
public enum QueueDefinitionEnum implements BaseQueueDefinition {
    /**
     * 测试1号队列
     */
    A(new QueueDefinition("11111","testConsumer")),
    /**
     * 测试2号队列
     */
    B(new QueueDefinition("22221","testConsumer"));

    private QueueDefinition queueDefinition;

    QueueDefinitionEnum(QueueDefinition queueDefinition) {
        this.queueDefinition = queueDefinition;
    }

    public QueueDefinition getQueueDefinition() {
        return queueDefinition;
    }

    @Override
    public List<QueueDefinition> getAllQueueDefinition(){
        List<QueueDefinition> queueDefinitions = new ArrayList<>();
        for (QueueDefinitionEnum value : QueueDefinitionEnum.values()) {
            queueDefinitions.add(value.queueDefinition);
        }
        return queueDefinitions;
    }
}
