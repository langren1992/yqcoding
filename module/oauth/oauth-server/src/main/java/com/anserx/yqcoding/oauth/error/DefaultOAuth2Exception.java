package com.anserx.yqcoding.oauth.error;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 
 * @class DefaultOAuth2Exception
 * @description 自定义异常类
 *
 * @author zengrui
 * @datetime 2020-06-25 22:36
 * @version 1.0
 **/
@JsonSerialize(using = DefaultOAuth2ExceptionSerializer.class)
public class DefaultOAuth2Exception extends OAuth2Exception {

    public DefaultOAuth2Exception(String msg, Throwable t) {
        super(msg, t);
    }

    public DefaultOAuth2Exception(String msg) {
        super(msg);
    }
}
