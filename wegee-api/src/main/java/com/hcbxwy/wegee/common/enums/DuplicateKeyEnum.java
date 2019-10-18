package com.hcbxwy.wegee.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 唯一性约束枚举类
 *
 * @author Billson
 * @since 2019/10/18 16:52
 */
@Getter
@AllArgsConstructor
public enum  DuplicateKeyEnum {
    /**
     * 账号唯一性约束
     */
    ALREADY_EXISTS_ACCOUNT("uk_account", ResultEnum.ALREADY_EXISTS_ACCOUNT);

    private String key;
    private ResultEnum value;
}
