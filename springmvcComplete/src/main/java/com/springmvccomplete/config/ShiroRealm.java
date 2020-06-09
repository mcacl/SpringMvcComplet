package com.springmvccomplete.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.util.HashSet;
import java.util.Set;

/**
 * 创建时间:2020/4/30
 * 创建人:pmc
 * 描述:
 */
public class ShiroRealm extends AuthorizingRealm
{
    //授权信息 调用时机为需授权资源被访问时
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {
        String currentuser = (String) super.getAvailablePrincipal(principalCollection);//当前登录用户的角色
        Set<String> jueseset = new HashSet<>();//角色
        Set<String> quanxianset = new HashSet<>();//权限
        //数据库查询角色和权限加到set中
        jueseset.add("user");//赋予user角色
        quanxianset.add("edit");//赋予edit权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(jueseset);
        info.setStringPermissions(quanxianset);
        return info;
    }

    //认证信息 调用时机为LoginController.login()方法中执行Subject.login()时
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {
        UsernamePasswordToken userinfo = (UsernamePasswordToken) authenticationToken;//强制转为用户密码信息
        if (userinfo.getUsername() != null)
        {
            return new SimpleAuthenticationInfo(userinfo.getUsername(), userinfo.getPassword(), getName());
        } else
            //直接返回null的话,就会导致任何用户访问配置需要认证的资源都会自动跳转到unauthorizedUrl指定的地址
            //详见applicationContext.xml中的<bean id="shiroFilter">的配置
            return null;
    }

    /**
     * 可以将角色和权限存入session 便于其它地方使用
     *
     * @param key
     * @param value
     */
    private void setSession(Object key, Object value)
    {
        Subject curruser = SecurityUtils.getSubject();
        if (curruser != null)
        {
            Session session = curruser.getSession();
            if (session != null)
                session.setAttribute(key, value);
        }
    }
}
