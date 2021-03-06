package com.sunny.task.controller.org;

import com.sunny.task.controller.org.form.OrgUserForm;
import com.sunny.task.core.common.result.BaseResult;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.ResultUtils;
import com.sunny.task.core.common.valid.InsertGroup;
import com.sunny.task.server.org.OrganizationMemberServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunny
 * @className com.sunny.task.controller.org.OrganizationMemberController
 * @date 2017-12-27 23:15
 * @description:
 */
@RestController
@RequestMapping("/org/user")
public class OrganizationMemberController {
    @Autowired
    private OrganizationMemberServer organizationMemberServer;

    /**
     * 添加成员
     *
     * @param form
     * @return
     */
    @PostMapping
    BaseResult addOrganizationMember(@RequestBody @Validated({InsertGroup.class}) OrgUserForm form) {

        return ResultUtils.success(ResultEnum.TASK_ORG_ADD_USER_SUCCESS, organizationMemberServer.addOrganizationMember(form));
    }

    /**
     * 获取组织人员
     *
     * @return
     */
    @GetMapping
    BaseResult getOrganizationMembers(@RequestParam("orgId") String orgId) {

        return ResultUtils.success(ResultEnum.TASK_SELECT_ORG_USER_OK, organizationMemberServer.getOrganizationMembersOrgId(orgId));
    }
}
