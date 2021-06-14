package com.example.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后，应该有用户的session
        String  loginUser = (String) request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            request.setAttribute("msg","无法进入");
            request.getRequestDispatcher("index.html").forward(request,response);
            return false;
        }else{
            return true;
        }
    }
}
