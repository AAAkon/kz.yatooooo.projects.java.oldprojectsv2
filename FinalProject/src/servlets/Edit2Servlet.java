package servlets;

import java.io.File;
import java.io.IOException;
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


@WebServlet("/edit2")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)

public class Edit2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "images\\items";
	private ItemBean itembean = new ItemBean();
	private UserBean userbean = new UserBean();
	private CategoryBean categorybean = new CategoryBean();
   
    public Edit2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
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
        
        
        Part part=request.getPart("image3");
        String fileName="item"+System.currentTimeMillis()+".png";
        part.write(savePath + File.separator + fileName);
        part.write("O:\\workspace\\eclipse\\FinalProject\\WebContent\\images\\items\\" +File.separator+ fileName);
        String filePath= "images/items/" + fileName;
		
        if(part.getSize()==0){
        	itembean.ChangeItem(id,name, description, price, amount, categoryname);
        }else{
        	itembean.ChangeItem(id,name, description, filePath, price, amount, categoryname);
        }
        
        

        System.out.println(savePath + File.separator + fileName);
        
        response.sendRedirect("myprofile");
	}

}
