package com.sunny.task.core.handle;

import com.sunny.task.common.base.BaseResult;
import com.sunny.task.common.utils.GsonUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sunny
 * @className com.sunny.task.core.handle.TaskAccessDeniedHandler
 * @date 2017-10-18 10:13
 * @description: 拒绝访问处理程序
 */
public class TaskAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        //返回json形式的错误信息
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        BaseResult resut = new BaseResult();
        resut.setCode(403);
        resut.setMsg("权限不足！");
        response.setStatus(403);
        response.getWriter().println(GsonUtils.getGson().toJson(resut));
        response.getWriter().flush();
    }
}
