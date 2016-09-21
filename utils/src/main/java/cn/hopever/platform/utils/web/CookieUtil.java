package cn.hopever.platform.utils.web;

import javax.servlet.http.Cookie;

/**
 * Created by Donghui Huo on 2016/9/20.
 */
public class CookieUtil {
    public static Cookie getCookieByName(String name,Cookie[] cookies){
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(name.equals(cookie.getName())){
                    return cookie;
                }
            }
        }
        return null;
    }
}
