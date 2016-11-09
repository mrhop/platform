package cn.hopever.platform.oauth2client.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by Donghui Huo on 2016/10/25.
 */
@Component("commonInterceptor")
public class CommonInterceptor extends LocaleChangeInterceptor {
    Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

    public CommonInterceptor() {
        super.setParamName("lang");
        super.setIgnoreInvalidLocale(false);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String newLocale = request.getParameter(getParamName());
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if (newLocale != null && localeResolver != null) {
            String localeTag = StringUtils.parseLocaleString(newLocale).toLanguageTag();
            if (!localeResolver.resolveLocale(request).toLanguageTag().equals(localeTag)) {
                try {
                    if (super.preHandle(request, response, handler)) {
                        Cookie c = new Cookie("locale", localeTag);
                        c.setPath("/");
                        c.setMaxAge(-1);
                        response.addCookie(c);
                    }
                } catch (Exception e) {
                    logger.warn("Locale not changed");
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {

    }

    protected Locale parseLocaleValue(String locale) {
        return StringUtils.parseLocaleString(locale);
    }
}
