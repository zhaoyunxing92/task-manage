package com.sunny.task.service.msg;

import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Map;

/**
 * @author sunny
 * @className com.sunny.task.core.service.TaskEmailService
 * @date 2017-10-19 10:15
 * @description: 发送邮件服务
 */
public interface TaskEmailService {
    /**
     * 发送模板邮件
     *
     * @param theme
     * @param tos
     * @param tpl
     * @param model
     * @throws MessagingException
     * @throws IOException
     * @throws TemplateException
     */
    void sendTemplateEmail(String theme, String[] tos, String tpl, Map<String, Object> model) throws MessagingException, IOException, TemplateException;

    /**
     * 发送激活账号邮箱
     *
     * @param tos
     * @param model
     * @throws MessagingException
     * @throws IOException
     * @throws TemplateException
     */
    void sendActiveAccountEmail(String[] tos, Map<String, Object> model) throws MessagingException, IOException, TemplateException;
    
}
