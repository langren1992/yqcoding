package com.anserx.yqcoding.mq.consumer;

import com.anserx.yqcoding.mq.bo.TestPerson;
import com.anserx.yqcoding.mq.core.BaseAbstractConsumer;
import org.springframework.stereotype.Component;

@Component
public class TestConsumer extends BaseAbstractConsumer<TestPerson> {

    @Override
    public void handle(TestPerson testPerson) {
        System.out.println("testPerson = " + testPerson);
    }
}
