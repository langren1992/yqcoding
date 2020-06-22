package com.anserx.yqcoding.admin.controller;

import com.anserx.yqcoding.admin.dto.StudentDto;
import com.anserx.yqcoding.mq.producer.TestProducer;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestConttoller {

    @Autowired
    private TestProducer testProducer;


    @GetMapping("/testGet")
    public String testGet(){
        testProducer.send();
        return "111111";
    }

    @GetMapping(value = "/test/desensitization")
    public List<StudentDto> testDesensitization(StudentDto studentDto) {
        List<StudentDto> callRecordReportList = Lists.newArrayList(
              new StudentDto().setChinaName("张淼"),
              new StudentDto().setChinaName("张哈萨克斯看看是")
        );
        return callRecordReportList;
    }
}
