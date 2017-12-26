package com.sunny.task.core.common.utils;

/**
 * @author sunny
 * @className com.sunny.task.core.common.utils.StringUtilsTest
 * @date 2017-12-26 15:32
 * @description:
 */
public class StringUtilsTest {
    public static void main(String[] args) {
        String id = null;
        System.out.println("id = " + StringUtils.isEmpty(id,true));
        System.out.println("id = " + StringUtils.isBlank(id));
        id = "";
        System.out.println("id = " + StringUtils.isEmpty(id));
        System.out.println("id = " + StringUtils.isBlank(id));

        id = "  ";
        System.out.println("id = " + StringUtils.isEmpty(id));
        System.out.println("id = " + StringUtils.isBlank(id));
    }


}
