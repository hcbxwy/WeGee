package com.hcbxwy.wegee.modules.user.service.impl;

import com.hcbxwy.wegee.modules.user.entity.UserAccount;
import com.hcbxwy.wegee.modules.user.dao.UserAccountDao;
import com.hcbxwy.wegee.modules.user.service.UserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账号表 服务实现类
 * </p>
 *
 * @author Billson
 * @since 2019-10-14
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountDao, UserAccount> implements UserAccountService {

}
