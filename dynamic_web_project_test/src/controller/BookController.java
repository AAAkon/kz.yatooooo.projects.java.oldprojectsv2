package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;

@WebServlet("/books")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDao = new BookDao();
		request.setAttribute("books", bookDao.getAllBooks());
		bookDao.close();
		request.getRequestDispatcher("book.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDao = new BookDao();
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String page_number = request.getParameter("page_number");
		String date = request.getParameter("date");
		bookDao.add(name, author, page_number, date);
		doGet(request, response);
	}

}
