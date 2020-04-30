package com.springmvccomplete.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * 创建时间:2020/4/30
 * 创建人:pmc
 * 描述:
 */
public class ShiroRealm extends AuthorizingRealm
{
    //授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {
        String currentuser = (String) super.getAvailablePrincipal(principalCollection);//当前登录用户的角色
        Set<String> jueseset = new HashSet<>();
        Set<String> quanxianset = new HashSet<>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(jueseset);
        info.setStringPermissions(quanxianset);
        return info;
    }

    //认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {
        UsernamePasswordToken userinfo = (UsernamePasswordToken) authenticationToken;//强制转为用户密码信息
        if (userinfo.getUsername() != null)
        {
            return new SimpleAuthenticationInfo(userinfo.getUsername(), userinfo.getPassword(), getName());
        }else
            throw new AuthenticationException();
    }
}
