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
import kz.iitu.javaee.labs.librarysystem.beans.BookRequestBean;
import kz.iitu.javaee.labs.librarysystem.beans.BookReturnBean;
import kz.iitu.javaee.labs.librarysystem.entities.Book;
import kz.iitu.javaee.labs.librarysystem.entities.BookRequest;
import kz.iitu.javaee.labs.librarysystem.entities.BookReturn;
import kz.iitu.javaee.labs.librarysystem.entities.User;
import kz.iitu.javaee.labs.librarysystem.utils.AuthRequired;
import kz.iitu.javaee.labs.librarysystem.utils.Utils;

@Controller
public class BookRequestController {
	
	@Autowired
	BookBean bookBean;
	
	@Autowired
	BookRequestBean bookRequestBean;
	
	@Autowired
	BookReturnBean bookReturnBean;
	
	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/adminBookRequests")
	public ModelAndView adminBookRequests() {
		
		List<BookRequest> bookRequests = bookRequestBean.getAllBookRequests();
		
		ModelAndView view = new ModelAndView("bookRequests/adminBookRequests");
		view.addObject("bookRequests", bookRequests);
		view.addObject("title", "Book requests");
		
		return view;
	}
	
	@AuthRequired(role=User.Role.ROLE_MEMBER)
	@RequestMapping(value="/memberBookRequests")
	public ModelAndView memberBookRequests(HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute(Utils.SESSION_USER);
		List<BookRequest> bookRequests = bookRequestBean.getBookRequestsOfUser(user);
		
		ModelAndView view = new ModelAndView("bookRequests/memberBookRequests");
		view.addObject("bookRequests", bookRequests);
		view.addObject("title", "My book requests");
		
		return view;
	}
		
	@AuthRequired(role=User.Role.ROLE_MEMBER)
	@RequestMapping(value="/sendBookRequest", method=RequestMethod.GET)
	public ModelAndView sendBookRequest(HttpServletRequest request, @RequestParam(value = "bookId") Long bookId) {
		
		Book book = bookBean.getBookById(bookId);
		User user = (User) request.getSession().getAttribute(Utils.SESSION_USER);
		
		if(book != null && user != null){
			BookRequest bookRequest = new BookRequest();
			bookRequest.user = user;
			bookRequest.book = book;
			bookRequest.date = new Timestamp(System.currentTimeMillis());
			bookRequest.status = BookRequest.STATUS_PENDING;
			bookRequestBean.addBookRequest(bookRequest);
		}
		
		ModelAndView view = new ModelAndView("books/seeBook");
		view.addObject("book", book);
		view.addObject("status", "#saved");
		view.addObject("title", "Send book request");
		
		return view;
		
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN+User.Role.ROLE_MEMBER)
	@RequestMapping(value="/seeBookRequest", method=RequestMethod.GET)
	public ModelAndView seeBookRequest(@RequestParam(value = "id") Long id, String redirectUrl) {
		
		BookRequest bookRequest = bookRequestBean.getBookRequestById(id);
	
		ModelAndView view = new ModelAndView("bookRequests/seeBookRequest");
		view.addObject("bookRequest", bookRequest);
		view.addObject("title", "Book request");
		view.addObject("redirectUrl", redirectUrl);
		
		return view;
		
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN+User.Role.ROLE_MEMBER)
	@RequestMapping(value="/changeBookRequestStatus", method=RequestMethod.POST)
	public ModelAndView changeBookRequestStatus(
			HttpServletRequest request, 
			String redirectUrl, String date,
			@RequestParam(value = "id") Long id, 
			@RequestParam(value = "newStatus") Integer newStatus) {
		
		BookRequest bookRequest = bookRequestBean.getBookRequestById(id);
		User user = (User) request.getSession().getAttribute(Utils.SESSION_USER);
		
		if(bookRequest != null && user != null){
			bookRequest.status = newStatus;
			bookRequestBean.updateBookRequest(bookRequest);
			
			if(newStatus == BookRequest.STATUS_ACCEPTED){
				BookReturn bookReturn = new BookReturn();
				bookReturn.book = bookRequest.getBook();
				bookReturn.user = bookRequest.getUser();
				bookReturn.date = Utils.dateTimeTimestampFromString(date);
				bookReturn.status = BookReturn.STATUS_PENDING;
				bookReturnBean.addBookReturn(bookReturn);
			}
		}
	
		ModelAndView view = new ModelAndView("bookRequests/seeBookRequest");
		view.addObject("bookRequest", bookRequest);
		view.addObject("title", "Book request");
		view.addObject("status", "#saved");
		view.addObject("redirectUrl", redirectUrl);
		
		return view;

	}
		
}
