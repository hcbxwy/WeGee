package com.hcbxwy.wegee.modules.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hcbxwy.wegee.common.entity.BaseEntity;
import com.hcbxwy.wegee.modules.user.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Billson
 * @since 2019-10-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("wg_user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 性别：0 女，1 男，2 不详
     */
    private Gender gender;


    public static final String NICKNAME = "nickname";

    public static final String AVATAR_URL = "avatar_url";

    public static final String GENDER = "gender";

}
