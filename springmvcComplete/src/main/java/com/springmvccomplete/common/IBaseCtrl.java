package com.springmvccomplete.common;

import com.springmvccomplete.model.common.ModResult;

/**
 * 创建时间:2020/6/22
 * 创建人:pmc
 * 描述:控制器基础接口
 */
public interface IBaseCtrl
{
    /**
     * 申明控制器返回实体
     */
    ModResult modResult = new ModResult(1);//默认成功
}
