package com.sunny.task.mapper.project;

import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.project.ProjectVersion;
import com.sunny.task.model.project.vo.ProjectVersionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectVersionMapper extends BaseMapper<ProjectVersion, String> {
    /**
     * 获取项目版本
     *
     * @param proId
     * @return
     */
    List<ProjectVersionVo> selectOrganizationProjectVersionsByProId(@Param("proId") String proId);
}
