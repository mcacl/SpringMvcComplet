package com.springmvccomplete.tool;

import com.springmvccomplete.tool.VerificationCode.VerifyCodeType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration(locations = {"classpath*:*.xml"})
public class VerificationCodeTest
{
    @Test
    public void generateTextCode()
    {
        String code = VerificationCode.generateTextCode(VerifyCodeType.NUM_LOWER, 4, null);
        System.out.println(code);
        Assert.assertNotNull(code);
    }
}