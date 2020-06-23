package com.springmvccomplete.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建时间:2020/6/8
 * 创建人:pmc
 * 描述:公共异常处理
 */
@Component
public class ComException implements HandlerExceptionResolver
{
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e)
    {
        //错误统一处理
        System.out.println(e.getMessage());
        return null;
    }
}