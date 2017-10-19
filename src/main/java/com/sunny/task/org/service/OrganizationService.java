package com.sunny.task.org.service;

import com.sunny.task.org.form.OrgForm;
import com.sunny.task.org.model.vo.OrganizationVo;

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
}
