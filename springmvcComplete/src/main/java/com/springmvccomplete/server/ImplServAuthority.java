package com.springmvccomplete.server;

import com.springmvccomplete.common.BaseImpl;
import com.springmvccomplete.common.IBaseDao;
import com.springmvccomplete.dao.ModSysAuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建时间:2020/6/19
 * 创建人:pmc
 * 描述:
 */
@Service
public class ImplServAuthority extends BaseImpl
{
    @Autowired
    private ModSysAuthorityMapper modSysAuthorityMapper;

    @Override
    protected IBaseDao getIBaseDao()
    {
        return modSysAuthorityMapper;
    }
}