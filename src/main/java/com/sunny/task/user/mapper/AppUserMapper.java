package com.sunny.task.user.mapper;

import com.sunny.task.common.base.BaseMapper;
import com.sunny.task.core.exception.TaskException;
import com.sunny.task.user.model.AppUser;
import com.sunny.task.user.model.vo.AppUserVo;

public interface AppUserMapper extends BaseMapper<AppUser, Long> {
    /**
     * 根据用户id获取 TaskManageUser
     *
     * @param userId
     * @return
     * @throws TaskException
     */
    AppUserVo selectTaskManageUserByUserIdAndPassword(Long userId) throws TaskException;
}
