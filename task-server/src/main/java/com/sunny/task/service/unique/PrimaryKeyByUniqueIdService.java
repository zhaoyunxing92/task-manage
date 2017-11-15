package com.sunny.task.service.unique;

/**
 * @author sunny
 * @className com.sunny.task.service.unique.PrimaryKeyByUniqueIdService
 * @date 2017-10-20 14:10
 * @description:
 */
public interface PrimaryKeyByUniqueIdService {
    /**
     * 添加唯一键搜索
     *
     * @param unqId
     * @param pkId
     * @param type
     */
    void addPrimaryKeyByUniqueId(String unqId, Long pkId, Byte type);

    /**
     * 根据唯一键获取主键id
     *
     * @param unqId
     * @return
     */
    Long findPrimaryKeyByUniqueId(String unqId);
}
