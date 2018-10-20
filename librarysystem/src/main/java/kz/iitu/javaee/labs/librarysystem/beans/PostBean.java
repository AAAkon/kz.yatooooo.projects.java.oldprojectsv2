package kz.iitu.javaee.labs.librarysystem.beans;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import kz.iitu.javaee.labs.librarysystem.entities.Post;

import java.util.List;

public class PostBean {
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<Post> getAllPosts() {
		try{
			Session session = sessionFactory.getCurrentSession();
			List<Post> posts = (List<Post>) session.createCriteria(Post.class).list();
			
			for(Post post: posts){
				post.comments.size();
			}
			
			return posts;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public void addPost(Post post) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.persist(post);
			session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Transactional
	public Post getPostById(Long id){
		try{
			Session session = sessionFactory.getCurrentSession();
			Post post = (Post)session.get(Post.class,id);
		    if(post!=null) return (Post) post;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public void updatePost(Post post){
		try{
			Session session = sessionFactory.getCurrentSession();
		    session.saveOrUpdate(post);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Transactional
	public void deletePost(Long id){
	    try{
	    	Session session = sessionFactory.getCurrentSession();
	    	Post post  = (Post)session.load(Post.class,id);
	 	    if(post!=null) session.delete(post);
	 	    session.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
