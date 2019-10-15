/*
 * <ul>
 * <li>项目名称：apz-cloud</li>
 * <li>文件名称：BusinessExceptionEnum.java</li>
 * <li>日期：2019/4/22 15:38</li>
 * <li>Copyright ©2016-2019 广州职赢未来信息科技有限公司 All Rights Reserved.</li>
 * </ul>
 */
package com.hcbxwy.wegee.common.enums;

import com.hcbxwy.wegee.common.exception.BusinessException;
import com.hcbxwy.wegee.common.exception.InvalidParameterException;
import org.springframework.http.HttpStatus;

/**
 * 业务异常、HTTP状态码、默认自定义返回码 映射类
 *
 * @author Billson
 * @since 2019/4/22 15:38
 */
public enum BusinessExceptionEnum {

    /**
     * 参数无效
     */
    INVALID_ARGUMENT(InvalidParameterException.class, HttpStatus.BAD_REQUEST, ResultEnum.INVALID_PARAMETER);

//    /**
//     * 数据未找到
//     */
//    NOT_FOUND(DataNotFoundException.class, HttpStatus.NOT_FOUND, ResultCodeEnum.RESULE_DATA_NONE),
//
//    /**
//     * 接口方法不允许
//     */
//    METHOD_NOT_ALLOWED(MethodNotAllowException.class, HttpStatus.METHOD_NOT_ALLOWED, ResultCodeEnum
// .INTERFACE_ADDRESS_INVALID),
//
//    /**
//     * 数据已存在
//     */
//    CONFLICT(DataConflictException.class, HttpStatus.CONFLICT, ResultCodeEnum.DATA_ALREADY_EXISTED),
//
//    /**
//     * 用户未登录
//     */
//    UNAUTHORIZED(UserNotLoginException.class, HttpStatus.UNAUTHORIZED, ResultCodeEnum.USER_NOT_LOGGED_IN),
//
//    /**
//     * 无访问权限
//     */
//    FORBIDDEN(PermissionForbiddenException.class, HttpStatus.FORBIDDEN, ResultCodeEnum.PERMISSION_NO_ACCESS),
//
//    /**
//     * 远程访问时错误
//     */
//    REMOTE_ACCESS_ERROR(RemoteAccessException.class, HttpStatus.INTERNAL_SERVER_ERROR, ResultCodeEnum
// .INTERFACE_OUTTER_INVOKE_ERROR),
//
//    /**
//     * 系统内部错误
//     */
//    INTERNAL_SERVER_ERROR(InternalServerException.class, HttpStatus.INTERNAL_SERVER_ERROR, ResultCodeEnum
// .SYSTEM_INNER_ERROR);

    private Class<? extends BusinessException> eClass;

    private HttpStatus httpStatus;

    private ResultEnum resultEnum;

    BusinessExceptionEnum(Class<? extends BusinessException> eClass, HttpStatus httpStatus, ResultEnum resultEnum) {
        this.eClass = eClass;
        this.httpStatus = httpStatus;
        this.resultEnum = resultEnum;
    }

    public Class<? extends BusinessException> getEClass() {
        return eClass;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    public static boolean isSupportHttpStatus(int httpStatus) {
        for (BusinessExceptionEnum exceptionEnum : BusinessExceptionEnum.values()) {
            if (exceptionEnum.httpStatus.value() == httpStatus) {
                return true;
            }
        }

        return false;
    }

    public static boolean isSupportException(Class<?> z) {
        for (BusinessExceptionEnum exceptionEnum : BusinessExceptionEnum.values()) {
            if (exceptionEnum.eClass.equals(z)) {
                return true;
            }
        }

        return false;
    }

    public static BusinessExceptionEnum getByHttpStatus(HttpStatus httpStatus) {
        if (httpStatus == null) {
            return null;
        }

        for (BusinessExceptionEnum exceptionEnum : BusinessExceptionEnum.values()) {
            if (httpStatus.equals(exceptionEnum.httpStatus)) {
                return exceptionEnum;
            }
        }

        return null;
    }

    public static BusinessExceptionEnum getByEClass(Class<? extends BusinessException> eClass) {
        if (eClass == null) {
            return null;
        }

        for (BusinessExceptionEnum exceptionEnum : BusinessExceptionEnum.values()) {
            if (eClass.equals(exceptionEnum.eClass)) {
                return exceptionEnum;
            }
        }

        return null;
    }
}
