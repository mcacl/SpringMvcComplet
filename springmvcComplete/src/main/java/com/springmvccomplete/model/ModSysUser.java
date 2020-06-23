package com.springmvccomplete.model;

import java.util.Date;

public class ModSysUser {
    private Integer userid;

    private String name;

    private Integer sex;

    private String email;

    private Date latelogintime;

    private String loginname;

    private String phone;

    private Integer islogin;

    private String pas;

    private Integer groupid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getLatelogintime() {
        return latelogintime;
    }

    public void setLatelogintime(Date latelogintime) {
        this.latelogintime = latelogintime;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getIslogin() {
        return islogin;
    }

    public void setIslogin(Integer islogin) {
        this.islogin = islogin;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas == null ? null : pas.trim();
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }
}