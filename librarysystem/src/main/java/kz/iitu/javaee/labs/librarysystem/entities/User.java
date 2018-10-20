package kz.iitu.javaee.labs.librarysystem.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import kz.iitu.javaee.labs.librarysystem.utils.Utils;

@Entity
public class User {
	
	/********** FIELDS **********/
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	public Long id;
	
	public String login;
	public String password;
	public String name;
	public String address;
	public String city;
	public String phone;
	public String email;
	public int role;
	
	/********** GETTERS AND SETTERS **********/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}

	/********** ROLE CLASS **********/
	
	public static class Role {
		
		public static final int ROLE_ADMIN = 1;
		public static final int ROLE_MEMBER = 2;
		
		public int id;
		public String name;
		
		public int getId(){
			return id;
		}
		public String getName(){
			return name;
		}
		
		public static List<Role> getAllRoles() {
			
			ArrayList<User.Role> roles = new ArrayList<User.Role>();
			
			Role role = new Role();
			role.id = ROLE_ADMIN;
			role.name = "Admin";
			roles.add(role);

			role = new Role();
			role.id = ROLE_MEMBER;
			role.name = "Member";
			roles.add(role);
						
			return roles;
		}	
	}
	
	public boolean isRole(int constRole){
		if((role&constRole)==constRole)
			return true;
		else
			return false;
	}
	public List<Role> getRoles() {
		List<Role> allRoles = Role.getAllRoles();
		ArrayList<Role> roles = new ArrayList<Role>();
		for(Role role: allRoles) {
			if (isRole(role.id)) roles.add(role);
		}
		return roles; 
		
	}
	
	public boolean isAdmin() {
		return isRole(Role.ROLE_ADMIN);
	}
	
	public boolean isMember() {
		return isRole(Role.ROLE_MEMBER);
	}
	
	/********** SPECIFIC METHODS **********/
		
	public boolean checkPassword(String password) {
		return this.password.equals(Utils.getMD5Hash(password));
	}	
	
	public void setPassword(String password) {
		this.password = Utils.getMD5Hash(password);
	}
}
