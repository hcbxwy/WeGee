package com.hcbxwy.wegee.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 接口返回码枚举类
 *
 * @author Billson
 * @since 2019/9/10 20:05
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {

    /**
     * 随便加个注释，防止IDE 黄色警告
     */
    SUCCESS(200, "成功"),
    INVALID_PARAMETER(400, "无效参数"),
    FAILED_PRECONDITION(400, "请求无法在当前系统状态下执行，例如删除非空目录"),
    OUT_OF_RANGE(400, "无效范围"),
    UNAUTHENTICATED(401, "由于 OAuth 令牌丢失、无效或过期，请求未通过身份验证"),
    PERMISSION_DENIED(403, "客户端权限不足。可能的原因包括 OAuth 令牌的覆盖范围不正确、客户端没有权限或者尚未为客户端项目启用 API"),
    NOT_FOUND(404, "找不到指定的资源，或者请求由于未公开的原因（例如白名单）而被拒绝"),
    ABORTED(409, "并发冲突，例如读取/修改/写入冲突"),

    // 资源已存在
    ALREADY_EXISTS(409, "客户端尝试创建的资源已存在"),
    ALREADY_EXISTS_ACCOUNT(409001, "该账号已被注册"),

    RESOURCE_EXHAUSTED(429, "资源配额不足或达到速率限制"),
    CANCELLED(499, "请求被客户端取消"),
    DATA_LOSS(500, "出现不可恢复的数据丢失或数据损坏"),
    UNKNOWN(500, "出现未知的服务器错误。通常是服务器错误"),
    INTERNAL(500, "出现内部服务器错误。通常是服务器错误"),
    NOT_IMPLEMENTED(501, "API 方法未通过服务器实现"),
    UNAVAILABLE(503, "服务不可用。通常是服务器已关闭"),
    DEADLINE_EXCEEDED(500, "超出请求时限。仅当调用者设置的时限比方法的默认时限短（即请求的时限不足以让服务器处理请求）并且请求未在时限范围内完成时，才会发生这种情况");

    private Integer code;
    private String message;
}
