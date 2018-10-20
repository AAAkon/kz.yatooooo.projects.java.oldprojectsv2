package kz.iitu.javaee.labs.librarysystem.controllers;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kz.iitu.javaee.labs.librarysystem.beans.BookBean;
import kz.iitu.javaee.labs.librarysystem.beans.PostBean;
import kz.iitu.javaee.labs.librarysystem.beans.UserBean;
import kz.iitu.javaee.labs.librarysystem.entities.Book;
import kz.iitu.javaee.labs.librarysystem.entities.Post;
import kz.iitu.javaee.labs.librarysystem.entities.User;
import kz.iitu.javaee.labs.librarysystem.utils.AuthRequired;
import kz.iitu.javaee.labs.librarysystem.utils.Utils;

@Controller
public class PostController {
	
	@Autowired
	PostBean postBean;
	
	@RequestMapping(value="/posts")
	public ModelAndView posts(HttpServletRequest request) {
		
		List<Post> posts = postBean.getAllPosts();
		User user = (User) request.getSession().getAttribute(Utils.SESSION_USER);
		
		ModelAndView view = new ModelAndView("posts/posts");
		view.addObject("posts", posts);
		view.addObject("title", "Discussion board");
		view.addObject("loggedUser", user);
		
		return view;
	}
//	
//	@AuthRequired(role=User.Role.ROLE_ADMIN+User.Role.ROLE_MEMBER)
//	@RequestMapping(value="/seeBook", method=RequestMethod.GET)
//	public ModelAndView seeBook(@RequestParam(value = "id") Long id) {
//		
//		Book book = bookBean.getBookById(id);
//		
//		ModelAndView view = new ModelAndView("posts/seeBook");
//		view.addObject("book", book);
//		view.addObject("title", "Book info");
//		
//		return view;
//		
//	}
//	
	@AuthRequired(role=User.Role.ROLE_ADMIN+User.Role.ROLE_MEMBER)
	@RequestMapping(value="/addPost", method=RequestMethod.GET)
	public ModelAndView addPost() {
		
		Post post = new Post();
		
		ModelAndView view = new ModelAndView("posts/addPost");
		view.addObject("post", post);
		view.addObject("title", "New post");
		
		
		return view;
		
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN+User.Role.ROLE_MEMBER)
	@RequestMapping(value="/addPost", method=RequestMethod.POST)
	public ModelAndView addPost(
			HttpServletRequest request,
			@RequestParam(value = "title") String title, 
			@RequestParam(value = "text") String text) {
		
		User user = (User) request.getSession().getAttribute(Utils.SESSION_USER);
		Post post = null;
		
		if(user != null){
			
			post = new Post();
			post.title = title;
			post.text = text;
			post.user = user;
			post.likesAmount = 0;
			post.date = new Timestamp(System.currentTimeMillis());
			
			postBean.addPost(post);
		}
				
		ModelAndView view = new ModelAndView("posts/addPost");
		view.addObject("post", post);
		view.addObject("status", "#saved");
		view.addObject("title", "New post");
			
		return view;
			
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN+User.Role.ROLE_MEMBER)
	@RequestMapping(value="/editPost", method=RequestMethod.GET)
	public ModelAndView editPost(@RequestParam(value = "id") Long id) {
		
		Post post = postBean.getPostById(id);
		
		ModelAndView view = new ModelAndView("posts/editPost");
		view.addObject("post", post);
		view.addObject("title", "Edit post");
		
		return view;
		
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN+User.Role.ROLE_MEMBER)
	@RequestMapping(value="/editPost", method=RequestMethod.POST)
	public ModelAndView editPost(
			HttpServletRequest request,
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "title") String title, 
			@RequestParam(value = "text") String text) {
		
		ModelAndView view = new ModelAndView("posts/editPost");
		User user = (User) request.getSession().getAttribute(Utils.SESSION_USER);
		Post post = postBean.getPostById(id);
		
		if(post != null && user != null && post.user.id == user.id){
			
			post.title = title;
			post.text = text;
			post.date = new Timestamp(System.currentTimeMillis());
			
			postBean.updatePost(post);
			view.addObject("status", "#saved");
			
		}else{
			view.addObject("status", "#error");
		}
		
		view.addObject("post", post);
		view.addObject("title", "Edit post");
			
		return view;
			
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/deletePost", method=RequestMethod.GET)
	public ModelAndView deletePost(@RequestParam(value = "id") Long id) {
		
		Post post = null;
		if (id != null) post = postBean.getPostById(id);
		
		ModelAndView view = new ModelAndView("posts/deletePost");
		view.addObject("post", post);
		
		return view;
	}

	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/deletePost", method=RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam(value = "id") Long id, @RequestParam(value = "remove") String remove) {
		
		Post post = null;
		if (id != null) post = postBean.getPostById(id);
		
		ModelAndView view = new ModelAndView("posts/deletePost");
		view.addObject("post", post);
		view.addObject("status", "#removed");
		
		postBean.deletePost(post.id);
		
		return view;
	}
	
}
