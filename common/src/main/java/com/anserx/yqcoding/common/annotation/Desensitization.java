package com.anserx.yqcoding.common.annotation;

import com.anserx.yqcoding.common.enums.SensitiveTypeEnum;

import java.lang.annotation.*;

/**
 *
 * @description 标记需要脱敏字段
 *
 * @author zengrui
 * @datetime   2020-06-22 17:38
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Desensitization {
    SensitiveTypeEnum type();
}
