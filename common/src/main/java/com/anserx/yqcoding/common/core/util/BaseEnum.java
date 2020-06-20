package com.anserx.yqcoding.common.core.util;

/**
 *
 * @class BaseEnum
 * @description 枚举基础类规范
 *
 * @author zengrui
 * @datetime 2020-06-20 13:04
 * @version 1.0
 **/
public interface BaseEnum<K,V> {
    /**
     * 获取枚举key
     *
     * @return
     */
    K getKey();

    /**
     * 获取枚举value
     *
     * @return
     */
    V getValue();
}
