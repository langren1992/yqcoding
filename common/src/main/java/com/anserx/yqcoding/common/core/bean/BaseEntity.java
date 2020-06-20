package com.anserx.yqcoding.common.core.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 实体的父类
 *
 * @author zengrui
 * @date 2020-6-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public abstract class BaseEntity {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
}
