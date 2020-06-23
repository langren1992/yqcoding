package com.anserx.yqcoding.common.annotation;

import com.anserx.yqcoding.common.enums.SensitiveTypeEnum;
import com.anserx.yqcoding.common.serial.SensitiveSerialize;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.*;

/**
 *
 * @description 标记需要脱敏字段
 *
 * @author zengrui
 * @datetime   2020-06-22 17:38
 */
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = SensitiveSerialize.class)
public @interface Desensitization {
    SensitiveTypeEnum type();
}
