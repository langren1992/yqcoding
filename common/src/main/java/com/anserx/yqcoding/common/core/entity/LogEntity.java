package com.anserx.yqcoding.common.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;

/**
 * 日志业务的父类
 *
 * @author zengrui
 * @date 2020-6-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public abstract class LogEntity extends BaseEntity {

    private Long creator;

    private LocalDateTime createTime;

}
