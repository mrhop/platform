package cn.hopever.platform.oauth2client.web.interceptor;

import cn.hopever.platform.oauth2client.web.common.CommonMethods;
import cn.hopever.platform.utils.web.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Donghui Huo on 2016/10/25.
 */
//@Component("commonInterceptor")
public class CommonInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

    @Autowired
    private CommonMethods commonMethods;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path =  request.getServletPath();
        if (CookieUtil.getCookieByName("baseurl",  request.getCookies()) == null) {
            Cookie baseUrl = new Cookie("baseurl", request.getContextPath() + "/");
            baseUrl.setPath(request.getContextPath());
             response.addCookie(baseUrl);
        }
        if (!path.startsWith("/api/") && !path.startsWith("/manual/") && !path.startsWith("/error/")) {
            Cookie c = CookieUtil.getCookieByName("accesstoken", ((HttpServletRequest) request).getCookies());
            try {
                if (commonMethods.validateUser((HttpServletRequest) request)) {
                    //此处执行一个验证用户权限的操作，调用server的的资源，并进行用户的校验
                    // --每次刷新或者进入都校验是不对的，应该在session的部分加上附加信息，validated，同时将token附进去，
                    // 保证一定时间内的不用再获取，但是仍然以cookie为准
                    //是否每个页都进行校验呢？（是），单页面的刷新，使用跳转到主页面的方式--需要在此filter处进行处理
                    if (path.endsWith("login.html")) {
                        ((HttpServletResponse) response).sendRedirect("index.html");
                    } else if(path.endsWith("index.html")){
                        return true;
                    }else{
                        request.getRequestDispatcher("index.html").forward(request,response);
                    }
                } else {
                    //redirect to login.html
                    if (!path.endsWith("login.html")) {
                        ((HttpServletResponse) response).sendRedirect("login.html");
                    } else {
                        return true;
                    }
                }
            } catch (Exception e) {
                logger.error("CommonFilter Error", e);
                ((HttpServletResponse) response).sendRedirect("login.html");
            }
        } else {
            return true;
        }
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
