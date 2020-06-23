package com.anserx.yqcoding.mq.producer;

import com.anserx.yqcoding.mq.bean.BaseMessage;
import com.anserx.yqcoding.mq.core.ProducerService;
import com.anserx.yqcoding.mq.enums.QueueDefinitionEnum;
import com.anserx.yqcoding.mq.bo.TestPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestProducer {

    @Autowired
    private ProducerService producerService;

    public void send(String id){
        BaseMessage<TestPerson> d = new BaseMessage<>();
        d.setMessageId(Long.parseLong(id));
        d.setData(new TestPerson().setName("1111111").setCode("111111"));
        producerService.producer(QueueDefinitionEnum.A,d);
    }

}
