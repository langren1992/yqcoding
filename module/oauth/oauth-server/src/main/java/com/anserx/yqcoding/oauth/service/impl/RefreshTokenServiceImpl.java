package com.anserx.yqcoding.oauth.service.impl;

import com.anserx.yqcoding.common.core.service.impl.BaserServiceImpl;
import com.anserx.yqcoding.oauth.dto.RefreshTokenDto;
import com.anserx.yqcoding.oauth.entity.AccessToken;
import com.anserx.yqcoding.oauth.entity.RefreshToken;
import com.anserx.yqcoding.oauth.mapper.RefreshTokenMapper;
import com.anserx.yqcoding.oauth.service.RefreshTokenService;
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
public class RefreshTokenServiceImpl extends BaserServiceImpl<RefreshTokenMapper, RefreshToken, RefreshTokenDto> implements RefreshTokenService, IService<RefreshToken> {

}
