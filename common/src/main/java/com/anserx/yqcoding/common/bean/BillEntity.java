package com.anserx.yqcoding.common.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 实体的父类
 *
 * @author zengrui
 * @date 2020-6-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public abstract class BillEntity extends LogEntity {

    private Long modifier;

    private LocalDateTime modifyTime;
}
