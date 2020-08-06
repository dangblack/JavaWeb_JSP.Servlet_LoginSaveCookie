package com.vti.presentationlayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vti.businesslayer.IUserService;
import com.vti.businesslayer.UserService;
import com.vti.entity.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserService userService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			userService = new UserService();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// forward to login
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get Parameter
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// login success
		try {
			User user = userService.login(username, password);
			
			if (user != null) {
				// save cookie
				addCookie(response, "username", user.getUsername());
				addCookie(response, "password", user.getPassword());
				//addCookie(response, "fullName", user.getFullName());
				addCookie(response, "role", user.getRole());
				// redirect to home page
				response.sendRedirect(request.getContextPath() + "/home");
			} else {
				String messageError = "Username or Password is failure";
				request.setAttribute("username", username);
				request.setAttribute("messageError", messageError);
				
				// forward to login
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login.jsp");
				requestDispatcher.forward(request, response);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	void addCookie(HttpServletResponse response, String key, String value) {
		Cookie cookie = new Cookie(key, value);
		response.addCookie(cookie);
	}
}
