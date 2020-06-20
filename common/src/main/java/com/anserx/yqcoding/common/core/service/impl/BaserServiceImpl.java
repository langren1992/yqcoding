package com.anserx.yqcoding.common.core.service.impl;

import com.anserx.yqcoding.common.core.service.BaserService;
import com.anserx.yqcoding.common.core.util.ConvertUtils;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

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
