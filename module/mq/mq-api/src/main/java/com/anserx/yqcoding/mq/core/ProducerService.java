package com.anserx.yqcoding.mq.core;

import com.anserx.yqcoding.mq.bean.BaseMessage;
import com.anserx.yqcoding.mq.enums.QueueDefinitionEnum;

public interface ProducerService<D> {

    void producer(QueueDefinitionEnum queueDefination, BaseMessage<D> d);
}
