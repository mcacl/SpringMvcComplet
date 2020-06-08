package com.springmvccomplete.controller;

import com.springmvccomplete.tool.VerificationCode;
import com.springmvccomplete.tool.VerificationCode.VerifyCodeType;
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
public class CtrlMain
{
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
