package com.springmvccomplete.tool;

import com.springmvccomplete.tool.VerificationCode.VerifyCodeType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:*.xml"})//不配置读取不到配置文件会报Failed to load ApplicationContext
public class Test1
{
    @Autowired
    ApplicationContext applicationContext;
    @Test
    public void generateTextCode()
    {
        String code = VerificationCode.generateTextCode(VerifyCodeType.NUM_LOWER, 4, null);
        System.out.println(code);
        Assert.assertNotNull(code);
    }

    @Test
    public void data() throws SQLException
    {


    }
}