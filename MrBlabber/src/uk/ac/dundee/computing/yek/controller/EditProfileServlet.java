package uk.ac.dundee.computing.yek.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uk.ac.dundee.computing.yek.model.PersonStore;

import com.mysql.jdbc.Connection;


/**
 * Servlet implementation class Parts
 */
@WebServlet(
		urlPatterns = { "/Profile" }, 
		initParams = { 
				@WebInitParam(name = "data-source", value = "jdbc/YolinaKostova", description = "Jdbc link to YolinaKostova.db")
		})
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
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
		String param = String.valueOf(session.getAttribute("currentUser"));
        if (param == null) {
        	System.out.println("NO LOGIN");
        	request.getRequestDispatcher("./Login").forward(request, response);
            //response.sendRedirect("./Login");
        }
        else {
        	System.out.println("logged in.");
			request.getRequestDispatcher("./profile.jsp").forward(request, response);
        }
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersonStore currentPerson = new PersonStore();
		
		String number = request.getParameter("phone_number");
		int phone = 0;
		if(number!="") phone = Integer.parseInt(number);
		currentPerson.setFirstName(request.getParameter("first_name"));
		currentPerson.setLastName(request.getParameter("last_name"));
		currentPerson.setCity(request.getParameter("city"));
		currentPerson.setPhoneNumber(phone);
		currentPerson.setWebsite(request.getParameter("website"));
		currentPerson.setPhoto(request.getParameter("photo"));
		currentPerson.setHeader(request.getParameter("header"));
		currentPerson.setBio(request.getParameter("bio"));
		currentPerson.setCountryID(Integer.parseInt(request.getParameter("country")));
		currentPerson.setUsername(String.valueOf(request.getSession().getAttribute("currentUser")));
		
		person.updatePerson(con, currentPerson);
		//response.sendRedirect("./profile.jsp");
		request.getRequestDispatcher("./profile.jsp").forward(request, response);
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
