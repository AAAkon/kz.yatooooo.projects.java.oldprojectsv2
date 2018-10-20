package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.jdbc.Blob;

import beans.DBUtil;
import beans.UserBean;


@WebServlet("/registration")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "images\\users";
	
	public RegistrationServlet() {
        super();
    }

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
		
		
		if(!name.equals("") && !surname.equals("") && !city.equals("") && !address.equals("") && !phoneno.equals("") && !email.equals("") && !username.equals("") && !password.equals("") && !password2.equals("")){
			if(password.equals(password2)){
				
				//ServletContext ne uwin olsizda isteidi goi
				//ServletContext ctx = request.getServletContext();
				//DBUtil dbutil = (DBUtil)ctx.getAttribute("DBManager");
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
		        
				if(userbean.UsernameNotExist(username)){
					userbean.AddUser(name, surname, city, address, phoneno, email, filePath, username, password2);
					response.sendRedirect("login.jsp");
				}else{
					response.sendRedirect("registration.jsp");
				}
			}else{
				response.sendRedirect("registration.jsp");
			}
		}else{
			response.sendRedirect("registration.jsp");
		}
		
	}

}
