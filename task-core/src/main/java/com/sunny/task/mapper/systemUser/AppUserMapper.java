package com.sunny.task.mapper.systemUser;

import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.systemUser.AppUser;
import com.sunny.task.model.systemUser.vo.AppUserVo;

public interface AppUserMapper extends BaseMapper<AppUser, String> {
    /**
     * 根据用户uid获取用户
     *
     * @param uId 用户uid
     * @return AppUserVo
     */
    AppUserVo selectAppUserByUId(String uId);

    /**
     * 统计uid个数
     *
     * @param uId
     * @return
     */
    int selectAppUserCount(String uId);

    /**
     * 根据uid查询用户昵称
     *
     * @param uId
     * @return
     */

    String selectAppUserNickNameByUId(String uId);
}
