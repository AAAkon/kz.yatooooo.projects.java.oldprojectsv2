package kz.iitu.javaee.labs.librarysystem.controllers;

import java.net.URLEncoder;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kz.iitu.javaee.labs.librarysystem.beans.UserBean;
import kz.iitu.javaee.labs.librarysystem.entities.User;
import kz.iitu.javaee.labs.librarysystem.utils.Utils;


@Controller
public class LoginController {
	
	@Autowired
	UserBean dbBean;
	
	public static final String DEFAULT_REDIRECT_URL = ".";
	
	@RequestMapping(value="/authLogin")
	public ModelAndView authLogin(HttpServletRequest request, HttpServletResponse response, String redirectUrl, String login, String loginResult) {
		
		User user = (User)request.getSession().getAttribute(Utils.SESSION_USER);
		if (user != null) {
			if (redirectUrl == null || redirectUrl.length() == 0) redirectUrl = DEFAULT_REDIRECT_URL;
			return new ModelAndView("redirect:" + redirectUrl);
		} else {
			ModelAndView view = new ModelAndView("auth/login");
			view.addObject("redirectUrl", redirectUrl);
			if (login != null) {
				view.addObject("login", login);
			} else {
				view.addObject("login", "");
			}
			view.addObject("loginResult", loginResult);
			return view;
		}
	}

	@RequestMapping(value="/authLoginDo", method=RequestMethod.POST)
	public ModelAndView authLoginDo(HttpServletRequest request, HttpServletResponse response, String login, String password, String redirectUrl, String access) {
		
		User user = null; 
		if (login != null && password != null) {
			user = dbBean.getUserByLogin(login);
		}
		if (user != null && user.checkPassword(password)) {
			request.getSession().setAttribute(Utils.SESSION_USER, user);
			if (redirectUrl == null || redirectUrl.length() == 0) redirectUrl = DEFAULT_REDIRECT_URL;
			ModelAndView view = new ModelAndView("redirect:" + redirectUrl);
			view.addObject("user", user);
			return view;
		} else if(access != null && access.equals("guest")){
        	redirectUrl = DEFAULT_REDIRECT_URL;
        	ModelAndView view = new ModelAndView("redirect:" + redirectUrl);
			view.addObject("user", new User());
			return view;
		} else {
			String url = "authLogin?";
			try {
				if (redirectUrl != null) url += "redirectUrl=" + URLEncoder.encode(redirectUrl, "UTF-8");
				if (login != null) url += "&login=" + URLEncoder.encode(login, "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
			url += "&loginResult=error";
			ModelAndView view = new ModelAndView("redirect:" + url);
			view.addObject("error","wrong_auth");
			return view;
		}
	}
	
	@RequestMapping(value="/authLogout")
	public ModelAndView authLogout(HttpServletRequest request) {
		
		request.getSession().removeAttribute(Utils.SESSION_USER);
		return new ModelAndView("redirect:authLogin");
	}
	
	@RequestMapping(value="/authAccessError")
	public ModelAndView authAccessError() {
		
		ModelAndView view = new ModelAndView("auth/accessError");
		view.addObject("url", DEFAULT_REDIRECT_URL);
		return view;
	}

}




