package com.anserx.yqcoding.oauth.service.impl;

import com.anserx.yqcoding.common.core.service.impl.BaserServiceImpl;
import com.anserx.yqcoding.oauth.dto.AccessTokenDto;
import com.anserx.yqcoding.oauth.entity.AccessToken;
import com.anserx.yqcoding.oauth.mapper.AccessTokenMapper;
import com.anserx.yqcoding.oauth.service.AccessTokenService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zengrui
 * @since 2020-06-24
 */
@Service
public class AccessTokenServiceImpl extends BaserServiceImpl<AccessTokenMapper, AccessToken, AccessTokenDto> implements AccessTokenService, IService<AccessToken> {

}
