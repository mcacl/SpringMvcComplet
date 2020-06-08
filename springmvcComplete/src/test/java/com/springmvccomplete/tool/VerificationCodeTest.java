package com.springmvccomplete.tool;

import com.springmvccomplete.tool.VerificationCode.VerifyCodeType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
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