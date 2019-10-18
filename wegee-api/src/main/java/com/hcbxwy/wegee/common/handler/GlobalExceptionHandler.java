/*
 * <ul>
 * <li>项目名称：apz-cloud</li>
 * <li>文件名称：GlobalExceptionHandler.java</li>
 * <li>日期：2019/4/22 17:12</li>
 * <li>Copyright ©2016-2019 广州职赢未来信息科技有限公司 All Rights Reserved.</li>
 * </ul>
 */
package com.hcbxwy.wegee.common.handler;

import com.hcbxwy.wegee.common.entity.InvalidParameterItem;
import com.hcbxwy.wegee.common.entity.Result;
import com.hcbxwy.wegee.common.enums.DuplicateKeyEnum;
import com.hcbxwy.wegee.common.enums.ResultEnum;
import com.hcbxwy.wegee.common.helper.InvalidParameterItemHelper;
import com.hcbxwy.wegee.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 统一异常处理器
 *
 * @author Billson
 * @since 2019/4/22 17:12
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理违反唯一约束异常
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e, HttpServletRequest request) {
        log.info("处理违反唯一约束异常, uri:{}, caused by: ", request.getRequestURI(), e);
        String message = e.getMessage();
        for (DuplicateKeyEnum duplicateKeyEnum : DuplicateKeyEnum.values()) {
            if (StringUtils.contains(message, duplicateKeyEnum.getKey())) {
                return Result.failure(duplicateKeyEnum.getValue());
            }
        }
        return Result.failure(ResultEnum.ALREADY_EXISTS);
    }

    /**
     * 处理验证参数封装错误时异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleConstraintViolationException(HttpMessageNotReadableException e,
                                                     HttpServletRequest request) {
        log.info("handleConstraintViolationException start, uri:{}, caused by: ", request.getRequestURI(), e);
        return Result.failure(ResultEnum.INVALID_PARAMETER);
    }

    /**
     * 处理参数绑定时异常（返回400错误码）
     */
    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException e, HttpServletRequest request) {
        log.info("handleBindException start, uri:{}, caused by: ", request.getRequestURI(), e);
        List<InvalidParameterItem> itemList =
                InvalidParameterItemHelper.convertBindingResultToMapInvalidParameterItemList(e.getBindingResult());
        return Result.failure(ResultEnum.INVALID_PARAMETER, itemList);
    }

    /**
     * 处理使用@Valid 注解时，参数验证错误异常（返回400错误码）
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
                                                        HttpServletRequest request) {
        log.info("处理参数校验异常, uri:{}, caused by: ", request.getRequestURI(), e);
        List<InvalidParameterItem> itemList =
                InvalidParameterItemHelper.convertBindingResultToMapInvalidParameterItemList(e.getBindingResult());
        return Result.failure(ResultEnum.INVALID_PARAMETER, itemList);
    }

    /**
     * 处理未预测到的其他错误（返回500错误码）
     */
    @ExceptionHandler(Throwable.class)
    public Result handleThrowable(Throwable e, HttpServletRequest request) {
        log.error("handleThrowable start, uri:{}, caused by: ", request.getRequestURI(), e);
        return Result.failure(ResultEnum.INTERNAL);
    }
}
