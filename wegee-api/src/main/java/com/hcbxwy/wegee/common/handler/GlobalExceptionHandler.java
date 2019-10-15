/*
 * <ul>
 * <li>项目名称：apz-cloud</li>
 * <li>文件名称：GlobalExceptionHandler.java</li>
 * <li>日期：2019/4/22 17:12</li>
 * <li>Copyright ©2016-2019 广州职赢未来信息科技有限公司 All Rights Reserved.</li>
 * </ul>
 */
package com.hcbxwy.wegee.common.handler;

import com.hcbxwy.wegee.common.entity.ResultError;
import com.hcbxwy.wegee.common.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * 统一异常处理器
 *
 * @author Billson
 * @since 2019/4/22 17:12
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends BaseGlobalExceptionHandler {

    /**
     * 处理400类异常
     */
    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultError handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
        return super.handleConstraintViolationException(e, request);
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultError handleConstraintViolationException(HttpMessageNotReadableException e,
                                                          HttpServletRequest request) {
        return super.handleConstraintViolationException(e, request);
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ResultError handleBindException(BindException e, HttpServletRequest request) {
        return super.handleBindException(e, request);
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultError handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
                                                             HttpServletRequest request) {
        return super.handleMethodArgumentNotValidException(e, request);
    }

    /**
     * 处理自定义异常
     */
    @Override
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ResultError> handleBusinessException(BusinessException e, HttpServletRequest request) {
        return super.handleBusinessException(e, request);
    }

    /**
     * 处理运行时异常
     */
    @Override
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ResultError handleThrowable(Throwable e, HttpServletRequest request) {
        //TODO 可通过邮件、微信公众号等方式发送信息至开发人员、记录存档等操作
        return super.handleThrowable(e, request);
    }
}
