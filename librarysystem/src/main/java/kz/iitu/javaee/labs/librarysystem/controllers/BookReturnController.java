package kz.iitu.javaee.labs.librarysystem.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kz.iitu.javaee.labs.librarysystem.beans.BookBean;
import kz.iitu.javaee.labs.librarysystem.beans.BookReturnBean;
import kz.iitu.javaee.labs.librarysystem.entities.BookReturn;
import kz.iitu.javaee.labs.librarysystem.entities.User;
import kz.iitu.javaee.labs.librarysystem.utils.AuthRequired;
import kz.iitu.javaee.labs.librarysystem.utils.Utils;

@Controller
public class BookReturnController {
	
	@Autowired
	BookBean bookBean;
	
	@Autowired
	BookReturnBean bookReturnBean;
	
	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/adminBookReturns")
	public ModelAndView adminBookReturns() {
		
		List<BookReturn> bookReturns = bookReturnBean.getAllBookReturns();
		
		ModelAndView view = new ModelAndView("bookReturns/adminBookReturns");
		view.addObject("bookReturns", bookReturns);
		view.addObject("title", "Book returns");
		
		return view;
	}
	
	@AuthRequired(role=User.Role.ROLE_MEMBER)
	@RequestMapping(value="/memberBookReturns")
	public ModelAndView memberBookReturns(HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute(Utils.SESSION_USER);
		List<BookReturn> bookReturns = bookReturnBean.getBookReturnsOfUser(user);
		
		ModelAndView view = new ModelAndView("bookReturns/memberBookReturns");
		view.addObject("bookReturns", bookReturns);
		view.addObject("title", "My book returns");
		
		return view;
	}
		

	
	@AuthRequired(role=User.Role.ROLE_ADMIN+User.Role.ROLE_MEMBER)
	@RequestMapping(value="/seeBookReturn", method=RequestMethod.GET)
	public ModelAndView seeBookReturn(@RequestParam(value = "id") Long id, String redirectUrl) {
		
		BookReturn bookReturn = bookReturnBean.getBookReturnById(id);
	
		ModelAndView view = new ModelAndView("bookReturns/seeBookReturn");
		view.addObject("bookReturn", bookReturn);
		view.addObject("title", "Book return");
		view.addObject("redirectUrl", redirectUrl);
		
		return view;
		
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN+User.Role.ROLE_MEMBER)
	@RequestMapping(value="/changeBookReturnStatus", method=RequestMethod.POST)
	public ModelAndView changeBookReturnStatus(
			HttpServletRequest request, 
			String redirectUrl, 
			@RequestParam(value = "id") Long id, 
			@RequestParam(value = "newStatus") Integer newStatus) {
		
		BookReturn bookReturn = bookReturnBean.getBookReturnById(id);
		User user = (User) request.getSession().getAttribute(Utils.SESSION_USER);
		
		if(bookReturn != null && user != null){
			bookReturn.status = newStatus;
			bookReturnBean.updateBookReturn(bookReturn);
		}
	
		ModelAndView view = new ModelAndView("bookReturns/seeBookReturn");
		view.addObject("bookReturn", bookReturn);
		view.addObject("title", "Book return");
		view.addObject("status", "#saved");
		view.addObject("redirectUrl", redirectUrl);
		
		return view;

	}
		
}
