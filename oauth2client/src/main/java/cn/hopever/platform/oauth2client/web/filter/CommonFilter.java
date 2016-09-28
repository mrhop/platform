package cn.hopever.platform.oauth2client.web.filter;

import cn.hopever.platform.oauth2client.web.common.CommonMethods;
import cn.hopever.platform.utils.web.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CommonMethods commonMethods;

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
        if (!path.startsWith("/api/") && !path.startsWith("/manual/") && !path.startsWith("/error/")) {
            Cookie c = CookieUtil.getCookieByName("accesstoken", ((HttpServletRequest) request).getCookies());
            try {
                if (commonMethods.validateUser((HttpServletRequest) request)) {
                    //此处执行一个验证用户权限的操作，调用server的的资源，并进行用户的校验
                    // --每次刷新或者进入都校验是不对的，应该在session的部分加上附加信息，validated，同时将token附进去，
                    // 保证一定时间内的不用再获取，但是仍然以cookie为准
                    //是否每个页都进行校验呢？（是），单页面的刷新，使用跳转到主页面的方式--需要在此filter处进行处理
                    if (!path.endsWith("login.html")) {
                        chain.doFilter(request, response);
                    } else {
                        ((HttpServletResponse) response).sendRedirect("index.html");
                    }
                } else {
                    //redirect to login.html
                    if (!path.endsWith("login.html")) {
                        ((HttpServletResponse) response).sendRedirect("login.html");
                    } else {
                        chain.doFilter(request, response);
                    }
                }
            } catch (Exception e) {
                logger.error("CommonFilter Error", e);
                ((HttpServletResponse) response).sendRedirect("login.html");
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
