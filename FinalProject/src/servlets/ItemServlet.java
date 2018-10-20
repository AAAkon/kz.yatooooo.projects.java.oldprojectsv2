package servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.CategoryBean;
import beans.ItemBean;
import beans.UserBean;

@WebServlet("/item")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "images\\items";
	private ItemBean itembean = new ItemBean();
	private UserBean userbean = new UserBean();
	private CategoryBean categorybean = new CategoryBean();
	
    public ItemServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("details")){
			
			int item_id = Integer.parseInt(request.getParameter("item_id"));
			List<ItemBean> items = itembean.getItemById(item_id);
			request.setAttribute("items", items);
			
			if(request.getSession().getAttribute("userN")!=null && request.getSession().getAttribute("userI")!=null){ 
				request.getRequestDispatcher("pages/authorized/item.jsp").forward(request, response); 
			}else{
				request.getRequestDispatcher("pages/guest/item.jsp").forward(request, response); 
			}
		}else if(action.equals("GoToBuy")){
			
			int item_id = Integer.parseInt(request.getParameter("item_id"));
			List<ItemBean> items = itembean.getItemById(item_id);
			request.setAttribute("items", items);
			request.getRequestDispatcher("pages/authorized/item-buy.jsp").forward(request, response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("additem")){
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			int amount = Integer.parseInt(request.getParameter("amount"));
			int price = Integer.parseInt(request.getParameter("price"));
			int user_id = (int) request.getSession().getAttribute("userI");
			String user_name = userbean.GetUsernameByID(user_id);
			String categoryname = request.getParameter("categorynameselect");
			
			if(categoryname.equals("other")){
				categoryname = request.getParameter("categorynameinput");
				categorybean.AddCategory(categoryname);
			}
			
			
	        String appPath = request.getServletContext().getRealPath("");
	        String savePath = appPath + File.separator + SAVE_DIR;
            File fileSaveDir=new File(savePath);
            if(!fileSaveDir.exists()){
                fileSaveDir.mkdir();
            }
            
            
	        Part part=request.getPart("image2");
	        String fileName="item"+System.currentTimeMillis()+".png";
	        part.write(savePath + File.separator + fileName);
	        part.write("O:\\workspace\\eclipse\\FinalProject\\WebContent\\images\\items\\" +File.separator+ fileName);
	        String filePath= "images/items/" + fileName;
			
	        itembean.AddItem(name, description, filePath, price, amount, categoryname, user_name, user_id);
	        

	        System.out.println(savePath + File.separator + fileName);
	        
	        response.sendRedirect("myprofile");
	        
		}else if(action.equals("buy")){
			int id = Integer.parseInt(request.getParameter("id"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			
			List<ItemBean> items = itembean.getItemById(id);
			int max_amount = items.get(0).getAmount();
			int money = items.get(0).getPrice() * amount;
			int user_id = items.get(0).getUser_id();
			
			if(amount>0 && amount<=max_amount){
				itembean.Buy(id,amount);
				userbean.Buy(user_id, money);
			}
			
			response.sendRedirect("myprofile");
		}else if(action.equals("delete")){
			int item_id = Integer.parseInt(request.getParameter("item_id"));
			System.out.println("id: "+item_id);
			itembean.DeleteItem(item_id);
			response.sendRedirect("myprofile");
		}
			
//		if(action.equals("AddToBasket")){
//			
//			int id = Integer.parseInt(request.getParameter("id"));
//			int amount = Integer.parseInt(request.getParameter("amount"));
//			int item_count_in_basket = (int)request.getSession().getAttribute("item-count-in-basket");
//			
//			if(request.getSession().getAttribute(item_count_in_basket+"-item-id")==null && request.getSession().getAttribute(item_count_in_basket+"-item-amount")==null){
//				
//				System.out.println(" null null ");
//				System.out.println("id - "+id);
//				System.out.println("amount - "+amount);
//				System.out.println("item-count - "+item_count_in_basket);
//				
//				item_count_in_basket++;
//				request.getSession().setAttribute("item-count-in-basket", item_count_in_basket);
//				request.getSession().setAttribute(item_count_in_basket+"-item-id",id);
//				request.getSession().setAttribute(item_count_in_basket+"-item-amount",amount);
//			}else if(request.getSession().getAttribute(item_count_in_basket+"-item-id")!=null && request.getSession().getAttribute(item_count_in_basket+"-item-amount")!=null && (int)request.getSession().getAttribute(item_count_in_basket+"-item-amount")!=amount){
//				
//				System.out.println("not null   not null not equals");
//				request.getSession().setAttribute(item_count_in_basket+"-item-amount",amount);
//			}else{
//				
//			}
//						
//			response.sendRedirect("pages/authorized/item.jsp?action=details&item_id="+request.getParameter("id"));
//		
//		}
		
		
	}


	private int IntegerParseInt(String parameter) {
		// TODO Auto-generated method stub
		return 0;
	}
}
