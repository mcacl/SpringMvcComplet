package com.springmvccomplete.controller;

import com.springmvccomplete.common.BaseImpl;
import com.springmvccomplete.common.IBaseCtrlDao;
import com.springmvccomplete.model.common.ModResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 创建时间:2020/6/9
 * 创建人:pmc
 * 描述:控制器基础抽象类
 */
public abstract class Ctrl_BaseDao<T> implements IBaseCtrlDao<T>
{
    private BaseImpl impl;

    {
        impl = setImpl();
    }

    @RequestMapping("a")
    @ResponseBody
    @Override
    public ModResult add(@RequestBody T t)
    {
        int num = impl.add(t);
        modResult.setData(num);
        return modResult;
    }

    @RequestMapping("u")
    @ResponseBody
    @Override
    public ModResult update(@RequestBody T t)
    {
        int num = impl.update(t);
        modResult.setData(num);
        return modResult;
    }

    @RequestMapping("un")
    @ResponseBody
    @Override
    public ModResult updatenonull(@RequestBody T t)
    {
        int num = impl.updatenonull(t);
        modResult.setData(num);
        return modResult;
    }

    @RequestMapping("d")
    @ResponseBody
    @Override
    public ModResult delete(@RequestParam String id)
    {
        int num = impl.delete(id);
        modResult.setData(num);
        return modResult;
    }

    @RequestMapping("s")
    @ResponseBody
    @Override
    public ModResult select(@RequestBody(required = false) T t)
    {
        List<T> num = impl.select(t);
        modResult.setData(num);
        return modResult;
    }

    @RequestMapping("sf")
    @ResponseBody
    @Override
    public ModResult selectfirstornull(@RequestBody(required = false) T t)
    {
        T num = impl.selectfirstornull(t);
        modResult.setData(num);
        return modResult;
    }
}
