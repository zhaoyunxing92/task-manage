package com.sunny.task.mapper.project;

import com.sunny.task.exception.TaskException;
import com.sunny.task.mapper.BaseMapper;
import com.sunny.task.model.project.ProjectUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectUserMapper extends BaseMapper<ProjectUser, Long> {
    /**
     * 添加项目成员
     *
     * @param orgId
     * @param proId
     * @param users
     * @throws TaskException
     */
    void insertProjectUsers(@Param("orgId") String orgId, @Param("proId") String proId, @Param("admin") Byte admin, @Param("users") List<String> users) throws TaskException;

    /**
     * 根据项目id获取项目成员id集合
     *
     * @param proId
     * @return
     */
    List<String> selectProjectUserIdByProId(@Param("proId") String proId) throws TaskException;

    /**
     * 批量删除项目成员
     *
     * @param proId
     * @param userIds
     */
    void deleteProjectUserByProId(@Param("proId")String proId, @Param("userIds")List<String> userIds) throws TaskException;
}
