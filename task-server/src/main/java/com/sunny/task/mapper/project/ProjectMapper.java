package com.sunny.task.mapper.project;

import com.sunny.task.mapper.BaseMapper;
import com.sunny.task.model.project.vo.ProjectVo;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper extends BaseMapper<ProjectVo,Long> {
    /**
     * 根据id获取详情
     * @param uId
     * @return
     */
    ProjectVo selectProjectDetailsByUId(@Param("uId") String uId);

    /**
     * 获取项目个数
     * @param orgId
     * @return
     */
    Integer selectProjectCountByOrgId(@Param("orgId")String orgId);
}
