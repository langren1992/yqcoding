package com.anserx.yqcoding.mq.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.anserx.yqcoding.common.bean.LogEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 队列生产日志 
 * </p>
 *
 * @author zengrui
 * @since 2020-06-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("mq_producer_log")
public class ProducerLog extends LogEntity{

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
     * 是否确认
     */
    private Boolean ack;

    public static final String MESSAGE_ID = "message_id";

    public static final String QUEUE_INFO = "queue_info";

    public static final String REQUEST_PARAM = "request_param";

    public static final String ACK = "ack";

}
