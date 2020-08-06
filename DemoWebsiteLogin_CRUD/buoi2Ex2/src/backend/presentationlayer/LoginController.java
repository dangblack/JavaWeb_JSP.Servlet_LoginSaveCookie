package backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backend.businesslayer.IUserService;
import backend.businesslayer.UserService;
import backend.datalayer.IUserRepository;
import entity.Account;
import utils.StoreUtils;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService; 

    /**
     * @throws IOException 
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() throws IOException {
    	userService=new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=StoreUtils.getCookie(request, "userName");
		String passWord=StoreUtils.getCookie(request, "passWord");
		String rememberMe=StoreUtils.getCookie(request, "rememberMe");
		if("on".equals(rememberMe)) {
			request.setAttribute("userName", userName);
			request.setAttribute("passWord", passWord);
		}

		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/view/login.jsp");
		requestDispatcher.forward(request, response);
	}
	/**
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException, ServletException {
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		String rememberMe= request.getParameter("rememberMe");
		
		
		
			try {
				ResultSet resultSet=userService.getAccountData(userName, passWord);
				if(resultSet.next()){
					Account account= new Account(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4));
					StoreUtils.storeLoginedUserToSession(request, account);

					StoreUtils.addCookie(response, "userName", userName);
					StoreUtils.addCookie(response, "passWord", passWord);
					StoreUtils.addCookie(response, "rememberMe", rememberMe);
			
					response.sendRedirect("./userInfo");
					
				}
				else {
		            request.setAttribute("errorMessage", "Invalid userName or Password");	 
		            request.setAttribute("userName", userName);	 

					RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/view/login.jsp");
					requestDispatcher.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException | IOException | ServletException e) {
				e.printStackTrace();
			}
		}	
	
	
	
}
