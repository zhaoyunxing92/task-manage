package com.sunny.task.org.controller;


import com.sunny.task.context.TaskAppUserContext;
import com.sunny.task.form.form.OrgForm;
import com.sunny.task.org.service.OrganizationService;
import com.sunny.task.result.BaseResult;
import com.sunny.task.result.ResultEnum;
import com.sunny.task.utils.ResultUtils;
import com.sunny.task.valid.InsertGroup;
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

    /**
     * 获取当前登录人的组织
     *
     * @return
     */
    @PostMapping("/current")
    BaseResult findCurrentAppUserOrgs() {
        return ResultUtils.success(ResultEnum.SUCCESS, organizationService.getAppUserOrgsByUserId(TaskAppUserContext.getTaskUserUNQId()));
    }
    //修改团队

    //删除团队

    //团队详情
    @GetMapping("/info")
    BaseResult getOrganizationDetail(@RequestParam("uId") String uId) {
        return ResultUtils.success(ResultEnum.SUCCESS, organizationService.getOrganizationDetail(uId));
    }

}
