package com.anserx.yqcoding.mq.service.impl;

import com.anserx.yqcoding.common.core.service.impl.BaserServiceImpl;
import com.anserx.yqcoding.mq.dto.ConsumerErrorLogDto;
import com.anserx.yqcoding.mq.dto.ProducerLogDto;
import com.anserx.yqcoding.mq.entity.ConsumerErrorLog;
import com.anserx.yqcoding.mq.entity.ProducerLog;
import com.anserx.yqcoding.mq.mapper.ProducerLogMapper;
import com.anserx.yqcoding.mq.service.ConsumerErrorLogService;
import com.anserx.yqcoding.mq.service.ProducerLogService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 队列生产日志  服务实现类
 * </p>
 *
 * @author zengrui
 * @since 2020-06-19
 */
@Service
public class ProducerLogServiceImpl extends BaserServiceImpl<ProducerLogMapper, ProducerLog, ProducerLogDto> implements ProducerLogService, IService<ProducerLog> {

}
