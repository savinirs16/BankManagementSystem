package com.bms.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.bms.bo.UpdateProfileBO;
import com.bms.exceptions.BMSException;

/**
 * Servlet implementation class dataController
 */
public class dataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger("dataController");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	HashMap<String, String> countryDetails = new HashMap<String, String>();
	HashMap<String, String> stateDetails = new HashMap<String, String>();
	UpdateProfileBO updateprofileBO=new UpdateProfileBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("doGet() Method in dataController got invoked");
		
HttpSession session = request.getSession();
	
	
		
		try {
			//System.out.println("in dat cont");
			countryDetails = updateprofileBO.getCountryDetails();
			session = request.getSession();
			session.setAttribute("countryDetails", countryDetails);
			stateDetails = updateprofileBO.getStateDetails();
			session.setAttribute("stateDetails", stateDetails);
			//System.out.println("after");
			RequestDispatcher dispatcher=request.getRequestDispatcher("UpdateProfileController");
			//System.out.println("error");
			dispatcher.forward(request, response);
		} catch (BMSException e) {
			// TODO Auto-generated catch block
			LOG.error("BMSException  in dataController doGet() method"+e.getMessage());
			session.setAttribute("errmsg1", "Database Error ....");
			RequestDispatcher rd1=request.getRequestDispatcher("erroePage1.jsp");
			rd1.forward(request, response);
			
			//e.printStackTrace();
			
		}	
		LOG.info("Out of doGet() Method in dataController");
	}

}
