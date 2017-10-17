package com.sunny.task.core.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.interceptor.BugManageInterceptor
 * @date 2017-06-30 09:09
 * @description: controller层 拦截器
 */
public class TaskInterceptor implements HandlerInterceptor {
    // TODO:后期可以根据环境判断开发环境过滤swagger文档
    // private static final List<String> EXCLUDES = Arrays.asList("/swagger-resources","/configuration/security", "/v2/api-docs", "/configuration/ui", "/reg", "/auth");
    
    private static final String[] EXCLUDES = {/*"/swagger-resources", "/configuration/security", "/v2/api-docs", "/configuration/ui",*/ "/reg", "/auth","/user"};

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
        //  req.setCharacterEncoding(encoding);
        //res.setCharacterEncoding(encoding);
//        String path = req.getServletPath();
//
//        HttpSession session = req.getSession();
//        if (session == null) {
//            session = req.getSession(true);
//        }
//
//        String sessionId = session.getId();
//
//        if (isInterceptor(path) && !sessionId.equals(BugAppUser.sessionId())) {
//            res.setContentType("application/json; charset=utf-8");
//            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            res.getWriter().write("请先登录吧！");
//            return false;
//        } else {
//            return true;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object o, Exception e) throws Exception {

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
