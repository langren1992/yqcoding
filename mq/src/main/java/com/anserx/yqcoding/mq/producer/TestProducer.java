package com.anserx.yqcoding.mq.producer;

import com.anserx.yqcoding.mq.enums.QueueDefinitionEnum;
import com.anserx.yqcoding.mq.bo.TestPerson;
import com.anserx.yqcoding.mq.core.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestProducer {

    @Autowired
    private ProducerService producerService;

    public void send(){
        producerService.producer(QueueDefinitionEnum.A,new TestPerson().setName("1111111").setCode("111111"));
    }

}
