package com.sunny.task.server.project.impl;

import com.sunny.task.controller.project.form.ProjectUserForm;
import com.sunny.task.core.common.context.TaskAppUserContext;
import com.sunny.task.core.common.exception.TaskException;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.StringUtils;
import com.sunny.task.core.common.utils.UUIDUtills;
import com.sunny.task.mapper.project.ProjectUserMapper;
import com.sunny.task.model.project.ProjectUser;
import com.sunny.task.model.project.vo.ProjectVo;
import com.sunny.task.server.main.AppUserServer;
import com.sunny.task.server.project.ProjectServer;
import com.sunny.task.server.project.ProjectUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunny
 * @className com.sunny.task.server.project.impl.ProjectUserServerImpl
 * @date 2017-12-28 13:47
 * @description:
 */
@Service
public class ProjectUserServerImpl implements ProjectUserServer {

    @Autowired
    private ProjectUserMapper projectUserMapper;
    @Autowired
    private AppUserServer appUserServer;

    @Autowired
    private ProjectServer projectServer;

    /**
     * 添加项目成员
     *
     * @param orgId  团队id
     * @param proId  项目id
     * @param userId 成员id
     */
    @Override
    public void addOrgnizationProjectUserAuto(String orgId, String proId, String userId) {
        addOrgnizationProjectUsers(orgId, proId, new String[]{userId}, true);
    }

    /**
     * 批量添加项目成员
     *
     * @param orgId   团队
     * @param proId   项目
     * @param userIds 项目成员集合
     * @param auto    是否自动添加
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrgnizationProjectUsers(String orgId, String proId, String[] userIds, Boolean auto) {
        List<ProjectUser> addProjectUsers = new ArrayList<>();
        String userUId = TaskAppUserContext.getuId();
        if (auto) {
            ProjectUser projectUser = new ProjectUser();
            projectUser.setuId(UUIDUtills.getUUID(ProjectUserServer.ORG_PROJECT_USER_UID_PREFIX));
            projectUser.setCreator(userUId);
            projectUser.setOrgId(orgId);
            projectUser.setProId(proId);
            projectUser.setManager(Boolean.TRUE);
            projectUser.setUserId(userIds[0]);
            addProjectUsers.add(projectUser);
        } else {
            //获取项目详情
            ProjectVo projectVo = projectServer.findOrganizationProjectByProIdAndOrgId(orgId, proId);
            if (StringUtils.isBlank(projectVo.getuId())) {
                return;
            }
            //已经添加的成员
            List<String> oldUsers = new ArrayList<>(Arrays.asList(projectVo.getUserIdList().split(",")));

            List<String> addUsers = Arrays.asList(userIds);
            addUsers.removeAll(oldUsers);
            //去除重复成员
            int size = addUsers.size();
            if (size <= 0) {
                return;
            }
            //项目成员超限
            if (projectVo.getUserCount() + size >= projectVo.getMemberLimit()) {
                throw new TaskException(ResultEnum.TASK_ORG_PRO_USER_OVERFLOW);
            }

            //添加到
            for (String userId : addUsers) {
                //对userid校验
                if (appUserServer.checkUIdIsLegal(userId)) {
                    ProjectUser projectUser = new ProjectUser();
                    projectUser.setuId(UUIDUtills.getUUID(ProjectUserServer.ORG_PROJECT_USER_UID_PREFIX));
                    projectUser.setCreator(userUId);
                    projectUser.setOrgId(orgId);
                    projectUser.setProId(proId);
                    projectUser.setManager(Boolean.FALSE);
                    projectUser.setUserId(userId);
                    addProjectUsers.add(projectUser);
                }
            }
        }


        if (addProjectUsers.size() <= 0) {
            return;
        }
        //批量添加用户
        try {
            projectUserMapper.insertOrgnizationProjectUsers(addProjectUsers);
        } catch (Exception e) {
            throw new TaskException(ResultEnum.TASK_INSERT_PRO_USER_ERROR, e.getMessage());
        }
    }

    /**
     * 批量添加项目成员
     *
     * @param form 前端提交表单
     */
    @Override
    public void addOrgnizationProjectUsers(ProjectUserForm form) {
        addOrgnizationProjectUsers(form.getOrgId(), form.getProId(), form.getUserIds(), false);
    }
}
