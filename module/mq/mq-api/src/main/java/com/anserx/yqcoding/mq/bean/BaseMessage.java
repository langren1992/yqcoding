package com.anserx.yqcoding.mq.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 消息发送基础类
 *
 * @param <D> 业务消息
 * @author zengrui
 * @date 2020-6-19
 */
@Data
@Accessors(chain = true)
public class BaseMessage<D> {

    private Long messageId;

    private D data;
}
