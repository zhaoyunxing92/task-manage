package com.sunny.task.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunny
 * @className com.sunny.task.common.utils.CookiesUtils
 * @date 2017-10-18 11:24
 * @description:
 */
public class CookiesUtils {
    private CookiesUtils() {
        super();
    }

    /**
     * 设置cook
     *
     * @param res
     * @param key
     * @param value
     */
    public static void setCookie(HttpServletResponse res, String key, String value) {
        Cookie cookie = new Cookie(key, value);

        // tomcat下多应用共享
       cookie.setPath("/");
        // cookie.setMaxAge(TokenUtils.default_expiration);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        //禁止js读取
        // cookie.setHttpOnly(Boolean.TRUE);
        res.addCookie(cookie);
    }

    /**
     * 根据key获取cookie
     *
     * @param req
     * @param key
     * @return
     */
    public static Cookie getCookie(HttpServletRequest req, String key) {
        Cookie[] cookies = req.getCookies();
        if (NullUtils.isNull(cookies)) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (key.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

    /**
     * 删除本地cookie
     *
     * @param req
     * @param key
     */
    public static void delCookie(HttpServletRequest req, HttpServletResponse res, String key) {
        Cookie[] cookies = req.getCookies();
        if (NullUtils.isNull(cookies)) {
            return;
        }
        for (Cookie cookie : cookies) {
            if (key.equals(cookie.getName())) {
                cookie.setValue(null);
                cookie.setMaxAge(0);// 立即销毁cookie
                cookie.setPath("/");
                res.addCookie(cookie);
            }
        }
    }
}
