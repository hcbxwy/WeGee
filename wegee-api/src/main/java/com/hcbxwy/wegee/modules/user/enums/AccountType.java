package com.hcbxwy.wegee.modules.user.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 账号类型枚举类
 *
 * @author Billson
 * @since 2019/10/18 17:01
 */
@AllArgsConstructor
@Getter
public enum AccountType implements IEnum<Integer> {
    /**
     * 站内账号（如：手机号、邮箱、用户名等）
     */
    DEFAULT(0, "站内账号"),
    WECHAT(1, "微信"),
    WEIBO(2, "微博"),
    QQ(3, "QQ");

    private int value;
    private String desc;

    @Override
    public Integer getValue(){
        return this.value;
    }
}
