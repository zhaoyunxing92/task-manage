package com.sunny.task.mapper.org;


import com.sunny.task.mapper.BaseMapper;
import com.sunny.task.model.org.OrganizationMember;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMemberMapper extends BaseMapper<OrganizationMember,Long> {
     int selectCountByOrgId(@Param("orgId") String orgId);
}
