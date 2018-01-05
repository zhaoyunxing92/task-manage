package com.sunny.task.mapper.project;

import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.project.ProjectUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectUserMapper extends BaseMapper<ProjectUser, String> {

    /**
     * 批量添加项目成员
     *
     * @param addProjectUsers
     * @throws Exception
     */
    void insertOrgnizationProjectUsers(@Param("addProjectUsers") List<ProjectUser> addProjectUsers) throws Exception;

}
