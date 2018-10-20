package kz.iitu.javaee.labs.librarysystem.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import kz.iitu.javaee.labs.librarysystem.beans.UserBean;
import kz.iitu.javaee.labs.librarysystem.entities.User;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserBean dbBean;
	
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		if (dbBean.getAllUsers().size() == 0) {
			User user = new User();
			user.login = "admin";
			user.setPassword("123");
			user.name = "Zhandos Ainabek";
			user.role = User.Role.ROLE_ADMIN;
			dbBean.addUser(user);
		}
	}
	
}
