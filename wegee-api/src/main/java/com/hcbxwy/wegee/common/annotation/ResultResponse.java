package com.hcbxwy.wegee.common.annotation;

import com.hcbxwy.wegee.common.entity.Result;

import java.lang.annotation.*;

/**
 * 接口返回结果增强，会通过拦截器拦截后放入标记，在 ResultResponseHandler 进行结果处理
 *
 * @author Billson
 * @since 2019/9/10 20:27
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResultResponse {

    Class<?> value() default Result.class;
}
