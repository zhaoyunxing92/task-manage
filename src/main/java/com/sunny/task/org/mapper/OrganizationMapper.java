package com.sunny.task.org.mapper;

import com.sunny.task.common.base.BaseMapper;
import com.sunny.task.org.model.vo.OrganizationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationMapper extends BaseMapper<OrganizationVo, Long> {
    /**
     * 根据uId查询组织信息
     *
     * @param uId
     * @return
     */
    OrganizationVo selectOrgDetailByUId(@Param("uniqueId") String uId, @Param("userId") String userId);

    /**
     * 根据userid获取组织
     *
     * @param userId
     * @return
     */
    List<OrganizationVo> selectAppUserOrgsByUserId(@Param("userId") String userId);
}
