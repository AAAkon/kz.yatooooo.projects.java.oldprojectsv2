package kz.iitu.javaee.labs.librarysystem.beans;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import kz.iitu.javaee.labs.librarysystem.entities.BookRequest;
import kz.iitu.javaee.labs.librarysystem.entities.User;

import java.util.List;

public class BookRequestBean {
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<BookRequest> getAllBookRequests() {
		try{
			Session session = sessionFactory.getCurrentSession();
			List<BookRequest> bookRequests = (List<BookRequest>) session.createCriteria(BookRequest.class).list();
			return bookRequests;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<BookRequest> getBookRequestsOfUser(User user) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(BookRequest.class);
			cr.add(Restrictions.eq("user", user));
			List<BookRequest> bookRequests = cr.list(); 
			return bookRequests;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public void addBookRequest(BookRequest bookRequest) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.persist(bookRequest);
			session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Transactional
	public BookRequest getBookRequestById(Long id){
		try{
			Session session = sessionFactory.getCurrentSession();
			BookRequest bookRequest  = (BookRequest)session.get(BookRequest.class,id);
		    if(bookRequest!=null) return (BookRequest) bookRequest;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public void updateBookRequest(BookRequest bookRequest){
		try{
			Session session = sessionFactory.getCurrentSession();
		    session.saveOrUpdate(bookRequest);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
//
//	@Transactional
//	public void deleteBook(Long id){
//	    try{
//	    	Session session = sessionFactory.getCurrentSession();
//	    	Book book  = (Book)session.load(Book.class,id);
//	 	    if(book!=null) session.delete(book);
//	 	    session.flush();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
}
