package com.sunny.task.mapper.project;

import com.sunny.task.mapper.BaseMapper;
import com.sunny.task.model.project.ProjectVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectVersionMapper extends BaseMapper<ProjectVersion, Long> {

    /**
     * 删除项目版本
     * @param uid
     */
    void deleteProjectVersion(@Param("uid") String uid);


    List<ProjectVersion> selectProjectVersionsByProId(String proId);
}
