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


@WebServlet("/myprofile")
public class MyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserBean userbean = new UserBean();
    private ItemBean itembean = new ItemBean();
    private CategoryBean categorybean = new CategoryBean();   
	private List<UserBean> user;
	private List<CategoryBean> categories;
	private List<ItemBean> items;
	
    public MyProfileServlet() {
        super();
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		user = userbean.getUserById((int)request.getSession().getAttribute("userI"));
		request.setAttribute("user", user);
		
		categories = categorybean.getCategories();
		request.setAttribute("categories", categories);
		
		items = itembean.getItemByUserid((int)request.getSession().getAttribute("userI"));
		request.setAttribute("items", items);
		
		request.getRequestDispatcher("pages/authorized/myprofile.jsp").forward(request, response);
	}
	
}
