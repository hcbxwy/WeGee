/*
 * Copyright ©2019 http://www.hcbxwy.com/ All rights reserved.
 */
package com.hcbxwy.wegee.service.system.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户模块
 *
 * @author Billson
 * @since 2019-08-18 12:19
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/test")
    public String test(){
        return "hello";
    }
}
