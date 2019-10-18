package com.hcbxwy.wegee.modules.user.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性别枚举类
 *
 * @author Billson
 * @since 2019/10/18 18:06
 */
@AllArgsConstructor
@Getter
public enum Gender implements IEnum<Integer> {
    /**
     * 女
     */
    FEMAIL(0, "女"),
    MAIL(1, "男"),
    UNKNOWN(2, "不详");

    private int value;
    private String desc;

    @Override
    public Integer getValue(){
        return this.value;
    }
}
