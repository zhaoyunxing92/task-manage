package com.sunny.task.service.project.impl;

import com.sunny.task.exception.TaskException;
import com.sunny.task.field.BaseFields;
import com.sunny.task.form.pro.ProForm;
import com.sunny.task.mapper.project.ProjectMapper;
import com.sunny.task.model.project.vo.ProjectVo;
import com.sunny.task.result.ResultEnum;
import com.sunny.task.service.project.ProjectService;
import com.sunny.task.service.project.ProjectUserService;
import com.sunny.task.service.project.ProjectVersionService;
import com.sunny.task.service.unique.PrimaryKeyByUniqueIdService;
import com.sunny.task.utils.UUIDUtills;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunny
 * @className com.sunny.task.service.project.impl.ProjectServiceImpl
 * @date 2017-11-15 10:16
 * @description:
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private PrimaryKeyByUniqueIdService primaryKeyByUniqueIdService;
    @Autowired
    private ProjectUserService projectUserService;
    @Autowired
    private ProjectVersionService projectVersionService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addProject(ProForm form) {
        ProjectVo project = null;
        String unqId = null;
        try {
            project = new ProjectVo();
            BeanUtils.copyProperties(form, project);
            unqId = UUIDUtills.getPrefixUUID(pro_uid_prefix);
            project.setuId(unqId);
            projectMapper.insertSelective(project);
        } catch (BeansException ignore) {
            logger.warn("bean转换异常：{}", ignore);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.TASK_INSERT_PRO_ERROR, e);
        }

        List<String> addUsers = new ArrayList<>();
        addUsers.add(form.getOwnerId());
        /*添加项目成员*/
        projectUserService.addProjectUser(form.getOrgId(), unqId, true, addUsers);
        /*添加项目默认版本*/
        projectVersionService.addProjectDefaultVersion(unqId);
        
        /*添加unq搜索*/
        primaryKeyByUniqueIdService.addPrimaryKeyByUniqueId(unqId, project.getId(), BaseFields.APP_ORG_TYPE);
        return unqId;
    }

    @Override
    public ProjectVo getProjectDetailsByUId(String uId) {

        return projectMapper.selectProjectDetailsByUId(uId);
    }
}
