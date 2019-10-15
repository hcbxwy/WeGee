package com.hcbxwy.wegee.common.handler;

import com.alibaba.fastjson.JSONObject;
import com.hcbxwy.wegee.common.annotation.ResultResponse;
import com.hcbxwy.wegee.common.entity.Result;
import com.hcbxwy.wegee.common.entity.ResultError;
import com.hcbxwy.wegee.common.interceptor.ResultResponseInterceptor;
import com.hcbxwy.wegee.common.util.ApplicationContextUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 接口返回响应体处理器
 *
 * @author Billson
 * @since 2019/9/10 20:29
 */
@ControllerAdvice
public class ResultResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        HttpServletRequest request = ApplicationContextUtil.getRequest();
        ResultResponse resultResponse =
                (ResultResponse) request.getAttribute(ResultResponseInterceptor.RESULT_RESPONSE);
        return resultResponse != null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        ResultResponse resultResponse = (ResultResponse) ApplicationContextUtil.getRequest()
                .getAttribute(ResultResponseInterceptor.RESULT_RESPONSE);
        Class<?> resultClazz = resultResponse.value();
        if (resultClazz.isAssignableFrom(Result.class)) {
            if (body instanceof ResultError) {
                ResultError resultError = (ResultError) body;
                return ResultError.builder()
                        .code(resultError.getCode())
                        .message(resultError.getMessage())
                        .errors(resultError.getErrors())
                        .build();
            } else if (body instanceof String) {
                return JSONObject.toJSONString(Result.success(body));
            }

            return Result.success(body);
        }

        return body;
    }
}
