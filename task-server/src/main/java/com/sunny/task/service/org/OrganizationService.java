package com.sunny.task.service.org;


import com.sunny.task.form.org.OrgForm;
import com.sunny.task.model.org.vo.OrganizationVo;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.task.service.org.OrganizationService
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
