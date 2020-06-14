package com.anserx.yqcoding.admin.controller;

import com.anserx.yqcoding.mq.producer.TestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConttoller {

    @Autowired
    private TestProducer testProducer;

    @GetMapping("/testGet")
    public String testGet(){
        testProducer.send();
        return "111111";
    }
}
