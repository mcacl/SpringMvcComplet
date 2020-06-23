package com.springmvccomplete.controller;

import com.springmvccomplete.common.BaseImpl;
import com.springmvccomplete.model.ModSysAuthority;
import com.springmvccomplete.server.ImplServAuthority;
import com.springmvccomplete.tool.VerificationCode;
import com.springmvccomplete.tool.VerificationCode.VerifyCodeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建时间:2020/4/27
 * 创建人:pmc
 * 描述:
 */
@Controller
@RequestMapping("main")
public class CtrlMain extends Ctrl_BaseDao<ModSysAuthority>
{
    @Autowired
    ImplServAuthority implServAuthority;

    /**
     * 初始化Ctrl接口的实现类
     *
     * @return BaseImpl
     */
    @Override
    public BaseImpl setImpl()
    {
        return implServAuthority;
    }

    @ResponseBody
    @RequestMapping(value = "data")
    public ResponseEntity<?> data()
    {
        String code = VerificationCode.generateTextCode(VerifyCodeType.ALL_MIXED, 4, null);
        Map<String, Object> data = new HashMap<>();
        data.put("name", "123");
        data.put("pas", "123");
        data.put("code", code);
        ResponseEntity<?> responseEntity = new ResponseEntity<Object>(data, HttpStatus.OK);
        return responseEntity;
    }
}
