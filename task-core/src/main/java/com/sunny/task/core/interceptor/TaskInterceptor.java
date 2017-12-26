package com.sunny.task.core.interceptor;

import com.google.gson.JsonObject;
import com.sunny.task.core.common.context.TaskAppUserContext;
import com.sunny.task.core.common.exception.TaskException;
import com.sunny.task.core.common.field.BaseFields;
import com.sunny.task.core.common.result.BaseResult;
import com.sunny.task.core.common.result.ResultEnum;
import com.sunny.task.core.common.utils.CookiesUtils;
import com.sunny.task.core.common.utils.GsonUtils;
import com.sunny.task.core.common.utils.NullUtils;
import com.sunny.task.core.common.utils.TokenUtils;
import org.apache.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.interceptor.BugManageInterceptor
 * @date 2017-06-30 09:09
 * @description: controller层 拦截器
 */
public class TaskInterceptor implements HandlerInterceptor {

    private static final String[] EXCLUDES = {"/error", "/reg", "/auth", "/user"};

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
        //   String method = req.getMethod();
        //vue post 默认会发送OPTIONS请求
//        String options = "OPTIONS";
//        if (options.equalsIgnoreCase(method)) {
//            return true;
//        }

        String path = req.getServletPath();
        if (isInterceptor(path) && !setTaskAppUserContext(path, req)) {
            //返回json形式的错误信息
            res.setCharacterEncoding("UTF-8");
            res.setContentType("application/json");

            //返回401状态码
            res.setStatus(HttpStatus.SC_UNAUTHORIZED);
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

        Cookie appUserCookie = CookiesUtils.getCookie(req, BaseFields.APP_USER_COOKIE_KEY);
        String userToken;
        JsonObject parseToken;
        if (NullUtils.isNotNull(appUserCookie)) {
            userToken = appUserCookie.getValue();
            parseToken = TokenUtils.parseToken(userToken);
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
                String uId = parseToken.get("uId").getAsString();
                TaskAppUserContext.setuId(uId);
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