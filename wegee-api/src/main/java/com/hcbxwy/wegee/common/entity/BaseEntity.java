package com.hcbxwy.wegee.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Date createTime;
    private Date updateTime;
    private String creatorId;
    private String updaterId;
}
