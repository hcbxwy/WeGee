package com.hcbxwy.wegee.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * 公共实体
 *
 * @author Billson
 * @since 2019/8/28 19:24
 */
@Data
public class BaseEntity {
    private Long id;
    private Date createTime;
    private Date updateTime;
    private String createBy;
    private String updateBy;
}
