package com.anserx.yqcoding.oauth.config;

import com.anserx.yqcoding.oauth.error.DefaultAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;

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
    private DefaultAccessDeniedHandler defaultAccessDeniedHandler;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); //禁用了 csrf 功能
        http.authorizeRequests()//限定签名成功的请求
            .anyRequest().permitAll()//其他没有限定的请求，允许访问
            .and().anonymous()//对于没有配置权限的其他请求允许匿名访问
            .and().formLogin()//使用 spring security 默认登录页面
            .and().httpBasic();//启用http 基础验证

    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
            .authenticationEntryPoint(authenticationEntryPoint)
            .accessDeniedHandler(defaultAccessDeniedHandler);
    }

}
