package com.anserx.yqcoding.common.oauth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @class UserService
 * @description 登录方法
 *
 * @author zengrui
 * @datetime 2020-06-23 23:44
 * @version 1.0
 **/
@Component
@Slf4j
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
