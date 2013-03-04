package uk.ac.dundee.computing.yek.controller;

import java.io.IOException;
import java.sql.SQLException;

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
		urlPatterns = { "/Register" }, 
		initParams = { 
				@WebInitParam(name = "data-source", value = "jdbc/YolinaKostova", description = "Jdbc link to YolinaKostova.db")
		})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//con=null;
		if(con!=null) {
			request.getRequestDispatcher("./index.jsp").forward(request, response);
			//response.sendRedirect("index.jsp");
		} else response.sendRedirect("ErrorPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if(con!=null) {
			redirectRequest(request,response);
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
	
	private void redirectRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		UserStore currentUser = new UserStore();
		PersonStore currentPerson = new PersonStore();
		
		currentUser.setUsername(request.getParameter("username"));
		currentUser.setPassWord(user.encryptPass(request.getParameter("password")));
		currentUser.setEmail(request.getParameter("email"));
		//boolean emailValidation = user.verifyEmail(currentUser.getEmail());
		//String confirmation = user.encryptPass(request.getParameter("confirm_pass"));
		//boolean usernameUnique = user.checkNameUnique(con, currentUser.getUsername());

		currentPerson.setUsername(request.getParameter("username"));
		currentPerson.setFirstName(request.getParameter("first_name"));
		currentPerson.setLastName(request.getParameter("last_name"));
		currentPerson.setCountryID(Integer.parseInt(request.getParameter("country").toString()));
		
		System.out.println(currentPerson.getCountryID());
		user.sendUser(con, currentUser);

		boolean result = person.sendPerson(con, currentPerson);
		
		System.out.println(String.valueOf(result) + " - person insert");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("currentUser", currentUser.getUsername());
		response.sendRedirect("./Profile");
	}

}
