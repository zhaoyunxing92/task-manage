package com.sunny.task.org.service;

import com.sunny.task.org.form.OrgForm;
import com.sunny.task.org.model.vo.OrganizationVo;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.task.org.service.OrganizationService
 * @date 2017-10-19 16:18
 * @description:
 */
public interface OrganizationService {
    /**
     * 创建组织
     *
     * @param form
     * @return
     */
    OrganizationVo addOrganization(OrgForm form);

    /**
     * 获取组织详情
     *
     * @param uId
     */
    OrganizationVo getOrganizationDetail(String uId);

    /**
     * 根据id获取用户的全部组织
     *
     * @param userId
     * @return
     */
    List<OrganizationVo> getAppUserOrgsByUserId(String userId);
}
