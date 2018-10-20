package kz.iitu.javaee.labs.librarysystem.beans;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import kz.iitu.javaee.labs.librarysystem.entities.Book;
import kz.iitu.javaee.labs.librarysystem.entities.User;

import java.util.Iterator;
import java.util.List;

public class UserBean {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<User> getAllUsers(){
		try{
			Session session = sessionFactory.getCurrentSession();
			List<User> users = (List<User>) session.createCriteria(User.class).list();
			return users;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public void addUser(User user) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.persist(user);
			session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void deleteUser(Long id){
	    try{
	    	Session session = sessionFactory.getCurrentSession();
	 	    User user  = (User)session.load(User.class,id);
	 	    if(user!=null) session.delete(user);
	 	    session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Transactional
	public User getUserById(Long id){
		try{
			Session session = sessionFactory.getCurrentSession();
			User user  = (User)session.get(User.class,id);
		    if(user!=null) return (User) user;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public User getUserByLogin(String login){
		try{
			Session session = sessionFactory.getCurrentSession();
	        Criteria cr = session.createCriteria(User.class);
	        cr.add(Restrictions.eq("login", login));
	        List<User> users = cr.list(); 
		    if(users.size() > 0) return (User)users.get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public void updateUser(User user){
		try{
			Session session = sessionFactory.getCurrentSession();
		    session.saveOrUpdate(user);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
