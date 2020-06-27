package com.anserx.yqcoding.oauth.filter;

import com.anserx.yqcoding.common.enums.CommonErrorEnum;
import com.anserx.yqcoding.common.util.JsonUtils;
import com.anserx.yqcoding.common.util.Result;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @class KaptchaFailureHandler
 * @description 验证码验证失败返回消息格式化处理
 *
 * @author zengrui
 * @datetime 2020-06-27 20:20
 * @version 1.0
 **/
@Component
@Slf4j
public class KaptchaFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @SneakyThrows
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception){
        log.error("验证码验证失败 用户名：{}" ,request.getParameter("username"));
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JsonUtils.toJsonString(new Result<String>().error(CommonErrorEnum.KACPCHAR_ERROR.getKey(),exception.getMessage(),request.getServletPath())));
    }
}
