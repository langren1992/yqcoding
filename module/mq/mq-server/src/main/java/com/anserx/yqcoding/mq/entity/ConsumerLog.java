package com.anserx.yqcoding.mq.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.anserx.yqcoding.common.core.entity.LogEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 队列消费日志 
 * </p>
 *
 * @author zengrui
 * @since 2020-06-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("mq_consumer_log")
public class ConsumerLog extends LogEntity{

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

    public static final String MESSAGE_ID = "message_id";

    public static final String QUEUE_INFO = "queue_info";

    public static final String REQUEST_PARAM = "request_param";

}
