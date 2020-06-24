package com.anserx.yqcoding.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String[] PERMIT_URLS = {
        "/user/trans",
        "/resource/**",
        "/**/api/**",
        "/**/ticket/predictOrder",
        "/**/order/ticket/predictOrder",
        "/**/order/ajax/label/*",
        "/**/api/order/batchCreate",
        "/**/api/platform/sumai/orderNotify",
    };


    @Override
    public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                .antMatchers(PERMIT_URLS).permitAll()
                .antMatchers("/**/platform/**").permitAll()
                .antMatchers("/**/swagger-ui.html", "/**/swagger-resources/**", "/**/v2/api-docs","/**/webjars/**").permitAll()
                .antMatchers("/**").authenticated()
                .anyRequest().authenticated();
    }

}
