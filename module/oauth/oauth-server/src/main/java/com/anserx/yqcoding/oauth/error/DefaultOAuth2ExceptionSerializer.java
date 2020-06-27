package com.anserx.yqcoding.oauth.error;

import com.anserx.yqcoding.common.enums.CommonErrorEnum;
import com.anserx.yqcoding.common.util.DateUtils;
import com.anserx.yqcoding.common.util.ExceptionUtils;
import com.anserx.yqcoding.oauth.error.DefaultOAuth2Exception;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * 
 * @class DefaultOAuthExceptionJacksonSerializer
 * @description 异常消息序列化
 *
 * @author zengrui
 * @datetime 2020-06-25 22:58
 * @version 1.0
 **/
@Slf4j
public class DefaultOAuth2ExceptionSerializer extends StdSerializer<DefaultOAuth2Exception> {

    protected DefaultOAuth2ExceptionSerializer() {
        super(DefaultOAuth2Exception.class);
    }

    @Override
    public void serialize(DefaultOAuth2Exception value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        log.error("异常：{}", ExceptionUtils.getStackTrace(value.fillInStackTrace()));
        gen.writeStartObject();
        String message = "";
        if (CommonErrorEnum.BED_REQUEST.getKey().equals(value.getHttpErrorCode())){
            message = "密码错误";
        } else {
            message = value.getMessage();
        }
        gen.writeObjectField("code", value.getHttpErrorCode());
        gen.writeObjectField("date", null);
        gen.writeStringField("dateTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateUtils.DATE_TIME_PATTERN)));
        gen.writeStringField("msg", message);
        gen.writeStringField("path", "");
        if (value.getAdditionalInformation()!=null) {
            for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
                String key = entry.getKey();
                String add = entry.getValue();
                gen.writeStringField(key, add);
            }
        }
        gen.writeEndObject();
    }
}
