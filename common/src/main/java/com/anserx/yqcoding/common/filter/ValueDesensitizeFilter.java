package com.anserx.yqcoding.common.filter;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.anserx.yqcoding.common.annotation.Desensitization;
import com.anserx.yqcoding.common.enums.SensitiveTypeEnum;
import com.anserx.yqcoding.common.util.DesensitizedUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
@Slf4j
public class ValueDesensitizeFilter implements ValueFilter {


    @Override
    public Object process(Object object, String name, Object value) {
        if (null == value || !(value instanceof String) || ((String) value).length() == 0) {
            return value;
        }
        try {
            Field field = object.getClass().getDeclaredField(name);
            Desensitization desensitization;
            if (String.class != field.getType() || (desensitization = field.getAnnotation(Desensitization.class)) == null) {
                return value;
            }
            String valueStr = (String) value;
            SensitiveTypeEnum type = desensitization.type();
            switch (type) {
                case CHINESE_NAME:
                    return DesensitizedUtil.chineseName(valueStr);
                case ID_CARD:
                    return DesensitizedUtil.idCardNum(valueStr);
                case FIXED_PHONE:
                    return DesensitizedUtil.fixedPhone(valueStr);
                case MOBILE_PHONE:
                    return DesensitizedUtil.mobilePhone(valueStr);
                case ADDRESS:
                    return DesensitizedUtil.address(valueStr, 8);
                case EMAIL:
                    return DesensitizedUtil.email(valueStr);
                case BANK_CARD:
                    return DesensitizedUtil.bankCard(valueStr);
                case PASSWORD:
                    return DesensitizedUtil.password(valueStr);
                case CARNUMBER:
                    return DesensitizedUtil.carNumber(valueStr);
                default:
            }
        } catch (NoSuchFieldException e) {
            log.error("当前数据类型为{},值为{}", object.getClass(), value);
            return value;
        }
        return value;
    }
}
