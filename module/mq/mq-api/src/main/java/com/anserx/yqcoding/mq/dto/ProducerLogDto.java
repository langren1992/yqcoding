package com.anserx.yqcoding.mq.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 队列生产日志 
 * </p>
 *
 * @author zengrui
 * @since 2020-06-19
 */
@Data
@Accessors(chain = true)
public class ProducerLogDto implements Serializable {

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
     * 是否确认
     */
    private Boolean ack;
    /**
     * 创建人
     */
    private Long creator;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public static final String MESSAGE_ID = "message_id";

    public static final String QUEUE_INFO = "queue_info";

    public static final String REQUEST_PARAM = "request_param";

    public static final String ACK = "ack";

}
