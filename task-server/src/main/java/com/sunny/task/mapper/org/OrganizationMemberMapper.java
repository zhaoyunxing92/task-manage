package com.sunny.task.mapper.org;


import com.sunny.task.mapper.BaseMapper;
import com.sunny.task.model.org.OrganizationMember;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunny
 * @className com.sunny.task.mapper.org.OrganizationMemberMapper
 * @date 2017.11.29 17:30
 * @description:
 */
public interface OrganizationMemberMapper extends BaseMapper<OrganizationMember, Long> {
    /**
     * 查询人员个数
     *
     * @param orgId
     * @return
     */
    int selectCountByOrgId(@Param("orgId") String orgId);
}
