package kz.iitu.javaee.labs.librarysystem.beans;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import kz.iitu.javaee.labs.librarysystem.entities.Comment;

import java.util.List;

public class CommentBean {
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<Comment> getAllComments() {
		try{
			Session session = sessionFactory.getCurrentSession();
			List<Comment> comments = (List<Comment>) session.createCriteria(Comment.class).list();
			return comments;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public void addComment(Comment comment) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.persist(comment);
			session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Transactional
	public Comment getCommentById(Long id){
		try{
			Session session = sessionFactory.getCurrentSession();
			Comment comment = (Comment)session.get(Comment.class,id);
		    if(comment!=null) return (Comment) comment;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public void updateComment(Comment comment){
		try{
			Session session = sessionFactory.getCurrentSession();
		    session.saveOrUpdate(comment);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Transactional
	public void deleteComment(Long id){
	    try{
	    	Session session = sessionFactory.getCurrentSession();
	    	Comment comment  = (Comment)session.load(Comment.class,id);
	 	    if(comment!=null) session.delete(comment);
	 	    session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
