package com.sunny.task.org.mapper;


import com.sunny.task.mapper.BaseMapper;
import com.sunny.task.org.model.OrganizationMember;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMemberMapper extends BaseMapper<OrganizationMember,Long> {
     int selectCountByOrgId(@Param("orgId") String orgId);
}
