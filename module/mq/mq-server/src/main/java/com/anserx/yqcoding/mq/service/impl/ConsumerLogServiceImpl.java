package com.anserx.yqcoding.mq.service.impl;

import com.anserx.yqcoding.common.core.service.impl.BaserServiceImpl;
import com.anserx.yqcoding.mq.dto.ConsumerLogDto;
import com.anserx.yqcoding.mq.entity.ConsumerLog;
import com.anserx.yqcoding.mq.mapper.ConsumerLogMapper;
import com.anserx.yqcoding.mq.service.ConsumerLogService;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 队列消费日志  服务实现类
 * </p>
 *
 * @author zengrui
 * @since 2020-06-19
 */
@Service
public class ConsumerLogServiceImpl extends BaserServiceImpl<ConsumerLogMapper, ConsumerLog, ConsumerLogDto> implements ConsumerLogService, IService<ConsumerLog> {

}
