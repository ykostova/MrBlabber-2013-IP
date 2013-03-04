package uk.ac.dundee.computing.yek.controller;

import java.io.IOException;
import java.util.*;

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
		urlPatterns = { "/MyTweets" }, 
		initParams = { 
				@WebInitParam(name = "data-source", value = "jdbc/YolinaKostova", description = "Jdbc link to YolinaKostova.db")
		})
public class TweetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TweetsServlet() {
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
        	System.out.println("NO LOGIN");
        	//request.getRequestDispatcher("./Login").forward(request, response);
        }
		if(con!=null) {
			request.getRequestDispatcher("./myTweets.jsp").forward(request, response);
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
            //response.sendRedirect("./Login");
        }
        if(con!=null) {
			PostStore tweet = new PostStore();
			
			long tweetL = Calendar.getInstance().getTimeInMillis();
			tweet.setPostDate(tweetL);
			tweet.setPostAuthor(person.getIDbyUsername(con, param));
			tweet.setPostText(request.getParameter("inputTweet"));
			tweet.setPostFile("");
   			
   			post.sendPost(con, tweet);
   			
   			request.getRequestDispatcher("./myTweets.jsp").forward(request, response);
   			
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
