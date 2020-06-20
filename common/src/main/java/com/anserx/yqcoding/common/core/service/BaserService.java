package com.anserx.yqcoding.common.core.service;

import com.anserx.yqcoding.common.core.util.ConvertUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @class BaserService
 * @description Service通用方法
 * D:实体Dto
 * E:实体Entity
 *
 * @author zengrui
 * @datetime 2020-06-20 11:44
 * @version 1.0
 **/
public interface BaserService<D> {

    /**
     *
     * @method get
     * @description 通过ID获取DTO
     *
     * @author zengrui
     * @date 11:55 11:55
     * @param: i id
     * @return D DTO实体对象
     **/
    D get(Long id);

    List<D> list(List<Long> ids);

    boolean insert(D dto);

    boolean insertBatch(List<D> dtos);

    boolean update(D dto);

    boolean updates(List<D> dtos);

}
