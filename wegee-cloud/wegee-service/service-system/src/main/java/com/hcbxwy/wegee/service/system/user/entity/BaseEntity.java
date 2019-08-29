/*
 * <ul>
 * <li>项目名称：WeGee</li>
 * <li>文件名称：BaseEntity.java</li>
 * <li>日期：2019/8/28 19:24</li>
 * <li>Copyright ©2016-2019 广州职赢未来信息科技有限公司 All Rights Reserved.</li>
 * </ul>
 */
package com.hcbxwy.wegee.service.system.user.entity;

import lombok.Data;

import java.util.Date;

/**
 * TODO 用一句话描述本类的功能
 *
 * @author Billson
 * @since 2019/8/28 19:24
 */
@Data
public class BaseEntity {
    private String id;
    private Date createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;
}
