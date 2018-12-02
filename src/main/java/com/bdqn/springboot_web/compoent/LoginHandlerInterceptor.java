package com.bdqn.springboot_web.compoent;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 贺威
 * @create 2018-11-29 23:57
 * 拦截器
 * 拦截器一定要继承 HandlerInterceptor
 *
 * 登录检查 没有的登录的用户不能进入后台
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser ==null) {
            //未登录
            request.setAttribute("msg", "权限不足，请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }else {
            //已登录
            return  true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
