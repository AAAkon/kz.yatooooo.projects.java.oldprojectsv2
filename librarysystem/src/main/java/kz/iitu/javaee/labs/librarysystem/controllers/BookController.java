package kz.iitu.javaee.labs.librarysystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kz.iitu.javaee.labs.librarysystem.beans.BookBean;
import kz.iitu.javaee.labs.librarysystem.beans.UserBean;
import kz.iitu.javaee.labs.librarysystem.entities.Book;
import kz.iitu.javaee.labs.librarysystem.entities.User;
import kz.iitu.javaee.labs.librarysystem.utils.AuthRequired;

@Controller
public class BookController {
	
	@Autowired
	BookBean bookBean;

	@AuthRequired(role=User.Role.ROLE_ADMIN+User.Role.ROLE_MEMBER)
	@RequestMapping(value="/books")
	public ModelAndView books() {
		
		List<Book> books = bookBean.getAllBooks();
		
		ModelAndView view = new ModelAndView("books/books");
		view.addObject("books", books);
		view.addObject("title", "Book list");
		
		return view;
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN+User.Role.ROLE_MEMBER)
	@RequestMapping(value="/seeBook", method=RequestMethod.GET)
	public ModelAndView seeBook(@RequestParam(value = "id") Long id) {
		
		Book book = bookBean.getBookById(id);
		
		ModelAndView view = new ModelAndView("books/seeBook");
		view.addObject("book", book);
		view.addObject("title", "Book info");
		
		return view;
		
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/addBook", method=RequestMethod.GET)
	public ModelAndView addBook() {
		
		Book book = new Book();
		
		ModelAndView view = new ModelAndView("books/addBook");
		view.addObject("book", book);
		view.addObject("title", "New book");
		
		return view;
		
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/addBook", method=RequestMethod.POST)
	public ModelAndView addBook(
			@RequestParam(value = "name") String name, 
			@RequestParam(value = "author") String author, 
			@RequestParam(value = "edition") String edition, 
			@RequestParam(value = "stock") String stock) {
		
		Book book = new Book();
		book.name = name;
		book.author = author;
		book.edition = edition;
		book.stock = stock;
		
		bookBean.addBook(book);
		
		ModelAndView view = new ModelAndView("books/editBook");
		view.addObject("book", book);
		view.addObject("status", "#saved");
		view.addObject("allRoles", User.Role.getAllRoles());
		view.addObject("title", "New book");
			
		return view;
			
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/editBook", method=RequestMethod.GET)
	public ModelAndView editBook(@RequestParam(value = "id") Long id) {
		
		Book book = bookBean.getBookById(id);
		
		ModelAndView view = new ModelAndView("books/editBook");
		view.addObject("book", book);
		view.addObject("title", "Edit book");
		
		return view;
		
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/editBook", method=RequestMethod.POST)
	public ModelAndView editBook(
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "name") String name, 
			@RequestParam(value = "author") String author, 
			@RequestParam(value = "edition") String edition, 
			@RequestParam(value = "stock") String stock) {
		
		Book book = bookBean.getBookById(id);
		
		if(book != null){
			
			book.name = name;
			book.author = author;
			book.edition = edition;
			book.stock = stock;
			
			bookBean.updateBook(book);
		}
		
		
		ModelAndView view = new ModelAndView("books/editBook");
		view.addObject("book", book);
		view.addObject("status", "#saved");
		view.addObject("title", "Edit book");
			
		return view;
			
	}
	
	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/deleteBook", method=RequestMethod.GET)
	public ModelAndView deleteBook(@RequestParam(value = "id") Long id) {
		
		Book book = null;
		if (id != null) book = bookBean.getBookById(id);
		
		ModelAndView view = new ModelAndView("books/deleteBook");
		view.addObject("book", book);
		
		return view;
	}

	@AuthRequired(role=User.Role.ROLE_ADMIN)
	@RequestMapping(value="/deleteBook", method=RequestMethod.POST)
	public ModelAndView deleteBook(@RequestParam(value = "id") Long id, @RequestParam(value = "remove") String remove) {
		
		Book book = null;
		if (id != null) book = bookBean.getBookById(id);
		
		ModelAndView view = new ModelAndView("books/deleteBook");
		view.addObject("book", book);
		view.addObject("status", "#removed");
		
		bookBean.deleteBook(book.id);
		
		return view;
	}
	
}
