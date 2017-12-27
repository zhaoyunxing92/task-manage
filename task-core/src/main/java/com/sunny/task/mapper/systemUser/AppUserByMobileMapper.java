package com.sunny.task.mapper.systemUser;

import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.systemUser.AppUserByMobile;
import org.apache.ibatis.annotations.Param;

public interface AppUserByMobileMapper extends BaseMapper<AppUserByMobile, String> {
    /**
     * 根据手机号获取用户uid
     *
     * @param mobile 手机号
     * @return 用户uid
     */
    String selectAppUserUidByMobile(String mobile);

    /**
     * 添加根据手机号查询用户uid
     *
     * @param uId    用户uid
     * @param mobile 手机号
     */
    void insertAppUserByMobileKey(@Param("uId") String uId, @Param("mobile") String mobile) throws Exception;
}
