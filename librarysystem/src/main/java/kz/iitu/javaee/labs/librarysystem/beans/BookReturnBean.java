package kz.iitu.javaee.labs.librarysystem.beans;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import kz.iitu.javaee.labs.librarysystem.entities.BookReturn;
import kz.iitu.javaee.labs.librarysystem.entities.User;

import java.util.List;

public class BookReturnBean {
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<BookReturn> getAllBookReturns() {
		try{
			Session session = sessionFactory.getCurrentSession();
			List<BookReturn> bookReturns = (List<BookReturn>) session.createCriteria(BookReturn.class).list();
			return bookReturns;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<BookReturn> getBookReturnsOfUser(User user) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(BookReturn.class);
			cr.add(Restrictions.eq("user", user));
			List<BookReturn> bookReturns = cr.list(); 
			return bookReturns;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public void addBookReturn(BookReturn bookReturn) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.persist(bookReturn);
			session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Transactional
	public BookReturn getBookReturnById(Long id){
		try{
			Session session = sessionFactory.getCurrentSession();
			BookReturn bookReturn  = (BookReturn)session.get(BookReturn.class,id);
		    if(bookReturn!=null) return (BookReturn) bookReturn;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public void updateBookReturn(BookReturn bookReturn){
		try{
			Session session = sessionFactory.getCurrentSession();
		    session.saveOrUpdate(bookReturn);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Transactional
	public void deleteBookReturn(Long id){
	    try{
	    	Session session = sessionFactory.getCurrentSession();
	    	BookReturn bookReturn  = (BookReturn)session.load(BookReturn.class,id);
	 	    if(bookReturn!=null) session.delete(bookReturn);
	 	    session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
