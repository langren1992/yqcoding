package com.anserx.yqcoding.oauth.core;

import com.anserx.yqcoding.common.enums.EnableOrDisableEnum;
import com.anserx.yqcoding.common.util.ObjectUtils;
import com.anserx.yqcoding.oauth.dto.UserDto;
import com.anserx.yqcoding.oauth.service.UserService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Map;

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
public class DefaultUserService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<String,Object> usernameParam = Maps.newHashMap();
        usernameParam.put(UserDto.USERNAME,username);
        UserDto userDto = userService.get(usernameParam);
        if (ObjectUtils.isNull(userDto)){
            throw new UsernameNotFoundException("用户名不存在");
        }
        if (EnableOrDisableEnum.DISABLE.getKey().equals(Integer.parseInt(userDto.getStatus()))){
            throw new UsernameNotFoundException("账户已停用");
        }
        return new DefaultUserDetails(userDto.getUsername(),userDto.getPassword(),true,false,false,false, Lists.newArrayList());
    }
}
