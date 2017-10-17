package com.sunny.task.common.utils;

import java.util.UUID;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.utils.UUIDUtills
 * @date 2017-06-09 17:06
 * @description:
 */
public class UUIDUtills {
    private UUIDUtills() {
        super();
    }

    /**
     * 前缀+_+uuid
     *
     * @param prefix
     * @return
     */
    public static String getUUID(String prefix) {

        return prefix + "_" + getUUID();
    }

    /**
     * 前缀+_+uuid
     *
     * @param prefix
     * @return
     */
    public static String getPrefixUUID(String prefix) {
        return prefix + getUUID();
    }

    /**
     * 前缀+_+uuid
     *
     * @param prefix
     * @return
     */
    public static String getPrefix64UUID(String prefix) {
        return prefix + getUUID() + getUUID();
    }

    /**
     * 默认id_+uuid
     *
     * @return
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }
}
