package com.sunny.task.interceptor;

import com.google.gson.JsonObject;
import com.sunny.task.context.TaskAppUserContext;
import com.sunny.task.exception.TaskException;
import com.sunny.task.field.BaseFields;
import com.sunny.task.result.BaseResult;
import com.sunny.task.result.ResultEnum;
import com.sunny.task.utils.CookiesUtils;
import com.sunny.task.utils.GsonUtils;
import com.sunny.task.utils.NullUtils;
import com.sunny.task.utils.TokenUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.interceptor.BugManageInterceptor
 * @date 2017-06-30 09:09
 * @description: controller层 拦截器
 */
public class TaskInterceptor implements HandlerInterceptor {

    private static final String[] EXCLUDES = {/*"/swagger-resources", "/configuration/security", "/v2/api-docs", "/configuration/ui",*/"/error", "/reg", "/auth", "/user"};

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {

        String method = req.getMethod();
        if (method.equalsIgnoreCase("OPTIONS")) {
            return true;
        }


        String path = req.getServletPath();
        if (isInterceptor(path) && !setTaskAppUserContext(path, req)) {
            //返回json形式的错误信息
            res.setCharacterEncoding("UTF-8");
            res.setContentType("application/json");
            res.setStatus(SC_UNAUTHORIZED); //返回401状态码
            BaseResult result = new BaseResult();
            result.setCode(ResultEnum.TASK_TOKEN_LOGIN_REJECT_ERROR.getCode());
            result.setMsg(ResultEnum.TASK_TOKEN_LOGIN_REJECT_ERROR.getMsg());
            res.getWriter().println(GsonUtils.getGson().toJson(result));
            res.getWriter().flush();
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object o, Exception e) throws Exception {

    }

    /**
     * 设置上下文
     *
     * @param path
     * @param req
     * @return
     */
    private boolean setTaskAppUserContext(String path, HttpServletRequest req) {
        //String app_user_cookie = req.getHeader("token");

        Cookie app_user_cookie = CookiesUtils.getCookie(req, BaseFields.APP_USER_COOKIE_KEY);
        String user_token;
        JsonObject parseToken;
        if (NullUtils.isNotNull(app_user_cookie)) {
            user_token = app_user_cookie.getValue();
            parseToken = TokenUtils.parseToken(user_token);
            if (NullUtils.isNotNull(parseToken.get("error_type"))) {
                switch (parseToken.get("error_type").getAsString()) {
                    case "ExpiredJwtException":
                        throw new TaskException(ResultEnum.TASK_TOKEN_EXPIRED_ERROR);
                    case "UnsupportedJwtException":
                        throw new TaskException(ResultEnum.TASK_TOKEN_UNSUPPORTED_ERROR);
                    case "MalformedJwtException":
                        throw new TaskException(ResultEnum.TASK_TOKEN_MALFORME_ERROR);
                    case "SignatureException":
                        throw new TaskException(ResultEnum.TASK_TOKEN_SIGNATURE_ERROR);
                    case "IllegalArgumentException":
                        throw new TaskException(ResultEnum.TASK_TOKEN_ILLEGAL_ARGUMENT_ERROR);
                    default:
                        throw new TaskException(ResultEnum.TASK_TOKEN_UNKNOWN_ERROR);
                }
            } else {
                //用户id
                Long id = parseToken.get("id").getAsLong();
                //用户uid
                String uid = parseToken.get("uid").getAsString();
                TaskAppUserContext.setTaskUserId(id);
                TaskAppUserContext.setTaskUserUNQId(uid);
                return true;
            }
        } else {
            return false;
        }


    }

    /**
     * 是否拦截path ,默认都拦截
     *
     * @param path
     * @return
     */
    private boolean isInterceptor(String path) {
        for (String exclude : EXCLUDES) {
            if (path.startsWith(exclude)) {
                return false;
            }
        }
        return true;
    }
}
