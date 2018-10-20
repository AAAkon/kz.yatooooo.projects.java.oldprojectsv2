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


@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemBean itembean = new ItemBean();
	private UserBean userbean = new UserBean();
	private CategoryBean categorybean = new CategoryBean();
	
    public HomeServlet() {
        super(); 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		BASKET FOR THE NEXT PROJECT
//		if(request.getSession().getAttribute("item-count-in-basket")==null){
//			request.getSession().setAttribute("item-count-in-basket", 0);
//		}
		if (request.getParameterMap().containsKey("categoryname") && request.getParameterMap().containsKey("keyword")) {
			String categoryname = request.getParameter("categoryname");
			String keyword = request.getParameter("keyword");
			
			List<CategoryBean> categories = categorybean.getCategories();
			request.setAttribute("categories", categories);

			if(keyword.equals("") && categoryname.equals("")){
				
				List<ItemBean> items = itembean.getItems();
				request.setAttribute("items", items);
				
			}else if(keyword.equals("") && !categoryname.equals("")){
				
				List<ItemBean> items = itembean.getItemByCategory(categoryname);
				request.setAttribute("items", items);
			}else if(!keyword.equals("") && categoryname.equals("")){
				
				List<ItemBean> items = itembean.getItemByKeyword(keyword);
				request.setAttribute("items", items);
			}else if(!keyword.equals("") && !categoryname.equals("")){
				
				List<ItemBean> items = itembean.getItemByCategoryAndKeyword(categoryname, keyword);
				request.setAttribute("items", items);
			}else{
				
			}
        }else{
        	List<CategoryBean> categories = categorybean.getCategories();
			request.setAttribute("categories", categories);
			
			List<ItemBean> items = itembean.getItems();
			request.setAttribute("items", items);
        }
		
		request.getRequestDispatcher("/home.jsp").forward(request, response);   
	}
}
