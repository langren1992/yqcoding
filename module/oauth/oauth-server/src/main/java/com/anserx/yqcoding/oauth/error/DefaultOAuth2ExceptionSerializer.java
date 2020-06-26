package com.anserx.yqcoding.oauth.error;

import com.anserx.yqcoding.oauth.error.DefaultOAuth2Exception;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
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
public class DefaultOAuth2ExceptionSerializer extends StdSerializer<DefaultOAuth2Exception> {

    protected DefaultOAuth2ExceptionSerializer() {
        super(DefaultOAuth2Exception.class);
    }

    @Override
    public void serialize(DefaultOAuth2Exception value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("code", value.getHttpErrorCode());
        gen.writeStringField("msg", value.getMessage());
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
