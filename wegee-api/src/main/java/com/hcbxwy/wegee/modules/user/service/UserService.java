package com.hcbxwy.wegee.modules.user.service;

import com.hcbxwy.wegee.modules.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hcbxwy.wegee.modules.user.vo.RegisterVO;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Billson
 * @since 2019-10-14
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param registerVO	用户注册信息
     * @author Billson
     * @since 2019/10/14 20:53
     */
    void saveUser(RegisterVO registerVO);
}
