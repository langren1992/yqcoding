package com.anserx.yqcoding.mq.service.impl;

import com.anserx.yqcoding.common.core.service.impl.BaserServiceImpl;
import com.anserx.yqcoding.mq.dto.ConsumerErrorLogDto;
import com.anserx.yqcoding.mq.entity.ConsumerErrorLog;
import com.anserx.yqcoding.mq.mapper.ConsumerErrorLogMapper;
import com.anserx.yqcoding.mq.service.ConsumerErrorLogService;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 队列消费失败日志  服务实现类
 * </p>
 *
 * @author zengrui
 * @since 2020-06-19
 */
@Service
public class ConsumerErrorLogServiceImpl extends BaserServiceImpl<ConsumerErrorLogMapper, ConsumerErrorLog, ConsumerErrorLogDto> implements ConsumerErrorLogService, IService<ConsumerErrorLog> {

}
