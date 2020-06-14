package com.anserx.yqcoding.mq.bo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TestPerson {

    private String name;

    private String code;
}
