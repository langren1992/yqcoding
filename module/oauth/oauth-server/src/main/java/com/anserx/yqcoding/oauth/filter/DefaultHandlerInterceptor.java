package com.anserx.yqcoding.oauth.filter;

import com.anserx.yqcoding.common.util.JsonUtils;
import com.anserx.yqcoding.common.util.Result;
import com.anserx.yqcoding.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Optional;

/**
 * 
 * @class DefaultHandlerInterceptor
 * @description accesstoken 正确性验证拦截器
 *
 * @author zengrui
 * @datetime 2020-06-26 23:47
 * @version 1.0
 **/
public class DefaultHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenStore tokenStore;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        String accessToken = "";
        String authorization = Optional.ofNullable(request.getHeader("Authorization")).orElse("");
        String parameterAccessToken = request.getParameter("access_token");
        if (StringUtils.isEmpty(authorization) && StringUtils.isEmpty(parameterAccessToken)) {
            JsonUtils.writeValue(response.getOutputStream(),new Result<String>().error("非法的Token值",request.getServletPath()));
            return false;
        }
        if (StringUtils.isNotEmpty(authorization)){
            try {
                accessToken = new String(Base64.getDecoder().decode(authorization)).split(" ")[1];
            } catch (Exception e) {
                JsonUtils.writeValue(response.getOutputStream(),new Result<String>().error("非法的Token值",request.getServletPath()));
                return false;
            }
        }
        if (StringUtils.isNotEmpty(parameterAccessToken)){
            accessToken = parameterAccessToken;
        }
        OAuth2AccessToken oauth2AccessToken = tokenStore.readAccessToken(accessToken);

        if (oauth2AccessToken == null) {// 非法的Token值
            JsonUtils.writeValue(response.getOutputStream(),new Result<String>().error("非法的Token值",request.getServletPath()));
            return false;
        } else if (oauth2AccessToken.isExpired()) {// token失效
            JsonUtils.writeValue(response.getOutputStream(),new Result<String>().error("非法的Token值",request.getServletPath()));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
    }

}
