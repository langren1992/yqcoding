package com.anserx.yqcoding.common.format;

import com.anserx.yqcoding.common.enums.SensitiveTypeEnum;
import com.anserx.yqcoding.common.util.DesensitizedUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;

import java.util.Locale;

public class DesensitizedFormatter implements Formatter<String> {
    private SensitiveTypeEnum typeEnum;

    public SensitiveTypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(SensitiveTypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    @Override
    public String parse(String valueStr, Locale locale) throws ParseException {
        if (StringUtils.isNotBlank(valueStr)) {
            switch (typeEnum) {
                case CHINESE_NAME:
                    valueStr = DesensitizedUtil.chineseName(valueStr);
                    break;
                case ID_CARD:
                    valueStr = DesensitizedUtil.idCardNum(valueStr);
                    break;
                case FIXED_PHONE:
                    valueStr = DesensitizedUtil.fixedPhone(valueStr);
                    break;
                case MOBILE_PHONE:
                    valueStr = DesensitizedUtil.mobilePhone(valueStr);
                    break;
                case ADDRESS:
                    valueStr = DesensitizedUtil.address(valueStr, 8);
                    break;
                case EMAIL:
                    valueStr = DesensitizedUtil.email(valueStr);
                    break;
                case BANK_CARD:
                    valueStr = DesensitizedUtil.bankCard(valueStr);
                    break;
                case PASSWORD:
                    valueStr = DesensitizedUtil.password(valueStr);
                    break;
                case CARNUMBER:
                    valueStr = DesensitizedUtil.carNumber(valueStr);
                    break;
                default:
            }
        }
        return valueStr;
    }

    @Override
    public String print(String s, Locale locale) {
        return s;
    }
}
