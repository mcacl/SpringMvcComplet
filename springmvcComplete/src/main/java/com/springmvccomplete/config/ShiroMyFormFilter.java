package com.springmvccomplete.config;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 创建时间:2020/6/30
 * 创建人:pmc
 * 描述:
 */
public class ShiroMyFormFilter extends FormAuthenticationFilter
{
    private static final Logger log = LoggerFactory.getLogger(ShiroMyFormFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception
    {
        if (this.isLoginRequest(request, response))
        {
            if (this.isLoginSubmission(request, response))
            {
                if (log.isTraceEnabled())
                {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }

                return this.executeLogin(request, response);
            } else
            {
                if (log.isTraceEnabled())
                {
                    log.trace("Login page view.");
                }

                return true;
            }
        } else
        {
            if (log.isTraceEnabled())
            {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the Authentication url [" + this.getLoginUrl() + "]");
            }

            this.saveRequestAndRedirectToLogin(request, response);
            return false;
        }
    }
}
