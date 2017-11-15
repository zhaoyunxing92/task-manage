package com.sunny.task.controller.org;

import com.sunny.task.form.org.OrgUserForm;
import com.sunny.task.service.org.OrganizationUserService;
import com.sunny.task.result.BaseResult;
import com.sunny.task.result.ResultEnum;
import com.sunny.task.utils.ResultUtils;
import com.sunny.task.valid.InsertGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunny
 * @className com.sunny.task.controller.org.OrganizationUserController
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
        //organizationUserService.addOrgUser(org)
        return ResultUtils.success(ResultEnum.SUCCESS,organizationUserService.addOrgUser(form));
    }
}
