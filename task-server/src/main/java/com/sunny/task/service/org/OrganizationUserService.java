package com.sunny.task.service.org;


import com.sunny.task.contaxt.TaskManageUser;
import com.sunny.task.form.org.OrgUserForm;

/**
 * @author sunny
 * @className com.sunny.task.service.org.OrganizationUserService
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
