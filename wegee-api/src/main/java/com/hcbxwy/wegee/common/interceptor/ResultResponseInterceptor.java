package com.hcbxwy.wegee.common.interceptor;

import com.hcbxwy.wegee.common.annotation.ResultResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 接口返回响应体控制拦截器
 *
 * @author Billson
 * @since 2019/9/10 20:36
 */
@Component
public class ResultResponseInterceptor implements HandlerInterceptor {

    public static final String RESULT_RESPONSE = "RESULT-RESPONSE";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            if (clazz.isAnnotationPresent(ResultResponse.class)) {
                request.setAttribute(RESULT_RESPONSE, clazz.getAnnotation(ResultResponse.class));
            } else if (method.isAnnotationPresent(ResultResponse.class)) {
                request.setAttribute(RESULT_RESPONSE, method.getAnnotation(ResultResponse.class));
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // nothing to do
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // nothing to do
    }
}
