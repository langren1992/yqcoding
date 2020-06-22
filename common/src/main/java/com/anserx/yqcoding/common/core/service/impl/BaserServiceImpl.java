package com.anserx.yqcoding.common.core.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.anserx.yqcoding.common.core.service.BaserService;
import com.anserx.yqcoding.common.util.ConvertUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@Slf4j
public class BaserServiceImpl<M extends BaseMapper<E>,E,D> extends ServiceImpl<M,E> implements BaserService<D> {

    private Class<E> entityClass;
    private Class<D> dtoClass;

    public BaserServiceImpl() {
        entityClass = (Class<E>) ReflectionKit.getSuperClassGenericType(getClass(), 1);
        dtoClass = (Class<D>) ReflectionKit.getSuperClassGenericType(getClass(), 2);
    }

    @Autowired
    protected M baseDao;

    @Override
    public D get(Long id) {
        return ConvertUtils.sourceToTarget(this.getById(id),dtoClass);
    }

    @Override
    public boolean exits(Map<String, Object> params) {
        if (CollectionUtil.isEmpty(params)){
            log.error("请求参数为空");
            return false;
        }
        QueryWrapper<E> queryWrapper = new QueryWrapper<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            queryWrapper.eq(entry.getKey(),entry.getValue());
        }
        return ObjectUtil.isNotNull(this.baseDao.selectOne(queryWrapper));
    }

    @Override
    public List<D> list(List<Long> ids) {
        return ConvertUtils.sourceToTarget(this.listByIds(ids),dtoClass);
    }

    @Override
    public boolean insert(D dto) {
        E entity = ConvertUtils.sourceToTarget(dto, entityClass);
        return super.save(entity);
    }

    @Override
    public boolean insertBatch(List<D> dtos) {
        List<E> entityList = ConvertUtils.sourceToTarget(dtos, entityClass);
        return super.saveBatch(entityList);
    }

    @Override
    public boolean update(D dto) {
        E entity = ConvertUtils.sourceToTarget(dto, entityClass);
        return super.saveOrUpdate(entity);
    }

    @Override
    public boolean updates(List<D> dtos) {
        List<E> entityList = ConvertUtils.sourceToTarget(dtos, entityClass);
        return super.saveOrUpdateBatch(entityList);
    }
}
