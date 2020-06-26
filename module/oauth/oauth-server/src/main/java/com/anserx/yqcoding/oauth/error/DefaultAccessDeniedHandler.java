package com.anserx.yqcoding.oauth.error;

import com.anserx.yqcoding.common.enums.CommonErrorEnum;
import com.anserx.yqcoding.common.util.JsonUtils;
import com.anserx.yqcoding.common.util.Result;
import lombok.SneakyThrows;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DefaultAccessDeniedHandler implements AccessDeniedHandler {

    @SneakyThrows
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException){
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(JsonUtils.toJsonString(new Result<String>().error(CommonErrorEnum.UNAUTHORIZED,request.getServletPath())));
    }
}

