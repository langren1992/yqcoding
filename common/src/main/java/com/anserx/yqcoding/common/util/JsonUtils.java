package com.anserx.yqcoding.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 *
 * @description json转换工具类
 *
 * @author zengrui
 * @datetime   2020-06-23 17:49
 */
public class JsonUtils {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * object 转换 json字符串
     */
    public static String toJsonString(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * object忽略空值 转换为 json字符串
     */
    public static String toJsonStringIgnoreNull(Object obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsString(obj);
    }

    /**
     * json字符串 转 JavaBean
     */
    public static <T> T toObject(String jsonString, Class<T> clazz) throws Exception {
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return objectMapper.readValue(jsonString, clazz);
    }

    /**
     * json字符串转 换为 map
     */
    public static <T> Map<String, Object> toMap(String jsonString) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.readValue(jsonString, Map.class);
    }

    /**
     * map 转json字符串
     */
    public static String toJsonString(Map map) throws Exception {
        return objectMapper.writeValueAsString(map);
    }
}
