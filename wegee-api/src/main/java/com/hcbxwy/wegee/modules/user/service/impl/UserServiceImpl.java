package com.hcbxwy.wegee.modules.user.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.hcbxwy.wegee.common.constant.AccountType;
import com.hcbxwy.wegee.common.exception.BusinessException;
import com.hcbxwy.wegee.modules.user.dao.UserAccountDao;
import com.hcbxwy.wegee.modules.user.entity.User;
import com.hcbxwy.wegee.modules.user.dao.UserDao;
import com.hcbxwy.wegee.modules.user.entity.UserAccount;
import com.hcbxwy.wegee.modules.user.service.UserAccountService;
import com.hcbxwy.wegee.modules.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcbxwy.wegee.modules.user.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Billson
 * @since 2019-10-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    private final UserAccountService userAccountService;

    @Autowired
    public UserServiceImpl(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    /**
     * 用户注册
     *
     * @param registerVO 用户注册信息
     * @author Billson
     * @since 2019/10/14 20:53
     */
    @Override
    public void saveUser(RegisterVO registerVO) {
        // 生成用户记录
        User user = new User();
        user.setNickname(registerVO.getAccount());
        this.save(user);

        // 生成用户账号
        UserAccount userAccount = new UserAccount();
        String salt = RandomUtil.randomString(8);
        userAccount.setUserId(user.getId())
                .setAccountType(AccountType.DEFAULT)
                .setAccount(registerVO.getAccount())
                .setSalt(salt)
                .setPassword(SecureUtil.md5(salt + registerVO.getPassword()));
        userAccountService.save(userAccount);
    }
}
