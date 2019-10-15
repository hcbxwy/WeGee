package com.hcbxwy.wegee.modules.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hcbxwy.wegee.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户账号表
 * </p>
 *
 * @author Billson
 * @since 2019-10-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("wg_user_account")
public class UserAccount extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 账号类型：0  默认，1  微信，2  微博，3  QQ
     */
    private Integer accountType;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码盐
     */
    private String salt;

    /**
     * 密码
     */
    private String password;

    /**
     * 有效期（秒）
     */
    private Integer expired;

    /**
     * 状态：0 正常，1 未认证，2 已过期，3 已冻结，4 已作废
     */
    private Integer status;

    /**
     * 联合ID（主要是微信和QQ）
     */
    private String unionId;


    public static final String USER_ID = "user_id";

    public static final String ACCOUNT_TYPE = "account_type";

    public static final String ACCOUNT = "account";

    public static final String SALT = "salt";

    public static final String PASSWORD = "password";

    public static final String EXPIRED = "expired";

    public static final String STATUS = "status";

    public static final String UNION_ID = "union_id";

}
