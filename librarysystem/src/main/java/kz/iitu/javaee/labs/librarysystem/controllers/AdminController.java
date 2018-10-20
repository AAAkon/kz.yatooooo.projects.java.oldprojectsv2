package kz.iitu.javaee.labs.librarysystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kz.iitu.javaee.labs.librarysystem.beans.BookBean;
import kz.iitu.javaee.labs.librarysystem.beans.UserBean;
import kz.iitu.javaee.labs.librarysystem.entities.User;
import kz.iitu.javaee.labs.librarysystem.utils.AuthRequired;

@Controller
public class AdminController {
	
	@Autowired
	UserBean dbBean;
	
	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/adminUsers")
	public ModelAndView adminUsers() {
		
		List<User> users = dbBean.getAllUsers();
		
		ModelAndView view = new ModelAndView("admin/users");
		view.addObject("users", users);
		view.addObject("title", "User management");
		
		return view;
	}

	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/adminEditUser", method=RequestMethod.GET)
	public ModelAndView adminEditUser(@RequestParam(value = "id") Long id) {
		
		User user = null;
		if (id != null) user = dbBean.getUserById(id);
		
		ModelAndView view = new ModelAndView("admin/editUser");
		view.addObject("user", user);
		view.addObject("allRoles", User.Role.getAllRoles());
		view.addObject("title", "Edit user");
		
		return view;
		
	}
	

	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/adminEditUser", method=RequestMethod.POST)
	public ModelAndView adminEditUser(
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "login") String login,
			@RequestParam(value = "name") String name, 
			@RequestParam(value = "password") String password, 
			@RequestParam(value = "repassword") String repassword, 
			@RequestParam(value = "roles") Integer[] roles) {
		
		User user = dbBean.getUserById(id);
		String status = null;
		
		if(user != null){

			user.login = login;
			user.name = name;
			user.role = 0;

			for (Integer role: roles){
				user.role += role;
			}
			
			if(user.role != 0){
				User testUser = dbBean.getUserByLogin(login);
				if (testUser == null || testUser.id == user.id) {
					
					if (password.equals(repassword)) {
						
						user.setPassword(password);
						dbBean.updateUser(user);
						status = "#saved";
					} else {
						status = "#password_error";
					}
				} else {
					status = "#login_exists";
				}
			}else{
				status = "#not_chosen";
			}
		}

		ModelAndView view = new ModelAndView("admin/editUser");
		view.addObject("user", user);
		view.addObject("status", status);
		view.addObject("allRoles", User.Role.getAllRoles());
		view.addObject("title", "Edit user");
			
		return view;
			
	}
	
	
	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/adminAddUser", method=RequestMethod.GET)
	public ModelAndView adminAddUser() {
		
		User user = new User();
		
		ModelAndView view = new ModelAndView("admin/addUser");
		view.addObject("user", user);
		view.addObject("allRoles", User.Role.getAllRoles());
		view.addObject("title", "New user");
		
		return view;
		
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/adminAddUser", method=RequestMethod.POST)
	public ModelAndView adminAddUser(
			@RequestParam(value = "login") String login,
			@RequestParam(value = "name") String name, 
			@RequestParam(value = "password") String password, 
			@RequestParam(value = "repassword") String repassword, 
			@RequestParam(value = "roles") Integer[] roles) {
		
		User user = new User();
		String status = null;
		
		user.login = login;
		user.name = name;
		user.role = 0;

		for (Integer role: roles){
			user.role += role;
		}
		
		if(user.role != 0){
			User testUser = dbBean.getUserByLogin(login);
			if (testUser == null || testUser.id == user.id) {
				
				if (password.equals(repassword)) {
					
					if(password.length() > 0) user.setPassword(password);
					dbBean.addUser(user);
					status = "#saved";
				} else {
					status = "#password_error";
				}
			} else {
				status = "#login_exists";
			}
		}else{
			status = "#not_chosen";
		}

		ModelAndView view = new ModelAndView("admin/addUser");
		view.addObject("user", user);
		view.addObject("status", status);
		view.addObject("allRoles", User.Role.getAllRoles());
		view.addObject("title", "New user");
		
		return view;
		
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/adminDeleteUser", method=RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam(value = "id") Long id) {
		
		User user = null;
		if (id != null) user = dbBean.getUserById(id);
		
		ModelAndView view = new ModelAndView("admin/deleteUser");
		view.addObject("user", user);
		
		return view;
	}

	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/adminDeleteUser", method=RequestMethod.POST)
	public ModelAndView deleteUser(@RequestParam(value = "id") Long id, @RequestParam(value = "remove") String remove) {
		
		User user = null;
		if (id != null) user = dbBean.getUserById(id);
		
		ModelAndView view = new ModelAndView("admin/deleteUser");
		view.addObject("user", user);
		view.addObject("status", "#removed");
		
		dbBean.deleteUser(user.id);
		
		return view;
	}

}
