/*
 * <ul>
 * <li>项目名称：WeGee</li>
 * <li>文件名称：AccountController.java</li>
 * <li>日期：2019/8/28 19:27</li>
 * <li>Copyright ©2016-2019 广州职赢未来信息科技有限公司 All Rights Reserved.</li>
 * </ul>
 */
package com.hcbxwy.wegee.service.system.user;

import com.alibaba.fastjson.JSONObject;
import com.hcbxwy.wegee.service.system.user.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO 用一句话描述本类的功能
 *
 * @author Billson
 * @since 2019/8/28 19:27
 */
@RestController
@RequestMapping("/users")
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    @GetMapping("/{userId}/accounts")
    public String getAccount(@PathVariable String userId){
        return JSONObject.toJSONString(accountMapper.selectById(1));
    }
}
