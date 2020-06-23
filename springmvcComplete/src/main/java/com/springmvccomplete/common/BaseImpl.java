package com.springmvccomplete.common;

import java.util.List;

/**
 * 创建时间:2020/6/19
 * 创建人:pmc
 * 描述:基础实现类
 */
public abstract class BaseImpl implements IBaseDao
{
    /**
     * 设置dao接口 实体映射接口Mapper
     *
     * @return IBaseDao
     */
    protected abstract IBaseDao getIBaseDao();

    @Override
    public <T> int add(T t)
    {
        return getIBaseDao().add(t);
    }

    @Override
    public <T> int update(T t)
    {
        return getIBaseDao().update(t);
    }

    @Override
    public <T> int updatenonull(T t)
    {
        return getIBaseDao().updatenonull(t);
    }

    @Override
    public int delete(String id)
    {
        return getIBaseDao().delete(id);
    }

    @Override
    public <T> List<T> select(T t)
    {
        return getIBaseDao().select(t);
    }

    @Override
    public <T> T selectfirstornull(T t)
    {
        T obj = getIBaseDao().selectfirstornull(t);
        return obj;
    }
}
