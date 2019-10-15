package com.hcbxwy.wegee.common.exception;

import com.hcbxwy.wegee.common.enums.ResultEnum;

/**
 * 无效参数异常类
 *
 * @author Billson
 * @since 2019/9/11 14:40
 */
public class InvalidParameterException extends BusinessException {

    private static final long serialVersionUID = -907171717806319916L;

    public InvalidParameterException() {
        super();
    }

    public InvalidParameterException(Object data) {
        super.data = data;
    }

    public InvalidParameterException(ResultEnum resultEnum) {
        super(resultEnum);
    }

    public InvalidParameterException(ResultEnum resultEnum, Object data) {
        super(resultEnum, data);
    }

    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
