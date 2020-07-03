package com.springmvccomplete.dao;

import com.springmvccomplete.common.IBaseDao;
import com.springmvccomplete.model.ModSysUser;

public interface ModSysUserMapper extends IBaseDao
{
    /**
     * 查询登录用户
     * @param loginname 账户
     * @return
     */
    ModSysUser selectlogin(String loginname);
}