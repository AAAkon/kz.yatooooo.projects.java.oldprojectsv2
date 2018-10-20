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

import beans.UserBean;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)

public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "images\\users";
				
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String phoneno = request.getParameter("phoneNo");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		if(password.equals("") &&  password.equals(password2)){
			
			UserBean userbean = new UserBean();
			
			
			String appPath = request.getServletContext().getRealPath("");
	        String savePath = appPath + File.separator + SAVE_DIR;
	        File fileSaveDir=new File(savePath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        
	        Part part=request.getPart("image1");
	        String fileName="user"+System.currentTimeMillis()+".png";
	        part.write(savePath + File.separator + fileName);
	        part.write("O:\\workspace\\eclipse\\FinalProject\\WebContent\\images\\users\\" +File.separator+ fileName);
	        String filePath= "images/users/" + fileName;
	        
	        
	        if(userbean.UsernameNotExist((int)request.getSession().getAttribute("userI"),username)){
	        	if(part.getSize()==0){
	        		userbean.ChangeUserWithoutImage((int)request.getSession().getAttribute("userI"),name, surname, city, address, phoneno, email, username);
		        }else{
		        	userbean.ChangeUser((int)request.getSession().getAttribute("userI"),name, surname, city, address, phoneno, email, filePath, username);
		        }
	        }
			
	        response.sendRedirect("myprofile");
			
			
		}else if(!password.equals("") &&  password.equals(password2)){
			
			UserBean userbean = new UserBean();
			
			
			String appPath = request.getServletContext().getRealPath("");
	        String savePath = appPath + File.separator + SAVE_DIR;
	        File fileSaveDir=new File(savePath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        
	        Part part=request.getPart("image");
	        String fileName="user"+System.currentTimeMillis()+".png";
	        part.write(savePath + File.separator + fileName);
	        part.write("O:\\workspace\\eclipse\\FinalProject\\WebContent\\images\\users\\" +File.separator+ fileName);
	        String filePath= "images/users/" + fileName;
	        
	        if(userbean.UsernameNotExist((int)request.getSession().getAttribute("userI"),username)){
				
				if(part.getSize()==0){
					userbean.ChangeUserWithoutImage((int)request.getSession().getAttribute("userI"),name, surname, city, address, phoneno, email, username,password);
				}else{
					userbean.ChangeUser((int)request.getSession().getAttribute("userI"),name, surname, city, address, phoneno, email, filePath, username,password);
				}
	        }
			
	        response.sendRedirect("myprofile");
			
			
		}
	}

}
