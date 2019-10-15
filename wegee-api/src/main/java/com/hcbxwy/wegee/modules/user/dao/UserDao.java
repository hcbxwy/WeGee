package com.hcbxwy.wegee.modules.user.dao;

import com.hcbxwy.wegee.modules.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Billson
 * @since 2019-10-14
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}
