package com.springmvccomplete.server;

import com.springmvccomplete.common.BaseImpl;
import com.springmvccomplete.common.IBaseDao;
import com.springmvccomplete.dao.ModSysUserMapper;
import com.springmvccomplete.model.ModSysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建时间:2020/6/29
 * 创建人:pmc
 * 描述:
 */
@Service
public class ImplServSysUser extends BaseImpl implements ModSysUserMapper
{
    @Autowired
    ModSysUserMapper modSysUserMapper;

    /**
     * 设置dao接口 实体映射接口Mapper
     *
     * @return IBaseDao
     */
    @Override
    protected IBaseDao getIBaseDao()
    {
        return modSysUserMapper;
    }

    /**
     * 查询登录用户
     *
     * @param loginname 账户
     * @return
     */
    @Override
    public ModSysUser selectlogin(String loginname)
    {
        return modSysUserMapper.selectlogin(loginname);
    }
}
