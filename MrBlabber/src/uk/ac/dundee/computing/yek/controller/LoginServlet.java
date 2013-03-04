package uk.ac.dundee.computing.yek.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import uk.ac.dundee.computing.yek.model.*;


/**
 * Servlet implementation class Parts
 */
@WebServlet(
		urlPatterns = { "/Login" }, 
		initParams = { 
				@WebInitParam(name = "data-source", value = "jdbc/YolinaKostova", description = "Jdbc link to YolinaKostova.db")
		})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
        if (param != null) {
        	System.out.println("NO LOGIN");
        	session.invalidate();
        	request.getRequestDispatcher("./login.jsp").forward(request, response);
        }
        else {
        	session.removeAttribute("currentUser");
        	session.invalidate();
			request.getRequestDispatcher("./login.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        if(con!=null) {
			UserStore thisUser = new UserStore();
			
			long tweetL = Calendar.getInstance().getTimeInMillis();
			thisUser.setUsername(request.getParameter("Username"));
			thisUser.setPassWord(user.encryptPass(request.getParameter("Password")));
   			
   			boolean result = user.checkLogin(con, thisUser);
   			
   			if(result) {
   				HttpSession session = request.getSession(true);	
   				session.setAttribute("currentUser", thisUser.getUsername());
   				response.sendRedirect("./Profile");
   			} else {
   				request.getRequestDispatcher("./login.jsp").forward(request, response);
   			}
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
