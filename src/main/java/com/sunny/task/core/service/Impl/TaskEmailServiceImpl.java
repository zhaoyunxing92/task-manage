package com.sunny.task.core.service.Impl;

import com.sunny.task.common.base.BaseFields;
import com.sunny.task.core.service.TaskEmailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Map;

/**
 * @author sunny
 * @className com.sunny.task.core.service.Impl.TaskEmailServiceImpl
 * @date 2017-10-19 10:15
 * @description:
 */
@Service
public class TaskEmailServiceImpl implements TaskEmailService {
  
    
    @Value("${spring.mail.username}")
    private String username;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Configuration configuration; //freeMarker configuration

    @Override
    public void sendTemplateEmail(String theme, String[] tos, String tpl, Map<String, Object> model) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(username);
        helper.setTo(tos);
        helper.setSubject(theme);
        Template t = configuration.getTemplate(tpl);  // freeMarker template
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        helper.setText(text, true);
        javaMailSender.send(mimeMessage);
       
    }

    @Override
    public void sendActiveAccountEmail(String[] tos, Map<String, Object> model) throws MessagingException, IOException, TemplateException {
        sendTemplateEmail(BaseFields.TASK_EMAIL_ACTIVE_ACCOUNT_THEME, tos, BaseFields.TASK_EMAIL_ACTIVE_ACCOUNT_TMP, model);
    }
    
}
