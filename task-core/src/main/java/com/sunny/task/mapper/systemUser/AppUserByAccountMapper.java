package com.sunny.task.mapper.systemUser;

import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.systemUser.AppUserByAccount;
import org.apache.ibatis.annotations.Param;

public interface AppUserByAccountMapper extends BaseMapper<AppUserByAccount, String> {

    /**
     * 根据账号获取用户uid
     *
     * @param account 根据账号获取用户uid
     * @return 返回用户uid
     */
    String selectAppUserUidByAccount(String account);

    /**
     * 添加根据账号获取uid
     *
     * @param uId     用户uid
     * @param account 账号
     * @throws Exception
     */
    void insertAppUserByAccountKey(@Param("uId") String uId, @Param("account") String account) throws Exception;

}
