package com.anserx.yqcoding.oauth.service.impl;

import com.anserx.yqcoding.common.core.service.impl.BaserServiceImpl;
import com.anserx.yqcoding.oauth.dto.UserDto;
import com.anserx.yqcoding.oauth.entity.AccessToken;
import com.anserx.yqcoding.oauth.entity.User;
import com.anserx.yqcoding.oauth.mapper.UserMapper;
import com.anserx.yqcoding.oauth.service.UserService;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息  服务实现类
 * </p>
 *
 * @author zengrui
 * @since 2020-06-24
 */
@Service
public class UserServiceImpl extends BaserServiceImpl<UserMapper, User, UserDto> implements UserService, IService<User> {

}
