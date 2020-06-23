package com.anserx.yqcoding.common.serial;

import com.anserx.yqcoding.common.annotation.Desensitization;
import com.anserx.yqcoding.common.enums.SensitiveTypeEnum;
import com.anserx.yqcoding.common.util.DesensitizationUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;


import java.io.IOException;
import java.util.Objects;

/**
 *
 * @description 敏感类型序列化定义
 *
 * @author zengrui
 * @datetime   2020-06-23 17:30
 */
public class SensitiveInfoSerialize extends JsonSerializer<String> implements ContextualSerializer {

    private SensitiveTypeEnum type;

    public SensitiveInfoSerialize() {
    }

    public SensitiveInfoSerialize(final SensitiveTypeEnum type) {
        this.type = type;
    }

    @Override
    public void serialize(final String s, final JsonGenerator jsonGenerator,
                          final SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        switch (this.type) {
            case CHINESE_NAME: {
                jsonGenerator.writeString(DesensitizationUtil.chineseName(s));
                break;
            }
            case ID_CARD: {
                jsonGenerator.writeString(DesensitizationUtil.idCardNum(s));
                break;
            }
            case FIXED_PHONE: {
                jsonGenerator.writeString(DesensitizationUtil.fixedPhone(s));
                break;
            }
            case MOBILE_PHONE: {
                jsonGenerator.writeString(DesensitizationUtil.mobilePhone(s));
                break;
            }
            case ADDRESS: {
                jsonGenerator.writeString(DesensitizationUtil.address(s, 4));
                break;
            }
            case EMAIL: {
                jsonGenerator.writeString(DesensitizationUtil.email(s));
                break;
            }
            case BANK_CARD: {
                jsonGenerator.writeString(DesensitizationUtil.bankCard(s));
                break;
            }
        }

    }

    @Override
    public JsonSerializer<?> createContextual(final SerializerProvider serializerProvider,
                                              final BeanProperty beanProperty) throws JsonMappingException {
        if (beanProperty != null) { // 为空直接跳过
            if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) { // 非 String 类直接跳过
                Desensitization sensitiveInfo = beanProperty.getAnnotation(Desensitization.class);
                if (sensitiveInfo != null) { // 如果能得到注解，就将注解的 value 传入 SensitiveInfoSerialize
                    return new SensitiveInfoSerialize(sensitiveInfo.type());
                }
            }
            return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
        }
        return serializerProvider.findNullValueSerializer(beanProperty);
    }
}
