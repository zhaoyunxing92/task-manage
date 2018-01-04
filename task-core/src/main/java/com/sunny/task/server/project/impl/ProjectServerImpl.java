package com.sunny.task.server.project.impl;

import com.sunny.task.controller.project.form.ProjectForm;
import com.sunny.task.core.common.context.TaskAppUserContext;
import com.sunny.task.core.common.exception.TaskException;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.UUIDUtills;
import com.sunny.task.mapper.project.ProjectMapper;
import com.sunny.task.model.project.Project;
import com.sunny.task.model.project.vo.ProjectVo;
import com.sunny.task.server.main.AppUserServer;
import com.sunny.task.server.project.ProjectServer;
import com.sunny.task.server.project.ProjectUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunny
 * @className com.sunny.task.server.project.impl.ProjectServerImpl
 * @date 2017-12-28 13:09
 * @description:
 */
@Service
public class ProjectServerImpl implements ProjectServer {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ProjectUserServer projectUserServer;
    @Autowired
    private AppUserServer appUserServer;

    /**
     * 添加团队项目
     *
     * @param form
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addOrganizationProject(ProjectForm form) {
        String uId = UUIDUtills.getUUID(ProjectServer.ORG_PROJECT_UID_PREFIX);

        try {
            String userUId = TaskAppUserContext.getuId();
            Project project = new Project();
            project.setuId(uId);
            String orgId = form.getOrgId();
            String ownerId = form.getOwnerId();
            if(!appUserServer.checkUIdIsLegal(ownerId)){
                throw new TaskException(ResultEnum.SYSTEM_UID_IS_NOT_LEGAL);
            }
            project.setOrgId(orgId);
            project.setName(form.getName());

            project.setOwnerId(ownerId);
            project.setCreator(userUId);
            projectMapper.insertSelective(project);
            //添加项目成员
            projectUserServer.addOrgnizationProjectUserAuto(orgId, uId, ownerId);
        } catch (Exception e) {
            throw new TaskException(ResultEnum.TASK_INSERT_PROJECT_ERROR, e.getMessage());
        }
        return uId;
    }

    /**
     * 根据组织id和项目id获取项目详情
     *
     * @param orgId
     * @param proId
     * @return
     */
    @Override
    public ProjectVo findOrganizationProjectByProIdAndOrgId(String orgId, String proId) {
        return projectMapper.selectOrganizationProjectByProIdAndOrgId(orgId, proId);
    }
}
