package com.sunny.task.service.project;

import com.sunny.task.form.pro.ProForm;
import com.sunny.task.model.project.vo.ProjectVo;

/**
 * @author sunny
 * @className com.sunny.task.service.project.ProjectService
 * @date 2017-11-15 10:15
 * @description:
 */
public interface ProjectService {
     String pro_uid_prefix = "task";

    ProjectVo addProject(ProForm form);
}
