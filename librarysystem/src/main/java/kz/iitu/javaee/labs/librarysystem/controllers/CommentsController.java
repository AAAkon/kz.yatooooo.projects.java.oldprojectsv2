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
import kz.iitu.javaee.labs.librarysystem.beans.CommentBean;
import kz.iitu.javaee.labs.librarysystem.beans.PostBean;
import kz.iitu.javaee.labs.librarysystem.beans.UserBean;
import kz.iitu.javaee.labs.librarysystem.entities.Book;
import kz.iitu.javaee.labs.librarysystem.entities.Comment;
import kz.iitu.javaee.labs.librarysystem.entities.Post;
import kz.iitu.javaee.labs.librarysystem.entities.User;
import kz.iitu.javaee.labs.librarysystem.utils.AuthRequired;
import kz.iitu.javaee.labs.librarysystem.utils.Utils;

@Controller
public class CommentsController {
	
	@Autowired
	CommentBean commentsBean;
	
	@Autowired
	PostBean postBean;

	@AuthRequired(role=User.Role.ROLE_ADMIN+User.Role.ROLE_MEMBER)
	@RequestMapping(value="/addComment", method=RequestMethod.POST)
	public ModelAndView addComment(
			HttpServletRequest request, 
			Long post_id,
			@RequestParam(value = "text") String text) {
		
		User user = (User) request.getSession().getAttribute(Utils.SESSION_USER);
		Post post = postBean.getPostById(post_id);
		Comment comment = null;
		
		if(user != null && post != null){
			
			comment = new Comment();
			comment.text = text;
			comment.user = user;
			comment.post = post;
			comment.date = new Timestamp(System.currentTimeMillis());
			
			commentsBean.addComment(comment);
		}
			
		return new ModelAndView("redirect:posts");
			
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN+User.Role.ROLE_MEMBER)
	@RequestMapping(value="/editComment", method=RequestMethod.GET)
	public ModelAndView editComment(@RequestParam(value = "id") Long id) {
		
		Comment comment = commentsBean.getCommentById(id);
		ModelAndView view = new ModelAndView("comments/editComment");
		if(comment != null){
			view.addObject("comment", comment);
		}
			
		return view;
			
	}

	@AuthRequired(role=User.Role.ROLE_ADMIN+User.Role.ROLE_MEMBER)
	@RequestMapping(value="/editComment", method=RequestMethod.POST)
	public ModelAndView editComment(
			HttpServletRequest request,
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "text") String text) {
		
		User user = (User) request.getSession().getAttribute(Utils.SESSION_USER);
		Comment comment = commentsBean.getCommentById(id);
		
		if(comment != null && user != null && comment.user.id == user.id){
			
			comment.text = text;
			comment.date = new Timestamp(System.currentTimeMillis());
			
			commentsBean.updateComment(comment);
			
		}
		
		return new ModelAndView("redirect:posts");
			 
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/deleteComment", method=RequestMethod.GET)
	public ModelAndView deleteComment(@RequestParam(value = "id") Long id) {
		
		Comment comment = null;
		if (id != null) comment = commentsBean.getCommentById(id);
				
		commentsBean.deleteComment(comment.id);
		return new ModelAndView("redirect:posts");
	}
}
