package com.anserx.yqcoding.oauth.service.impl;

import com.anserx.yqcoding.common.core.service.impl.BaserServiceImpl;
import com.anserx.yqcoding.oauth.dto.UserRoleDto;
import com.anserx.yqcoding.oauth.entity.AccessToken;
import com.anserx.yqcoding.oauth.entity.UserRole;
import com.anserx.yqcoding.oauth.mapper.UserRoleMapper;
import com.anserx.yqcoding.oauth.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色信息  服务实现类
 * </p>
 *
 * @author zengrui
 * @since 2020-06-24
 */
@Service
public class UserRoleServiceImpl extends BaserServiceImpl<UserRoleMapper, UserRole, UserRoleDto> implements UserRoleService, IService<UserRole> {

}
