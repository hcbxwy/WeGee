package com.hcbxwy.wegee.common.util;

/**
 * 字符串工具类
 *
 * @author Billson
 * @since 2019/9/10 20:57
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     *  格式化字符串（替换符为%s）
     */
    public static String formatIfArgs(String format, Object... args) {
        if (isEmpty(format)) {
            return format;
        }
        return (args == null || args.length == 0)  ? format.replaceAll("%([^n])", "%%$1") : String.format(format, args);
    }

    /**
     *  格式化字符串(替换符自己指定)
     */
    public static String formatIfArgs(String format, String replaceOperator, Object... args) {
        if (isEmpty(format) || isEmpty(replaceOperator)) {
            return format;
        }

        format = replace(format, replaceOperator, "%s");
        return formatIfArgs(format, args);
    }
}
