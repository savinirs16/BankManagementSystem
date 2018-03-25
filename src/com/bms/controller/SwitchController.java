package com.bms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class SwitchController
 */
public class SwitchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger("SwitchController");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SwitchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("DoGet Method in SwitchController got invoked");
		String loanType = request.getParameter("loanType");
		HttpSession session=request.getSession();
		session.setAttribute("loanType", loanType);
		if(loanType.equalsIgnoreCase("educational")){
			response.sendRedirect("Eduform.jsp");
		}
		else{
			response.sendRedirect("Perform.jsp");
		}
		LOG.info("Out of SwitchController doGet() method ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
