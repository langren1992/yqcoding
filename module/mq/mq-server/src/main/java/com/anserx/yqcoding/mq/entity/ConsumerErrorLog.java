package com.anserx.yqcoding.mq.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.anserx.yqcoding.bean.LogEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 队列消费失败日志 
 * </p>
 *
 * @author zengrui
 * @since 2020-06-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("mq_consumer_error_log")
public class ConsumerErrorLog extends LogEntity{

    private static final long serialVersionUID = 1L;

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

    public static final String MESSAGE_ID = "message_id";

    public static final String QUEUE_INFO = "queue_info";

    public static final String REQUEST_PARAM = "request_param";

    public static final String FAILURE_REASON = "failure_reason";

}
