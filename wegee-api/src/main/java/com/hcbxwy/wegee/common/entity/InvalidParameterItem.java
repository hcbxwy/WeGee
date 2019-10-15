/*
 * <ul>
 * <li>项目名称：apz-cloud</li>
 * <li>文件名称：InvalidParameterItem.java</li>
 * <li>日期：2019/4/22 16:45</li>
 * <li>Copyright ©2016-2019 广州职赢未来信息科技有限公司 All Rights Reserved.</li>
 * </ul>
 */
package com.hcbxwy.wegee.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 参数无效项
 *
 * @author Billson
 * @since 2019/4/22 16:45
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvalidParameterItem {

    /**
     * 无效字段的名称
     */
    private String fieldName;

    /**
     * 错误信息
     */
    private String message;
}
