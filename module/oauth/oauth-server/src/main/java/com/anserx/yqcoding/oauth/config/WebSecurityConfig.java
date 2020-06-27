package com.anserx.yqcoding.oauth.config;

import com.anserx.yqcoding.oauth.core.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 *
 * @class WebSecurityConfig
 * @description 安全策略配置
 *
 * @author zengrui
 * @datetime 2020-06-25 11:56
 * @version 1.0
 **/
/**
 * 处理 Consider defining a bean of type 'org.springframework.security.authentication.AuthenticationManager' in your configuration. 问题
 */
@Order(2)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DefaultUserService defaultUserService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // 设置userDetailsService
        provider.setUserDetailsService(defaultUserService);
        // 禁止隐藏用户未找到异常
        provider.setHideUserNotFoundExceptions(false);
        // 使用BCrypt进行密码的hash
//        provider.setPasswordEncoder(new BCryptPasswordEncoder(6));
        return provider;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
            .requestMatchers().antMatchers(
                "/oauth/authorize", "/oauth/token","/oauth/check_token","/oauth/confirm_access","/oauth/error",
                            "/login/**", "/logout/**","/createKaptcha"
        )
            .and()
            .authorizeRequests()
            .antMatchers("/oauth/authorize", "/oauth/token","/oauth/check_token","/oauth/confirm_access","/oauth/error").authenticated()
            .and()
            .formLogin()
            .permitAll(); //新增login form支持用户登录及授权

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .authenticationProvider(authenticationProvider());//增加
    }
}
