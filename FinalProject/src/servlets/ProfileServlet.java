package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoryBean;
import beans.UserBean;


@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBean userbean = new UserBean();   
	private List<UserBean> user;
    
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		user = userbean.getUserById(user_id);
		request.setAttribute("user", user);
		System.out.print(user_id);
		request.getRequestDispatcher("pages/authorized/profile.jsp").forward(request, response);
	}

}
