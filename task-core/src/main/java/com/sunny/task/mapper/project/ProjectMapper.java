package com.sunny.task.mapper.project;

import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.project.Project;
import com.sunny.task.model.project.vo.ProjectVo;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper extends BaseMapper<Project, String> {

    /**
     * 根据项目id获取项目详情
     *
     * @param orgId
     * @param proId
     * @return
     */
    ProjectVo selectOrganizationProjectByProIdAndOrgId(@Param("orgId") String orgId, @Param("uId") String proId);
}
