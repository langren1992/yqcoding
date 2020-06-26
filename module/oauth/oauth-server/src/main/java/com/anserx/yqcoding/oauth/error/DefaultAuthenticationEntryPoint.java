package com.anserx.yqcoding.oauth.error;

import com.anserx.yqcoding.common.enums.CommonErrorEnum;
import com.anserx.yqcoding.common.util.JsonUtils;
import com.anserx.yqcoding.common.util.Result;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Primary
public class DefaultAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @SneakyThrows
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        JsonUtils.writeValue(response.getOutputStream(),new Result<String>().error(CommonErrorEnum.UNAUTHORIZED,request.getServletPath()));
    }
}
