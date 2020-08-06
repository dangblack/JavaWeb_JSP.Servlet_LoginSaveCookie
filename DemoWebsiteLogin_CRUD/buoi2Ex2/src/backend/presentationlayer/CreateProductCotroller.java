package backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.businesslayer.IUserService;
import backend.businesslayer.UserService;

/**
 * Servlet implementation class createProductCotroller
 */
@WebServlet("/create")
public class CreateProductCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IUserService userService; 

    /**
     * @throws IOException 
     * @see HttpServlet#HttpServlet()
     */
    public CreateProductCotroller() throws IOException {
    	userService=new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/view/createProduct.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("inputCode");
		String name=request.getParameter("inputName");
		String price=request.getParameter("inputPrice");

		try {
			if(userService.createProduct(code, name, price)>0) {
				response.sendRedirect("./productList");
			}
			else {
	            request.setAttribute("errorMessage", "error when creating...");	
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/view/createProduct.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
