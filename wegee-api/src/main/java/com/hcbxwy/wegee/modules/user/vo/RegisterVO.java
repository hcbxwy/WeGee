package com.hcbxwy.wegee.modules.user.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户注册VO
 *
 * @author Billson
 * @since 2019/10/14 20:46
 */
@Data
public class RegisterVO {

    @NotBlank(message = "请输入账号/手机号/邮箱")
    private String account;
    @NotBlank(message = "请输入密码")
    private String password;
}
