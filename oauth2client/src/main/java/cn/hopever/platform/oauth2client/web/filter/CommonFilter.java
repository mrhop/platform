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


@Component("commonFilter")
public class CommonFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(CommonFilter.class);

    @Autowired
    private CommonMethods commonMethods;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request.getParameter("lang")!=null){
            Cookie locale = new Cookie("locale", request.getParameter("lang"));
            locale.setPath("/");
            locale.setMaxAge(-1);
            ((HttpServletResponse) response).addCookie(locale);
        }
        String path = ((HttpServletRequest) request).getServletPath();
        if (!path.startsWith("/api/") && !path.startsWith("/manual/") && !path.startsWith("/error/")) {
            Cookie c = CookieUtil.getCookieByName("accesstoken", ((HttpServletRequest) request).getCookies());
            try {
                if (commonMethods.validateUser((HttpServletRequest) request)) {
                    if (!path.endsWith("login.html")) {
                        chain.doFilter(request, response);
                    } else {
                        ((HttpServletResponse) response).sendRedirect("index.html");
                    }
                } else {
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
