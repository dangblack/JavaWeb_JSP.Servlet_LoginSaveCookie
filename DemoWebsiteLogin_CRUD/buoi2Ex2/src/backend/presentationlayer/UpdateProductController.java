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
import entity.Product;

/**
 * Servlet implementation class updateProductController
 */
@WebServlet("/update")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IUserService userService; 

    /**
     * @throws IOException 
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductController() throws IOException {
    	userService=new UserService();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code= request.getParameter("code");
		try {
			Product product= userService.getProductByCode(code);
			request.setAttribute("product", product);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/view/updateProduct.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		String name=request.getParameter("inputName");
		String price=request.getParameter("inputPrice");
		try {
			if(userService.updateProduct(code, name, price)>0) {
				response.sendRedirect("./productList");	
			}
			else {
	            request.setAttribute("errorMessage", "error when updating...");	
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/view/updateProduct.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

