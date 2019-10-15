package com.hcbxwy.wegee.common.entity;

import com.hcbxwy.wegee.common.enums.BusinessExceptionEnum;
import com.hcbxwy.wegee.common.enums.ResultEnum;
import com.hcbxwy.wegee.common.exception.BusinessException;
import com.hcbxwy.wegee.common.util.ApplicationContextUtil;
import com.hcbxwy.wegee.common.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * 默认全局错误返回结果
 * <p>
 * PS：该返回信息是spring boot的默认异常时返回结果{@link DefaultErrorAttributes}
 *
 * @author Billson
 * @since 2019/9/10 20:45
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultError {

    /**
     * HTTP 响应状态码 {@link HttpStatus}
     */
    private Integer status;

    /**
     * HTTP 响应状态码的英文提示
     */
    private String error;

    /**
     * 异常堆栈的精简信息
     */
    private String message;

    /**
     * 我们系统内部自定义的返回值编码，{@link ResultEnum} 它是对错误更加详细的编码
     * <p>
     * PS：spring boot 默认返回异常时，该字段为null
     */
    private Integer code;

    /**
     * 调用接口路径
     */
    private String path;

    /**
     * 异常的名字
     */
    private String exception;

    /**
     * 异常的错误传递的数据
     */
    private Object errors;

    /**
     * 时间戳
     */
    private Date timestamp;

    public static ResultError failure(ResultEnum resultEnum, Throwable e, HttpStatus httpStatus, Object errors) {
        ResultError result = ResultError.failure(resultEnum, e, httpStatus);
        result.setErrors(errors);
        return result;
    }

    public static ResultError failure(ResultEnum resultEnum, Throwable e, HttpStatus httpStatus) {
        ResultError result = new ResultError();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        result.setStatus(httpStatus.value());
        result.setError(httpStatus.getReasonPhrase());
        result.setException(e.getClass().getName());
        String path = ApplicationContextUtil.getRequest().getRequestURI();
        result.setPath(path);
        result.setTimestamp(new Date());
        return result;
    }

    public static ResultError failure(BusinessException e) {
        BusinessExceptionEnum ee = BusinessExceptionEnum.getByEClass(e.getClass());
        if (ee != null) {
            return ResultError.failure(ee.getResultEnum(), e, ee.getHttpStatus(), e.getData());
        }

        ResultError resultError = ResultError.failure(e.getResultEnum() == null ? ResultEnum.SUCCESS :
                e.getResultEnum(), e, HttpStatus.OK, e.getData());
        if (StringUtils.isNotEmpty(e.getMessage())) {
            resultError.setMessage(e.getMessage());
        }
        return resultError;
    }
}
