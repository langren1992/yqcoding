package com.anserx.yqcoding.oauth.filter;

import com.anserx.yqcoding.common.util.ObjectUtils;
import com.anserx.yqcoding.oauth.error.DefaultAuthenticationException;
import com.anserx.yqcoding.oauth.error.DefaultOAuth2Exception;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/***
 * @title: KaptchaFilter
 * @description:  验证码路径拦截
 * @auther: zengrui
 * @time: 2018/12/14 10:11
 **/
@Component
public class KaptchaFilter extends OncePerRequestFilter {


    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /***
     * @title: doFilterInternal
     * @description: 添加拦截器
     * @param: request
     * @param: response
     * @param: filterChain
     * @return: void
     * @auther: zengrui
     * @time: 2018/12/14 10:41
     **/
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(StringUtils.contains(request.getRequestURI(),"/oauth/token") && StringUtils.equalsIgnoreCase(request.getMethod(), "post")) {
            try {
                // 1. 进行验证码的校验
                validateCaptchaCode(request,response);
            } catch (AuthenticationException e) {
                // 2. 如果校验不通过，调用SpringSecurity的校验失败处理器
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return ;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 3. 校验通过，就放行
        filterChain.doFilter(request, response);
    }

    /***
     * @title: validateCaptchaCode
     * @description: TODO 
     * @param: request
     * @param: response
     * @return: void
     * @auther: zengrui
     * @time: 2018/12/14 10:34 
     **/
    private void validateCaptchaCode(HttpServletRequest request, HttpServletResponse response) {
        Locale locale = LocaleContextHolder.getLocale();
        if (ObjectUtils.isNull(request.getParameter("kaptchaUuid"))) {
            throw new DefaultAuthenticationException("验证码不能为空");
        }
        String reqCaptchaCode = redisTemplate.opsForValue().get(request.getParameter("kaptchaUuid"));
        if (StringUtils.isBlank(reqCaptchaCode)){
            throw new DefaultAuthenticationException("验证码超时");
        }
        redisTemplate.delete(request.getParameter("kaptchaUuid"));
        String captchaCode = request.getParameter("kaptchaCode");
        if (StringUtils.isBlank(reqCaptchaCode) || !reqCaptchaCode.equalsIgnoreCase(captchaCode)){
            throw new DefaultAuthenticationException("验证码匹配错误");
        }
    }

    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }
}
