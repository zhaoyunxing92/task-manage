package com.sunny.task.core.handle;

import com.sunny.task.common.base.BaseResult;
import com.sunny.task.common.utils.GsonUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sunny
 * @className com.sunny.task.core.handle.EntryPointUnauthorizedHandler
 * @date 2017-10-18 10:09
 * @description: 未登录或权限不足拦截器
 */
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {
    /**
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //返回json形式的错误信息
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        BaseResult resut = new BaseResult();
        resut.setCode(401);
        resut.setMsg("不合法的token！");
        response.setStatus(401);
        response.getWriter().println(GsonUtils.getGson().toJson(resut));
        response.getWriter().flush();

    }
}
