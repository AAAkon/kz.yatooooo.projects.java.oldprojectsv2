package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoryBean;
import beans.ItemBean;
import beans.UserBean;


@WebServlet("/users")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBean userbean = new UserBean();  
	private List<UserBean> users;
  
    public UsersServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterMap().containsKey("keyword")){
			if(request.getParameter("keyword").equals("")){
				users = userbean.getUsers();
				request.setAttribute("users", users);
			}else{
				users = userbean.getUsers(request.getParameter("keyword"));
				request.setAttribute("users", users);
			}
		}else{
			users = userbean.getUsers();
			request.setAttribute("users", users);
		}
		
		request.getRequestDispatcher("pages/authorized/users.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		users = userbean.getUsers();
		request.setAttribute("users", users);
		
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		int value = Integer.parseInt(request.getParameter("value"));
		
		if(action.equals("admin")){
			userbean.admin(value, id);
		}else if(action.equals("right")){
			userbean.right(value, id);
		}else if(action.equals("delete")){
			userbean.delete(value, id);
		}
		
		response.sendRedirect("users");
	}

}
