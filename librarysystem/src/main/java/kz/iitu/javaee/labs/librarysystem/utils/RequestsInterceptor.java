package kz.iitu.javaee.labs.librarysystem.utils;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kz.iitu.javaee.labs.librarysystem.beans.UserBean;
import kz.iitu.javaee.labs.librarysystem.entities.User;

public class RequestsInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	UserBean dbBean;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            AuthRequired authRequired = handlerMethod.getMethodAnnotation(AuthRequired.class);
            if (authRequired != null) {
                User user = (User)request.getSession().getAttribute(Utils.SESSION_USER);
                if (user != null && (user = dbBean.getUserById(user.id)) != null) {
                	boolean access = false;
                	if (authRequired.role() == 0) access = true;
                	if (!access) {
                		for (int i=0; i<User.Role.getAllRoles().size(); i++) {
                			int roleId = (int)Math.pow(2, i);
                			if ((authRequired.role() & roleId) > 0) {
                				if (user.isRole(roleId)) access = true;
                			}
                		}
                	}
                	if (access) {
                		request.setAttribute("loggedUser", user);
                		return true;
                	} else {
                		response.sendRedirect("authAccessError");
                		return false;
                	}
                } else {
          
                	String redirectUrl = request.getRequestURL().toString() + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
                	response.sendRedirect("authLogin?redirectUrl=" + URLEncoder.encode(redirectUrl, "UTF-8"));
                	return false;
                }
            }
        }
 		
        return true;
 		
	}
		
}
