package com.hcbxwy.wegee.common.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP工具类
 *
 * @author Billson
 * @since 2019/4/22 18:02
 */
@Slf4j
public class IpUtil {

    private static final String IP_PATTERN = "^(?:(?:[01]?\\d{1,2}|2[0-4]\\d|25[0-5])\\.){3}(?:[01]?\\d{1,2}|2[0-4]\\d|25[0-5])\\b";

    private static final String UNKNOWN = "unknown";

    private static final String LOOPBACK_ADDRESS = "127.0.0.1";

    private static final String UNKNOWN_ADDRESS = "0:0:0:0:0:0:0:1";

    /**
     * 获取客户端请求中的真实的ip地址
     * <p>
     * 获取客户端的IP地址的方法是：request.getRemoteAddr()，这种方法在大部分情况下都是有效的。
     * 但是在通过了Apache，Squid等反向代理软件就不能获取到客户端的真实IP地址。而且，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，
     * 而是一串ip值，例如：192.168.1.110， 192.168.1.120， 192.168.1.130， 192.168.1.100。其中第一个192.168.1.110才是用户真实的ip
     *
     * @param request 请求对象
     * @return java.lang.String
     * @author Billson
     * @since 2019/4/22 18:05
     */
    public static String getRealIp(HttpServletRequest request) {
        String ip = LOOPBACK_ADDRESS;
        if (request == null) {
            return ip;
        }

        ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (LOOPBACK_ADDRESS.equals(ip) || UNKNOWN_ADDRESS.equals(ip)) {
                //根据网卡取本机配置的IP
                try {
                    InetAddress inet = InetAddress.getLocalHost();
                    ip = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    log.error("getRealIp occurs error, caused by: ", e);
                }
            }
        }

        //"***.***.***.***".length() = 15
        int ipLength = 15;
        String separator = ",";
        if (ip != null && ip.length() > ipLength) {
            if (ip.indexOf(separator) > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }
}
