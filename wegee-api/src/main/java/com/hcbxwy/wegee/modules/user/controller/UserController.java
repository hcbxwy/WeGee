package com.hcbxwy.wegee.modules.user.controller;


import com.hcbxwy.wegee.common.annotation.ResultResponse;
import com.hcbxwy.wegee.modules.user.service.UserAccountService;
import com.hcbxwy.wegee.modules.user.service.UserService;
import com.hcbxwy.wegee.modules.user.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Billson
 * @since 2019-10-14
 */
@RestController
@ResultResponse
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户注册
     *
     * @param registerVO	用户注册信息VO
     * @return java.lang.String
     * @author Billson
     * @since 2019/10/14 20:50
     */
    @PostMapping("/register")
    public String register(@RequestBody @Valid RegisterVO registerVO){
        userService.register(registerVO);
        return "注册成功";
    }
}
