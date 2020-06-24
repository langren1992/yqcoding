package com.anserx.yqcoding.oauth.service.impl;

import com.anserx.yqcoding.common.core.service.impl.BaserServiceImpl;
import com.anserx.yqcoding.oauth.dto.RoleDto;
import com.anserx.yqcoding.oauth.entity.AccessToken;
import com.anserx.yqcoding.oauth.entity.Role;
import com.anserx.yqcoding.oauth.mapper.RoleMapper;
import com.anserx.yqcoding.oauth.service.RoleService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息  服务实现类
 * </p>
 *
 * @author zengrui
 * @since 2020-06-24
 */
@Service
public class RoleServiceImpl extends BaserServiceImpl<RoleMapper, Role, RoleDto> implements RoleService, IService<Role> {

}
