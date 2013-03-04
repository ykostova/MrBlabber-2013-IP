package uk.ac.dundee.computing.yek.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.LinkedList;

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
		urlPatterns = { "/Follow" }, 
		initParams = { 
				@WebInitParam(name = "data-source", value = "jdbc/YolinaKostova", description = "Jdbc link to YolinaKostova.db")
		})
public class FollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		String param = (String) session.getAttribute("currentUser");
		if (param == null) {
			response.sendRedirect("Login");
		}
		if(con!=null) {
			request.getRequestDispatcher("./following.jsp").forward(request, response);
		} else response.sendRedirect("ErrorPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		String param = (String) session.getAttribute("currentUser");
		if (param == null) {
			response.sendRedirect("Login");
		}
		if(con!=null) {
			String personID = request.getParameter("myForm");
			System.out.println(personID);
			personID = personID.substring(6);
			System.out.println(personID);
			FriendshipStore store = new FriendshipStore();
			store.setFollowee(Integer.parseInt(personID));
			store.setFollower(person.getIDbyUsername(con, param));
			store.setStartDate(Calendar.getInstance().getTimeInMillis());
			
			friendship.sendFriendship(con, store);
			
			response.sendRedirect("./Following");
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