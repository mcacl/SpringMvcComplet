package com.springmvccomplete.common;

import com.springmvccomplete.model.common.ModResult;

/**
 * 创建时间:2020/6/19
 * 创建人:pmc
 * 描述:控制器基础增删改查接口
 */
public interface IBaseCtrlDao<T> extends IBaseCtrl
{
    /**
     * 初始化Ctrl接口的实现类
     *
     * @return BaseImpl
     */
    BaseImpl setImpl();

    ModResult add(T t);

    ModResult update(T t);

    ModResult updatenonull(T t);

    ModResult delete(String id);

    ModResult select(T t);

    ModResult selectfirstornull(T t);
}
