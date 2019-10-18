package com.hcbxwy.wegee.modules.user.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 账号状态枚举类
 *
 * @author Billson
 * @since 2019/10/18 18:08
 */
@AllArgsConstructor
@Getter
public enum AccountStatus implements IEnum<Integer> {
    /**
     * 正常
     */
    NORMAL(0, "正常"),
    UNVERIFIED(1, "未验证"),
    EXPIRED(2, "已过期"),
    FROZEN(3, "已冻结"),
    DELETED(4, "已作废");

    private int value;
    private String desc;

    @Override
    public Integer getValue() {
        return null;
    }
}
