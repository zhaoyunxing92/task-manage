package com.sunny.task.mapper.org;

import com.sunny.task.core.common.mapper.BaseMapper;
import com.sunny.task.model.org.OrganizationMember;
import com.sunny.task.model.org.vo.OrganizationMemberVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationMemberMapper extends BaseMapper<OrganizationMember, String> {
    /**
     * 获取团队的全部成员
     * @param orgId
     * @return
     */
    List<OrganizationMemberVo> selectOrganizationMembersOrgId(@Param("orgId") String orgId);
}
