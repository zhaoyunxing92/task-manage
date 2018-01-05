package com.sunny.task.mapper.project;

import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.project.ProjectVersion;

public interface ProjectVersionMapper extends BaseMapper {
    int deleteByPrimaryKey(String uId);

    int insert(ProjectVersion record);

    int insertSelective(ProjectVersion record);

    ProjectVersion selectByPrimaryKey(String uId);

    int updateByPrimaryKeySelective(ProjectVersion record);

    int updateByPrimaryKey(ProjectVersion record);
}