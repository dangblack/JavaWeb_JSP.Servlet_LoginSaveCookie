package backend.presentationlayer;

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
 * Servlet implementation class DeleteProductController
 */
@WebServlet("/delete")
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IUserService userService; 

    /**
     * @throws IOException 
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductController() throws IOException {
    	userService=new UserService();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
			try {
				userService.deleteProduct(code);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("./productList");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
