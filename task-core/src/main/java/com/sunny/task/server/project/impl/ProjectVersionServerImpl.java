package com.sunny.task.server.project.impl;

import com.sunny.task.controller.project.form.ProjectVsersionForm;
import com.sunny.task.core.common.context.TaskAppUserContext;
import com.sunny.task.core.common.exception.TaskException;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.UUIDUtills;
import com.sunny.task.mapper.project.ProjectVersionMapper;
import com.sunny.task.model.project.ProjectVersion;
import com.sunny.task.model.project.vo.ProjectVersionVo;
import com.sunny.task.server.project.ProjectVersionServer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.task.server.project.impl.ProjectVersionServerImpl
 * @date 2018-01-05 14:50
 * @description:
 */
@Service
public class ProjectVersionServerImpl implements ProjectVersionServer {
    @Autowired
    private ProjectVersionMapper projectVersionMapper;

    /**
     * 创建项目版本
     *
     * @param form
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addProjectVersion(ProjectVsersionForm form) {
        String uId = UUIDUtills.getUUID(ProjectVersionServer.ORG_PROJECT_VERSION_UID_PREFIX);
        try {

            ProjectVersion projectVersion = new ProjectVersion();
            BeanUtils.copyProperties(form, projectVersion);
            projectVersion.setuId(uId);
            projectVersion.setCreator(TaskAppUserContext.getuId());
            projectVersionMapper.insertSelective(projectVersion);
        } catch (Exception e) {
            throw new TaskException(ResultEnum.TASK_INSERT_PRO_VERSION_ERROR, e.getMessage());
        }
        return uId;
    }

    /**
     * 创建项目有添加默认版本
     *
     * @param proId
     * @return
     */
    @Override
    public void addProjectVersionAuto(String proId) {
        ProjectVsersionForm projectVsersionForm = new ProjectVsersionForm();
        String name = ProjectVersionServer.ORG_PROJECT_VERSION_DEFAULT_NAME;
        projectVsersionForm.setName(name);
        projectVsersionForm.setIntro(name);
        projectVsersionForm.setProId(proId);
        addProjectVersion(projectVsersionForm);
    }

    @Override
    public List<ProjectVersionVo> getOrganizationProjectVersions(String proId) {
        return projectVersionMapper.selectOrganizationProjectVersionsByProId(proId);
    }
}
