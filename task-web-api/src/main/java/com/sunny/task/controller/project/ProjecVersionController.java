package com.sunny.task.controller.project;

import com.sunny.task.form.pro.ProVsersionForm;
import com.sunny.task.result.BaseResult;
import com.sunny.task.result.ResultEnum;
import com.sunny.task.service.project.ProjectVersionService;
import com.sunny.task.utils.ResultUtils;
import com.sunny.task.valid.InsertGroup;
import com.sunny.task.valid.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunny
 * @className com.sunny.task.controller.project.ProjecVersionController
 * @date 2017-11-17 10:37
 * @description: 项目版本
 */
@RestController
@RequestMapping("/pro/version")
public class ProjecVersionController {
     @Autowired
     private ProjectVersionService projectVersionService;
    /**
     * 获取项目版本
     *
     * @param proId
     * @return
     */
    @GetMapping
    BaseResult getProjectVersions(@RequestParam("proId") String proId) {
        return ResultUtils.success(ResultEnum.SUCCESS,projectVersionService.getProjectVersions(proId));
    }

    @PostMapping("/add")
    BaseResult addProjectVersion(@RequestBody @Validated({InsertGroup.class}) ProVsersionForm form) {

        return ResultUtils.success(ResultEnum.SUCCESS,projectVersionService.addProjectVersion(form));
    }

    /**
     * 修改版本信息
     * @param form
     * @return
     */
    @PutMapping("/revise")
    BaseResult reviseProjectVersion(@RequestBody @Validated({UpdateGroup.class}) ProVsersionForm form) {
        projectVersionService.reviseProjectVersion(form);
        return ResultUtils.success(ResultEnum.SUCCESS);
    }

    /**
     * 删除版本信息
     * @param uid
     * @return
     */
    @DeleteMapping("/remove")
    BaseResult removeProjectVersion(@RequestParam("uid") String uid) {
        projectVersionService.removeProjectVersion(uid);
        return ResultUtils.success(ResultEnum.SUCCESS);
    }

}
