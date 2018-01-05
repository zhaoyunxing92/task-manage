package com.sunny.task.mapper.org;

import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.org.Organization;
import com.sunny.task.model.org.vo.OrganizationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationMapper extends BaseMapper<Organization, String> {
    /**
     * 根据组织id获取组织
     *
     * @param uId
     * @param userId
     * @return
     */
    OrganizationVo selectOrganizationById(@Param("uId") String uId, @Param("userId") String userId);

    /**
     * @param userId
     * @return
     */
    List<OrganizationVo> selectOrganizationByUserUId(@Param("userId") String userId);
}
