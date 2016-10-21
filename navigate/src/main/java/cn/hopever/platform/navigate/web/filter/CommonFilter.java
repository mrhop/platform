package cn.hopever.platform.navigate.web.filter;

import cn.hopever.platform.navigate.config.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Donghui Huo on 2016/9/21.
 */
@Component
public class CommonFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(CommonFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String path = ((HttpServletRequest) request).getServletPath();
        if (CookieUtil.getCookieByName("baseurl", ((HttpServletRequest) request).getCookies()) == null) {
            Cookie baseUrl = new Cookie("baseurl", ((HttpServletRequest) request).getContextPath() + "/");
            baseUrl.setPath(((HttpServletRequest) request).getContextPath());
            ((HttpServletResponse) response).addCookie(baseUrl);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
