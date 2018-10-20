package kz.iitu.javaee.labs.librarysystem.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kz.iitu.javaee.labs.librarysystem.beans.UserBean;
import kz.iitu.javaee.labs.librarysystem.entities.User;
import kz.iitu.javaee.labs.librarysystem.utils.AuthRequired;

@Controller
public class HomeController {
		
	@AuthRequired()
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletRequest request) throws IOException{
		User user = (User)request.getAttribute("loggedUser");
		if(user != null){
			if (user.isAdmin())  
				return new ModelAndView("redirect:adminUsers");
			else if (user.isMember()) 
				return new ModelAndView("redirect:books");
			else
				return new ModelAndView("redirect:posts");
		}
		return new ModelAndView("redirect:authLogin");
	}
	
}
