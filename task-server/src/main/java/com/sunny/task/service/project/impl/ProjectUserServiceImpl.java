package com.sunny.task.service.project.impl;

import com.sunny.task.exception.TaskException;
import com.sunny.task.form.pro.ProUserForm;
import com.sunny.task.mapper.project.ProjectUserMapper;
import com.sunny.task.model.project.ProjectUser;
import com.sunny.task.model.project.vo.ProjectVo;
import com.sunny.task.result.ResultEnum;
import com.sunny.task.service.project.ProjectService;
import com.sunny.task.service.project.ProjectUserService;
import com.sunny.task.utils.NullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.task.service.project.impl.ProjectUserServiceImpl
 * @date 2017-11-16 09:22
 * @description:
 */
@Service
public class ProjectUserServiceImpl implements ProjectUserService {
    @Autowired
    private ProjectUserMapper projectUserMapper;
    @Autowired
    private ProjectService projectService;

    @Override
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void addProjectUser(String orgId, String proId, Boolean auto, List<String> users) {
        Byte isAdmin = 1; /*默认是管理员*/

        /*校验是否超员*/

        if (!auto) {
            isAdmin = 0;
            //TODO:  projectService.getProjectDetailsByUId 方法不能直接获取项目成员id，后期redis要考虑，项目成员个数0=null
            ProjectVo project = projectService.getProjectDetailsByUId(proId);
            if (NullUtils.isNull(project)) {
                return;
            }
            if (project.getMemberLimit() <= project.getUserCount()) {
                throw new TaskException(ResultEnum.TASK_ORG_PRO_USER_OVERFLOW);
            }
            orgId = project.getOrgId();
            List<String> oldUsers = projectUserMapper.selectProjectUserIdByProId(proId);
            users.removeAll(oldUsers);
        }
        //</editor-fold>
        if (users.isEmpty() || users.size() <= 0) {
            return;
        }
        try {
            projectUserMapper.insertProjectUsers(orgId, proId, isAdmin, users);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.TASK_INSERT_PRO_USER_ERROR, e);
        }
    }

    @Override
    public void addProjectUser(String proId, Boolean auto, List<String> users) {
        addProjectUser(null, proId, auto, users);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeProjectUserByProId(String proId, List<String> userIds) {
        try {
            projectUserMapper.deleteProjectUserByProId(proId, userIds);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.TASK_DELETE_PRO_USER_ERROR, e);
        }
    }

    @Override
    public void reviseProjectUserByProId(ProUserForm form) {
        ProjectUser projectUser = new ProjectUser();
        projectUserMapper.updateByPrimaryKeySelective(projectUser);
    }
}
