package cn.cqu.edu.sa.HttpInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

@Service
public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        response.setContentType("text/html;charset=utf-8");
        System.out.println(request.getParameter("msg"));
        if (request.getParameter("msg") != null && request.getParameter("msg").equals("true")) {
            System.out.println(3);
            return true;
        } else {
            response.sendRedirect("http://localhost:8888/back?back=" + request.getRequestURL());
            return false;
        }
    }

}