package cn.hopever.platform.utils.web.filter;

import cn.hopever.platform.utils.web.CookieUtil;
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
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String path = ((HttpServletRequest) request).getServletPath();
        if (!path.startsWith("/api/") && !path.startsWith("/manual/")&& !path.startsWith("/error/") && !path.endsWith("login.html")) {
            Cookie c = CookieUtil.getCookieByName("accesstoken", ((HttpServletRequest) request).getCookies());
            if (c != null) {
                chain.doFilter(request, response);
            }else{
                //redirect to login.html
                ((HttpServletResponse) response).sendRedirect("login.html");
            }
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
