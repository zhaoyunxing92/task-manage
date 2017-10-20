package com.sunny.task.org.controller;

import com.sunny.task.common.base.BaseResult;
import com.sunny.task.common.base.ResultEnum;
import com.sunny.task.common.utils.ResultUtils;
import com.sunny.task.common.valid.InsertGroup;
import com.sunny.task.org.form.OrgForm;
import com.sunny.task.org.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunny
 * @className com.sunny.task.org.controller.OrganizationController
 * @date 2017-10-19 16:17
 * @description:
 */
@RestController
@RequestMapping("/org")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    /**
     * 创建团队
     *
     * @param form
     * @return
     */
    @PostMapping("/add")
    BaseResult addOrganization(@RequestBody @Validated({InsertGroup.class}) OrgForm form) {
        return ResultUtils.success(ResultEnum.SUCCESS, organizationService.addOrganization(form));
    }
    //修改团队

    //删除团队

    //团队详情
    @GetMapping("/info")
    BaseResult getOrganizationDetail(@RequestParam("id") Long id) {
        return ResultUtils.success(ResultEnum.SUCCESS, organizationService.getOrganizationDetail(id));
    }

}
