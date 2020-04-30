package com.springmvccomplete.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 创建时间:2020/4/27
 * 创建人:pmc
 * 描述:
 */
@Controller
public class CtrlLogin
{
    @RequestMapping(value = "loginin")
    public String loginin()
    {
        return "redirect:static/page/main/main.html";
    }

    @RequestMapping("loginout")
    public String loginout()
    {
        return "redirect:login.html";
    }

}
