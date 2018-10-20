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

public class BookBean {
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<Book> getAllBooks() {
		try{
			Session session = sessionFactory.getCurrentSession();
			List<Book> books = (List<Book>) session.createCriteria(Book.class).list();
			return books;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public void addBook(Book book) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.persist(book);
			session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Transactional
	public Book getBookById(Long id){
		try{
			Session session = sessionFactory.getCurrentSession();
			Book book  = (Book)session.get(Book.class,id);
		    if(book!=null) return (Book) book;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public void updateBook(Book book){
		try{
			Session session = sessionFactory.getCurrentSession();
		    session.saveOrUpdate(book);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Transactional
	public void deleteBook(Long id){
	    try{
	    	Session session = sessionFactory.getCurrentSession();
	    	Book book  = (Book)session.load(Book.class,id);
	 	    if(book!=null) session.delete(book);
	 	    session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
