package com.anserx.yqcoding.mq.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ConsumerErrorLogDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;
    /**
     * 消息ID
     */
    private Long messageId;

    /**
     * 发送队列
     */
    private String queueInfo;

    /**
     * 请求参数
     */
    private String requestParam;
    /**
     * 创建人
     */
    private Long creator;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
