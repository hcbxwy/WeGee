/*
 * <ul>
 * <li>项目名称：WeGee</li>
 * <li>文件名称：Account.java</li>
 * <li>日期：2019/8/28 19:22</li>
 * <li>Copyright ©2016-2019 广州职赢未来信息科技有限公司 All Rights Reserved.</li>
 * </ul>
 */
package com.hcbxwy.wegee.service.system.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 账号
 *
 * @author Billson
 * @since 2019/8/28 19:22
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_account")
public class Account extends BaseEntity {
    private String userId;
    private String account;
    private String pwd;
    private String salt;
    private String accountType;
}
