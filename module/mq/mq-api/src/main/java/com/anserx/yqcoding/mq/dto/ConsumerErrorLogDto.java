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
     * 失败原因
     */
    private String failureReason;
    /**
     * 创建人
     */
    private Long creator;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public static final String ID = "id";

    public static final String MESSAGE_ID = "message_id";

    public static final String QUEUE_INFO = "queue_info";

    public static final String REQUEST_PARAM = "request_param";

    public static final String FAILURE_REASON = "failure_reason";

    public static final String CREATOR = "creator";

    public static final String CREATE_TIME = "create_time";
}
