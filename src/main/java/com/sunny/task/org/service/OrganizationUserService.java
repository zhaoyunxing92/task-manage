package com.sunny.task.org.service;

import com.sunny.task.common.base.TaskManageUser;
import com.sunny.task.org.form.OrgUserForm;

/**
 * @author sunny
 * @className com.sunny.task.org.service.OrganizationUserService
 * @date 2017-10-20 10:06
 * @description:
 */
public interface OrganizationUserService {
    /**
     * 添加成员
     *
     * @param form
     * @return
     */
    TaskManageUser addOrgUser(OrgUserForm form);
}