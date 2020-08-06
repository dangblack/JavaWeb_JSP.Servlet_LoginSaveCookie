package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import entity.Account;
import utils.StoreUtils;

/**
 * Servlet Filter implementation class RoleFilter
 */
@WebFilter(urlPatterns= {"/create", "/delete", "/productList", "/update"})
public class RoleFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RoleFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request= (HttpServletRequest) req;
		Account loginedUser=StoreUtils.getLoginedUserFromSession(request);
		String role=loginedUser.getRole();
		if(role.equals("employee")){
			request.setAttribute("errorMessage", "Please log in as a manager!");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/login.jsp");
			requestDispatcher.forward(request, response);
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
