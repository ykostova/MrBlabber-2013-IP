package uk.ac.dundee.computing.yek.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.mysql.jdbc.Connection;

import uk.ac.dundee.computing.yek.model.PersonStore;
import uk.ac.dundee.computing.yek.model.UserStore;


	/**
	 * Servlet implementation class HomeServlet
	 */
	 @WebServlet(
			urlPatterns = { "/Home" }, 
			initParams = { 
					@WebInitParam(name = "data-source", value = "jdbc/YolinaKostova", description = "Jdbc link to YolinaKostova.db")
			})
	public class HomeServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    private Connection con;
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public HomeServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			postPeopleDetails( request,  response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//directToHome(request, response);
			postPeopleDetails( request,  response);
		}

		private void postPeopleDetails(HttpServletRequest request, HttpServletResponse response){
			HttpSession session = request.getSession();
			//Session currentUserSession = (Session);
			//UserStore user = (UserStore)request.getAttribute("currentUserStore");
			//UserStore currentUser = (UserStore)session.getAttribute("currentUserStore");
			//PersonStore currentPerson = (PersonStore)session.getAttribute("currentPersonStore");
			//user.sendUser(con, currentUser);
			//person.sendPerson(con, currentPerson);
			
			//directToHome(request, response);
		}
		
		private void directToHome(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
		{
			HttpSession session = req.getSession();
			Session currentUserSession = (Session)session.getAttribute("currentUserStore");
			UserStore currentUser = (UserStore) (session.getAttribute("currentUserStore"));
			
			PersonStore currentPerson = (PersonStore)(session.getAttribute("currentPersonStore"));
			user.sendUser(con, currentUser);
			person.sendPerson(con, currentPerson);

		//System.out.println("Home controller");
			try
			{
				//System.out.println("currentSession = "+currentUserSession.toString());
			if(currentUserSession != null)
			{
				//System.out.println("currentSession = "+currentUserSession.getUsername());
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
				rd.forward(req, res);
			}			
			else
			{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
				rd.forward(req, res);
			}
			}catch (Exception e)
			{
				System.out.print(e.getMessage()+"Home Controller");
			}
		}

	}