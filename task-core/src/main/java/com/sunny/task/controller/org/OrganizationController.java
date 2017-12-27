package com.sunny.task.controller.org;

import com.sunny.task.controller.org.form.OrgForm;
import com.sunny.task.core.common.result.BaseResult;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.ResultUtils;
import com.sunny.task.core.common.valid.InsertGroup;
import com.sunny.task.server.org.OrganizationServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunny
 * @className com.sunny.task.controller.org.OrganizationController
 * @date 2017-12-27 14:58
 * @description: 组织模块代码
 */
@RestController
@RequestMapping("/org")
public class OrganizationController {
    @Autowired
    private OrganizationServer organizationServer;

    /**
     * 创建组织
     *
     * @param form
     * @return
     */
    @PostMapping
    BaseResult addOrganization(@RequestBody @Validated({InsertGroup.class}) OrgForm form) {

        return ResultUtils.success(ResultEnum.TASK_INSERT_ORG_SUCCESS, organizationServer.saveOrganization(form));
    }
}
