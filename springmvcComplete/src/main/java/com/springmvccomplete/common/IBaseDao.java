package com.springmvccomplete.common;

import java.util.List;

/**
 * 创建时间:2020/6/19
 * 创建人:pmc
 * 描述:基本dao接口
 */
public interface IBaseDao
{
    <T> int add(T t);

    <T> int update(T t);

    <T> int updatenonull(T t);

    int delete(String id);

    <T> List<T> select(T t);

    default <T> T selectfirstornull(T t)
    {
        List<T> list = select(t);
        if (list.size() > 0)
        {
            return list.get(0);
        }
        return null;
    }
}
