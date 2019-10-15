package com.hcbxwy.wegee.common.entity;

import com.hcbxwy.wegee.common.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接口返回实体类
 *
 * @author Billson
 * @since 2019/9/10 20:06
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {

    private Integer code;

    private String message;

    private Object data;

    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultEnum.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result failure(ResultEnum resultEnum) {
        Result result = new Result();
        result.setResultCode(resultEnum);
        return result;
    }

    public static Result failure(ResultEnum resultEnum, Object data) {
        Result result = new Result();
        result.setResultCode(resultEnum);
        result.setData(data);
        return result;
    }

    private void setResultCode(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }
}
