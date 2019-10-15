package com.hcbxwy.wegee.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * 获取应用上下文工具类
 *
 * @author Billson
 * @since 2019/9/10 20:34
 */
public class ApplicationContextUtil {

    private static ApplicationContext applicationContext;

    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static ServletRequestAttributes getRequestAttributes() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
    }

    public static ServletContext getServletContext() {
        return Objects.requireNonNull(ContextLoader.getCurrentWebApplicationContext()).getServletContext();
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }
}
