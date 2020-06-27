package com.anserx.yqcoding.oauth.config;

import com.anserx.yqcoding.oauth.filter.DefaultHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DefaultOauth2WebMvcConfigurer implements WebMvcConfigurer {

    @Bean
    public DefaultHandlerInterceptor defaultHandlerInterceptor() {
        return new DefaultHandlerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(defaultHandlerInterceptor())
            // 排除指定连接不做拦截
            .excludePathPatterns("/auth/**","/createKaptcha");
    }
}
