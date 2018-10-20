package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DBUtil;
import beans.UserBean;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(!username.equals("") && !password.equals("")){
			
			//ne uwin kerek esli olsizda istese
			ServletContext ctx = request.getServletContext();
			DBUtil dbManager = (DBUtil) ctx.getAttribute("DBManager");
			UserBean userbean = new UserBean();
			
			if(userbean.CheckUsernamePassword(username, password)){
				int userid = userbean.GetUserIDByUsername(username);
				
				//userID cookie created
				Cookie userI = new Cookie("userID",userid+"");
				response.addCookie(userI);
				userI.setMaxAge(60*30); //60*30
				
				
				//userLogin cookie created
				Cookie userN = new Cookie("userName",username);
				response.addCookie(userN);
				userN.setMaxAge(60*30); //60*30
				
				//userPassword cookie created
				//Cookie userP = new Cookie("userPassword",password);
				//response.addCookie(userP);
				//userP.setMaxAge(60*30); //60*30
				
				
				
				request.getSession().setAttribute("userI", userid);
				request.getSession().setAttribute("userN", username);
				//request.getSession().setAttribute("userP", password);
				
				if(userbean.IsAdmin(username)==true){
					request.getSession().setAttribute("userP", "admin");
				}else{
					request.getSession().setAttribute("userP", "user");
				}
				
				response.sendRedirect("/FinalProject/home");
			}else{
				response.sendRedirect("/FinalProject/login.jsp");
			}
		}else{
			response.sendRedirect("/FinalProject/login.jsp");   
		}
	}

}
