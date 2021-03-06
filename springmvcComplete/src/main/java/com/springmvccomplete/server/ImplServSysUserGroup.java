package com.springmvccomplete.server;

import com.springmvccomplete.common.BaseImpl;
import com.springmvccomplete.common.IBaseDao;
import com.springmvccomplete.dao.ModSysUserGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建时间:2020/6/29
 * 创建人:pmc
 * 描述:
 */
@Service
public class ImplServSysUserGroup extends BaseImpl
{
    @Autowired
    ModSysUserGroupMapper modSysUserGroupMapper;

    /**
     * 设置dao接口 实体映射接口Mapper
     *
     * @return IBaseDao
     */
    @Override
    protected IBaseDao getIBaseDao()
    {
        return modSysUserGroupMapper;
    }
}
