package backend.presentationlayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backend.businesslayer.IUserService;
import backend.businesslayer.UserService;
import entity.Account;
import entity.Product;

/**
 * Servlet implementation class ProductListController
 */
@WebServlet("/productList")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService;

	/**
	 * @throws IOException
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductListController() throws IOException {
		userService = new UserService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		try {
			products = userService.getListProduct();
			request.setAttribute("products", products);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/productList.jsp");
			requestDispatcher.forward(request, response);

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
