package com.sunny.task.core.common.utils;

import java.util.regex.Pattern;

/**
 * Created by sunny on 2017/6/6.
 */
public class StringUtils {
    private static final Pattern PATTERN_EMAIL_VALID = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
    private static final Pattern PATTERN_MOBILE_VALID = Pattern.compile("^1[34578]\\d{9}$");

    private StringUtils() {
        super();
    }

    /**
     * 不去除空格
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return isEmpty(str, false);
    }

    /**
     * 判断是否为空
     *
     * @param str
     * @param trim
     * @return
     */
    public static boolean isEmpty(String str, Boolean trim) {
        return str == null || "".equals(str) || (trim ? str.trim().isEmpty() : str.isEmpty());
    }

    /**
     * 去除空格
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        return isEmpty(str, true);
    }

    /**
     * 判断是否是邮箱
     *
     * @param str
     * @return
     */
    public static boolean isEmail(String str) {
        return PATTERN_EMAIL_VALID.matcher(str).matches();
    }

    /**
     * 判断是否是手机号
     *
     * @param str
     * @return
     */
    public static boolean isMobile(String str) {
        return PATTERN_MOBILE_VALID.matcher(str).matches();
    }
}
