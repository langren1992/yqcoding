package com.anserx.yqcoding.oauth.config;

import com.anserx.yqcoding.oauth.error.DefaultAccessDeniedHandler;
import com.anserx.yqcoding.oauth.filter.KaptchaFailureHandler;
import com.anserx.yqcoding.oauth.filter.KaptchaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 
 * @class ResourceServerConfig
 * @description 服务器资源管理
 * 问题：  http://localhost:1700/yqcoding/oauth/authorize?redirect_uri=https://www.baidu.com&client_id=webApp&response_type=code&scope=write
 * 一直在登录页面无法跳转到资源
 * 处理：1.@EnableResourceServer 为 @Order(6)
 *      2.@EnableWebSecurity 为 @Order(2)
 *      https://blog.csdn.net/qq_27828675/article/details/82466599
 * At least one redirect_uri must be registered with the client
 * 处理：需要将回调的地址填写到数据库中
 * @author zengrui
 * @datetime 2020-06-25 11:51
 * @version 1.0
 **/
@Order(6)
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private KaptchaFailureHandler kaptchaFailureHandler;

    @Autowired
    private DefaultAccessDeniedHandler defaultAccessDeniedHandler;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        KaptchaFilter validateCodeFilter = new KaptchaFilter();
        validateCodeFilter.setAuthenticationFailureHandler(kaptchaFailureHandler);
        //限定签名成功的请求
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
            //其他没有限定的请求，允许访问
            .antMatchers("/createKaptcha").permitAll()
            .and().anonymous()//对于没有配置权限的其他请求允许匿名访问
            .and().formLogin()//使用 spring security 默认登录页面
//            .successHandler(defaultAuthenticationSuccessHandler)
            .and().httpBasic().and().csrf().disable();//启用http 基础验证

    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
            .authenticationEntryPoint(authenticationEntryPoint)
            .accessDeniedHandler(defaultAccessDeniedHandler);
    }

}
