package com.anserx.yqcoding.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    private final DefaultUserService defaultUserService;


    @Autowired
    public WebSecurityConfiguration(DefaultUserService defaultUserService) {
        this.defaultUserService = defaultUserService;
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(defaultUserService);
    }

}
