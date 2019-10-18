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

    @NotBlank(message = "本字段必须有值")
    private String account;
    @NotBlank(message = "本字段必须有值")
    private String password;
}
