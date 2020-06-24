package com.anserx.yqcoding.oauth.service.impl;

import com.anserx.yqcoding.common.core.service.impl.BaserServiceImpl;
import com.anserx.yqcoding.oauth.dto.ClientDetailsDto;
import com.anserx.yqcoding.oauth.entity.AccessToken;
import com.anserx.yqcoding.oauth.entity.ClientDetails;
import com.anserx.yqcoding.oauth.mapper.ClientDetailsMapper;
import com.anserx.yqcoding.oauth.service.ClientDetailsService;
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
public class ClientDetailsServiceImpl extends BaserServiceImpl<ClientDetailsMapper, ClientDetails, ClientDetailsDto> implements ClientDetailsService, IService<ClientDetails> {

}
