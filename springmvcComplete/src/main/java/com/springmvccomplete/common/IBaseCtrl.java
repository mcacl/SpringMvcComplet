package com.springmvccomplete.common;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmvccomplete.model.common.ModResult;
import com.springmvccomplete.model.common.ModResult.ModResultCode;

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
    ModResult modResult = new ModResult(ModResultCode.Failed);//默认失败
    /**
     * 公共的json序列化对象
     */
    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 初始化公共modResult 由于是控制器是单例模式 又不想每个方法都创建返回实体 所以在控制器方法最开始重置实体内容 否则上次请求的实体会干扰到当前请求的实体
     */
    default void modResultInit()
    {
        if (modResult != null)
        {
            modResult.setCode(ModResultCode.Failed);
            modResult.setMsg("");
            modResult.setData(null);
        }
        //设置objectMapper反序列化时忽略没有的字段
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
