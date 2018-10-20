package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.User;

/**
 * Servlet implementation class FindServlet
 */
@WebServlet("/find")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user = new User();
	
    public FindServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("fname", user.Find(id).getFname());
		request.setAttribute("lname", user.Find(id).getLname());	
		request.getRequestDispatcher("find.jsp").forward(request, response);
	}
}
