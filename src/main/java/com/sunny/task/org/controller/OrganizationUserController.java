package com.sunny.task.org.controller;

import com.sunny.task.common.base.BaseResult;
import com.sunny.task.common.base.ResultEnum;
import com.sunny.task.common.utils.ResultUtils;
import com.sunny.task.common.valid.InsertGroup;
import com.sunny.task.org.form.OrgUserForm;
import com.sunny.task.org.service.OrganizationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunny
 * @className com.sunny.task.org.controller.OrganizationUserController
 * @date 2017-10-20 10:05
 * @description:
 */
@RestController
@RequestMapping("/org/user")
public class OrganizationUserController {
    @Autowired
    private OrganizationUserService organizationUserService;

    /**
     * 添加组织成员
     *
     * @param form
     * @return
     */
    @PostMapping("/add")
    BaseResult addOrgUser(@RequestBody @Validated({InsertGroup.class}) OrgUserForm form) {
        //organizationUserService.addOrgUser(form)
        return ResultUtils.success(ResultEnum.SUCCESS,organizationUserService.addOrgUser(form));
    }
}
