package com.springmvccomplete.model.ViewMode;

import java.util.Date;

/**
 * 创建时间:2020/6/29
 * 创建人:pmc
 * 描述:
 */
public class VModSysUser
{
    private Integer userid;

    private String name;

    private Date latelogintime;

    private String loginname;

    private String phone;

    private Integer groupid;

    public Integer getUserid()
    {
        return userid;
    }

    public void setUserid(Integer userid)
    {
        this.userid = userid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }

    public Date getLatelogintime()
    {
        return latelogintime;
    }

    public void setLatelogintime(Date latelogintime)
    {
        this.latelogintime = latelogintime;
    }

    public String getLoginname()
    {
        return loginname;
    }

    public void setLoginname(String loginname)
    {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getGroupid()
    {
        return groupid;
    }

    public void setGroupid(Integer groupid)
    {
        this.groupid = groupid;
    }
}
