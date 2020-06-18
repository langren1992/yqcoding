package com.anserx.yqcoding.mq.service.impl;

import com.anserx.yqcoding.mq.entity.ConsumerLog;
import com.anserx.yqcoding.mq.mapper.ConsumerLogMapper;
import com.anserx.yqcoding.mq.service.IConsumerLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 队列消费日志  服务实现类
 * </p>
 *
 * @author zengrui
 * @since 2020-06-18
 */
@Service
public class ConsumerLogServiceImpl extends ServiceImpl<ConsumerLogMapper, ConsumerLog> implements IConsumerLogService {

}
