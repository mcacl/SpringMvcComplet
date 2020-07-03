package com.springmvccomplete.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springmvccomplete.common.IBaseCtrl;
import com.springmvccomplete.model.ModSysUser;
import com.springmvccomplete.model.ViewMode.VModSysUser;
import com.springmvccomplete.model.common.ModResult;
import com.springmvccomplete.model.common.ModResult.ModResultCode;
import com.springmvccomplete.tool.VerificationCode;
import com.springmvccomplete.tool.VerificationCode.VerifyCodeType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * 创建时间:2020/4/27
 * 创建人:pmc
 * 描述:
 */
@Api("登录类")
@Controller
public class CtrlLogin implements IBaseCtrl
{
    @ApiOperation(value = "登录接口")
    @ResponseBody
    @RequestMapping(value = "loginin", params = {"n", "p", "c"}, method = {RequestMethod.POST})
    public ModResult loginin(@RequestParam("n") String n, @RequestParam("p") String p, @RequestParam("c") String code, @RequestParam(value = "m", required = false) boolean remanber, HttpServletRequest request)
    {
        modResultInit();//初始化返回实体
        String vcode = request.getSession().getAttribute("vcode").toString();
        System.out.println("验证码:输入:" + code + ",生成:" + vcode);
        if (StringUtils.isEmpty(code) || !StringUtils.equals(vcode.toUpperCase(), code.toUpperCase()))
        {
            modResult.setMsg("验证码错误");
            return modResult;
        }
        UsernamePasswordToken token = new UsernamePasswordToken(n, p);
        if (remanber)
        {
            token.setRememberMe(true);
        }
        Subject curruser = SecurityUtils.getSubject();
        try
        {
            curruser.login(token);
        } catch (UnknownAccountException uae)
        {
            System.out.println("对用户[" + n + "]进行登录验证..验证未通过,账户不存在");
            request.setAttribute("message_login", "账户不存在");
            modResult.setMsg("账户不存在");
        } catch (IncorrectCredentialsException ice)
        {
            System.out.println("对用户[" + n + "]进行登录验证..验证未通过,错误的凭证");
            request.setAttribute("message_login", "密码不正确");
            modResult.setMsg("密码不正确");
        } catch (LockedAccountException lae)
        {
            System.out.println("对用户[" + n + "]进行登录验证..验证未通过,账户已锁定");
            request.setAttribute("message_login", "账户已锁定");
            modResult.setMsg("账户已锁定");
        } catch (ExcessiveAttemptsException eae)
        {
            System.out.println("对用户[" + n + "]进行登录验证..验证未通过,错误次数过多");
            request.setAttribute("message_login", "用户名或密码错误次数过多");
            modResult.setMsg("用户名或密码错误次数过多");
        } catch (AuthenticationException ae)
        {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            System.out.println("对用户[" + n + "]进行登录验证..验证未通过,堆栈轨迹如下");
            request.setAttribute("message_login", "用户名或密码不正确");
            modResult.setMsg("用户名或密码不正确");
        }
        if (curruser.isAuthenticated())
        {
            try
            {
                ModSysUser tmoduser = (ModSysUser) curruser.getPrincipal();
                String moduserstr = objectMapper.writeValueAsString(tmoduser);//数据模型转成视图模型
                VModSysUser vModSysUser = objectMapper.readValue(moduserstr, VModSysUser.class);
                modResult.setData(vModSysUser);
                modResult.setCode(ModResultCode.Success);
            } catch (JsonProcessingException e)
            {
                e.printStackTrace();
            }
        } else
        {
            token.clear();
        }
        return modResult;
    }

    @ApiOperation(value = "退出接口")
    @RequestMapping("loginout")
    public String loginout(HttpServletRequest request)
    {
        SecurityUtils.getSubject().logout();
        return "redirect:static/login.html";
    }

    @ResponseBody
    @RequestMapping("vcode")
    public String verifyCode(HttpSession session) throws IOException
    {
        String code = VerificationCode.generateTextCode(VerifyCodeType.ALL_MIXED, 4, null);

        if (session != null)
        {
            session.setAttribute("vcode", code);//验证码放到session中
        }
        BufferedImage img = VerificationCode.generateImageCode(code, 100, 40, 4, true, Color.white, null, null);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", outputStream);
        String base64 = Base64.getEncoder().encodeToString(outputStream.toByteArray());
        return base64;
    }

    @ApiOperation(value = "测试接口")
    @ResponseBody
    @RequestMapping("test")
    public String test(@RequestParam(required = false) String a, HttpServletRequest request)
    {
        return "{\"d\":\"1\",\"a\":\"" + a + "\"}";
    }
}