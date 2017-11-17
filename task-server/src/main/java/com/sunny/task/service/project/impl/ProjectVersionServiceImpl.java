package com.sunny.task.service.project.impl;

import com.sunny.task.exception.TaskException;
import com.sunny.task.form.pro.ProVsersionForm;
import com.sunny.task.mapper.project.ProjectVersionMapper;
import com.sunny.task.model.project.ProjectVersion;
import com.sunny.task.result.ResultEnum;
import com.sunny.task.service.project.ProjectVersionService;
import com.sunny.task.utils.UUIDUtills;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.task.service.project.impl.ProjectVersionServiceImpl
 * @date 2017-11-17 10:43
 * @description:
 */
@Service
public class ProjectVersionServiceImpl implements ProjectVersionService {
    @Autowired
    private ProjectVersionMapper projectVersionMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addProjectVersion(ProVsersionForm form) {
        String uId;
        try {
            ProjectVersion projectVersion = new ProjectVersion();
            BeanUtils.copyProperties(form, projectVersion);
            uId = UUIDUtills.getPrefixUUID(pro_version_prefix);
            projectVersion.setuId(uId);
            projectVersionMapper.insertSelective(projectVersion);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.TASK_INSERT_PRO_VERSION_ERROR, e);
        }
        return uId;
    }

    @Override
    @Async
    public void addProjectDefaultVersion(String proId) {
        ProVsersionForm form = new ProVsersionForm();
        form.setProId(proId);
        form.setName(pro_version_default_name);

        addProjectVersion(form);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void reviseProjectVersion(ProVsersionForm form) {

        try {
            ProjectVersion projectVersion = new ProjectVersion();
            BeanUtils.copyProperties(form, projectVersion);
            projectVersionMapper.updateByPrimaryKeySelective(projectVersion);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.TASK_UPDATE_PRO_VERSION_ERROR, e);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeProjectVersion(String uid) {
        try {
            projectVersionMapper.deleteProjectVersion(uid);
        } catch (TaskException e) {
            throw new TaskException(ResultEnum.TASK_DELETE_PRO_VERSION_ERROR, e);
        }
    }

    @Override
    public List<ProjectVersion> getProjectVersions(String proId) {
        return projectVersionMapper.selectProjectVersionsByProId(proId);
    }
}
