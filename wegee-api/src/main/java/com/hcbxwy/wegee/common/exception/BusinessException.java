package com.hcbxwy.wegee.common.exception;

import com.hcbxwy.wegee.common.enums.BusinessExceptionEnum;
import com.hcbxwy.wegee.common.enums.ResultEnum;
import com.hcbxwy.wegee.common.util.StringUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常类
 *
 * @author Billson
 * @since 2019/4/22 15:23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {

    protected String code;

    protected String message;

    protected ResultEnum resultEnum;

    protected Object data;

    public BusinessException() {
        BusinessExceptionEnum exceptionEnum = BusinessExceptionEnum.getByEClass(this.getClass());
        if (exceptionEnum != null) {
            resultEnum = exceptionEnum.getResultEnum();
            code = exceptionEnum.getResultEnum().getCode().toString();
            message = exceptionEnum.getResultEnum().getMessage();
        }

    }

    public BusinessException(String message) {
        this();
        this.message = message;
    }

    public BusinessException(String format, Object... objects) {
        this();
        this.message = StringUtils.formatIfArgs(format, "{}", objects);
    }

    public BusinessException(ResultEnum resultEnum, Object data) {
        this(resultEnum);
        this.data = data;
    }

    public BusinessException(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
        this.code = resultEnum.getCode().toString();
        this.message = resultEnum.getMessage();
    }
}
