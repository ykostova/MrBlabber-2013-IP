package uk.ac.dundee.computing.yek.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;


/**
 * Servlet implementation class Parts
 */
@WebServlet(
		urlPatterns = { "/Account" }, 
		initParams = { 
				@WebInitParam(name = "data-source", value = "jdbc/YolinaKostova", description = "Jdbc link to YolinaKostova.db")
		})
public class PasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//con=null;
		HttpSession session = request.getSession();	
		String param = (String) session.getAttribute("currentUser");
        if (param == null) {
            response.sendRedirect("Login");
        }
        request.getRequestDispatcher("./account.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		String param = (String) session.getAttribute("currentUser");
		if(con!=null) {
			
			String email = request.getParameter("password");
			String oldPassword = user.encrypt(request.getParameter("password"));
			String oldConfirmation = user.encrypt(request.getParameter("con_password"));
			String newPass = user.encrypt(request.getParameter("pass"));
			String conPass = user.encrypt(request.getParameter("con_pass"));
			if (oldPassword.equals(oldConfirmation)) user.updateAccount(con, param, oldPassword, newPass, email);

			request.getRequestDispatcher("./account.jsp").forward(request,response);
		} else response.sendRedirect("ErrorPage.jsp");
	}

    /**
	   * Assembles the servlet by looking up the DataSource from JNDI.
	   */
	  private void assemble(ServletConfig config)
	  {
		  con = DBconnection.getConnectionInstance();
	    
	  }
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		assemble(config);
	}

}
