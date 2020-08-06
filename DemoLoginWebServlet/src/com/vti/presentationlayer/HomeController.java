package com.vti.presentationlayer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String getCookieByKey(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();

		if (cookies == null) {
			return null;
		}

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(key)) {
				return cookie.getValue();
			}
		}
		return null;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/index.jsp");
		requestDispatcher.forward(request, response);
		
//		// get cookie
//		String username = getCookieByKey(request, "username");
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//
//		// not logged in already
//		if (username.equals("")) {
//			out.print("<html><script>");
//			out.print("alert(\"Hello \")" + username);
//			out.print("</script><body>");
//			out.print("Please login first <br>");
//			out.print("<a href=\"login\"> Login </a>");
//			out.print("</body></html>");
//
//		} else {
//			// forward to index
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/index.jsp");
//			requestDispatcher.forward(request, response);
//
//			out.print("<html><script>");
//			out.print("alert(\"Hello \")" + username);
//			out.print("</script><body>");
//			out.print("Please login first <br>");
//			out.print("<a href=\"login\"> Login </a>");
//			out.print("</body></html>");
//
//		}
//
//		out.close();
	}

}
