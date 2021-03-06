package com.anserx.yqcoding.admin.controller;

import com.anserx.yqcoding.admin.dto.StudentDto;
import com.anserx.yqcoding.mq.producer.TestProducer;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestConttoller {

    @Autowired
    private TestProducer testProducer;


    @GetMapping("/testGet/{id}")
    public Long testGet(@PathVariable("id") String id){
        testProducer.send(id);
        return 111111111111111111L;
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
