package com.sunny.task.mapper.user;


import com.sunny.task.exception.TaskException;
import com.sunny.task.mapper.BaseMapper;
import com.sunny.task.model.user.AppUser;
import com.sunny.task.model.user.vo.AppUserVo;
import org.apache.ibatis.annotations.Param;

public interface AppUserMapper extends BaseMapper<AppUser, Long> {
    /**
     * 根据用户id获取 TaskManageUser
     *
     * @param userId
     * @return
     * @throws TaskException
     */
    AppUserVo selectTaskManageUserByUserIdAndPassword(@Param("id") Long userId) throws TaskException;
}
