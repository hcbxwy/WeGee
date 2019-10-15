package com.hcbxwy.wegee.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import static org.springframework.web.util.WebUtils.getCookie;

/**
 * Cookie工具类
 *
 * @author Billson
 * @since 2019/4/22 19:42
 */
public class CookieUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CookieUtil.class);

    /**
     * 添加cookie信息，指定生效时间
     *
     * @param response	Http response
     * @param name	Cookie名称
     * @param value	 Cookie值
     * @param maxAge	Cookie有效期，单位秒
     * @param isURLEncode	是否进行URL编码
     * @param isHttpOnly    Cookie设置了"HttpOnly"属性，那么通过程序(JS脚本、Applet等)将无法读取到Cookie信息，这样能有效的防止XSS攻击
     * @param isSecure	当设置为true时，表示创建的 Cookie 会被以安全的形式向服务器传输，也就是只能在 HTTPS 连接中被浏览器传递到服务器端进行会话验证，如果是 HTTP 连接则不会传递该信息，所以不会被窃取到Cookie 的具体内容。
     * @author Billson
     * @since 2019/4/22 19:48
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge, boolean isURLEncode, boolean isHttpOnly, boolean isSecure) {
        try {
            Cookie cookie = new Cookie(name, isURLEncode ? URLEncoder.encode(value, "UTF-8") : value);
            if (maxAge > 0) {
                cookie.setMaxAge(maxAge);
            }

            cookie.setPath("/");
            cookie.setHttpOnly(isHttpOnly);
            cookie.setSecure(isSecure);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("addCookie occurs exception, caused by: ", e);
        }
    }

    /**
     * 添加cookie信息，指定生效时间，默认开启Http Only
     *
     * @param response	Http response
     * @param name	Cookie名称
     * @param value	 Cookie值
     * @param maxAge	Cookie有效期，单位秒
     * @param isURLEncode	是否进行URL编码
     * @author Billson
     * @since 2019/4/22 19:53
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge, boolean isURLEncode) {
        if (StringUtils.isEmpty(value)) {
            return;
        }
        addCookie(response, name, value, maxAge, isURLEncode, true, false);
    }

    /**
     * 获取cookie值
     *
     * @param request	HttpServletRequest
     * @param name Cookie名称
     * @param isURLEncode 	是否进行URL编码
     * @return java.lang.String
     * @author Billson
     * @since 2019/4/22 19:55
     */
    public static String getCookieValue(HttpServletRequest request, String name, boolean isURLEncode) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }

        try {
            Cookie cookie = getCookie(request, name);
            if (cookie != null) {
                return isURLEncode ? URLDecoder.decode(cookie.getValue(), "UTF-8") : cookie.getValue();
            }
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("getCookieValue occurs exception, caused by: ", e);
        }
        return null;
    }

    /**
     * 删除cookie
     *
     * @param request	HttpServletRequest
     * @param response	HttpServletResponse
     * @param name	cookie名称
     * @author Billson
     * @since 2019/4/22 19:57
     */
    public static void delCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        if (StringUtils.isEmpty(name)) {
            return;
        }

        Cookie cookie = getCookie(request, name);
        if (null != cookie) {
            cookie.setPath("/");
            cookie.setValue("");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }
}
