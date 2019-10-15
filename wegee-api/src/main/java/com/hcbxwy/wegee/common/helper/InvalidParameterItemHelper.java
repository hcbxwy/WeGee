/*
 * <ul>
 * <li>项目名称：apz-cloud</li>
 * <li>文件名称：InvalidParameterItemHelper.java</li>
 * <li>日期：2019/4/22 16:51</li>
 * <li>Copyright ©2016-2019 广州职赢未来信息科技有限公司 All Rights Reserved.</li>
 * </ul>
 */
package com.hcbxwy.wegee.common.helper;

import com.hcbxwy.wegee.common.entity.InvalidParameterItem;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 参数无效项辅助类
 *
 * @author Billson
 * @since 2019/4/22 16:51
 */
public class InvalidParameterItemHelper {

    public static List<InvalidParameterItem> convertCVSetToInvalidParameterItemList(Set<ConstraintViolation<?>> cvset) {
        if (CollectionUtils.isEmpty(cvset)) {
            return null;
        }

        List<InvalidParameterItem> itemList = new ArrayList<>();
        for (ConstraintViolation<?> cv : cvset) {
            InvalidParameterItem item = new InvalidParameterItem();
            String propertyPath = cv.getPropertyPath().toString();
            if (propertyPath.contains(".")) {
                String[] propertyPathArr = propertyPath.split("\\.");
                item.setFieldName(propertyPathArr[propertyPathArr.length - 1]);
            } else {
                item.setFieldName(propertyPath);
            }
            item.setMessage(cv.getMessage());
            itemList.add(item);
        }

        return itemList;
    }

    public static List<InvalidParameterItem> convertBindingResultToMapInvalidParameterItemList(BindingResult bindingResult) {
        if (bindingResult == null) {
            return null;
        }

        List<InvalidParameterItem> itemList = new ArrayList<>();

        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrorList) {
            InvalidParameterItem item = new InvalidParameterItem();
            item.setFieldName(fieldError.getField());
            item.setMessage(fieldError.getDefaultMessage());
            itemList.add(item);
        }

        return itemList;
    }
}
