package com.sunny.task.server.org;

import com.sunny.task.controller.org.form.OrgForm;
import com.sunny.task.model.org.vo.OrganizationVo;

/**
 * @author sunny
 * @className com.sunny.task.server.org.OrganizationServer
 * @date 2017-12-27 15:00
 * @description:
 */
public interface OrganizationServer {

    String ORG_UID_PREFIX = "org_";

    /**
     * 创建组织
     *
     * @param form
     * @return
     */
    String saveOrganization(OrgForm form);

    OrganizationVo findOrganizationById(String id);
}
