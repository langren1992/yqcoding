package com.anserx.yqcoding.mq.service.impl;

import com.anserx.yqcoding.mq.entity.ProducerLog;
import com.anserx.yqcoding.mq.mapper.ProducerLogMapper;
import com.anserx.yqcoding.mq.service.IProducerLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 队列生产日志  服务实现类
 * </p>
 *
 * @author zengrui
 * @since 2020-06-18
 */
@Service
public class ProducerLogServiceImpl extends ServiceImpl<ProducerLogMapper, ProducerLog> implements IProducerLogService {

}
