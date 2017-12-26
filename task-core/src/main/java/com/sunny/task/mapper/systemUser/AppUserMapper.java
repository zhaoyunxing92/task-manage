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
}
