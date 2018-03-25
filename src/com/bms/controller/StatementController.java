package com.bms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.bms.bo.StatementBO;
import com.bms.exceptions.BMSBussinessException;
import com.bms.exceptions.BMSException;
import com.bms.vo.TransactionVO;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class StatementController
 */
public class StatementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final Logger LOG = Logger.getLogger("StatementController");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatementController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("DoPost() Method in StatementController got invoked");
		String username="admin";
		//System.out.println(" Flow came to Controller");
		// read data came from page and set into TransactionVO  
		// create TrasactionVo object
		TransactionVO transactionVO = new TransactionVO();
		// set data into the transactionVO object
		transactionVO.setFromDate(request.getParameter("fDate"));
		String f=request.getParameter("fDate");
		String t=request.getParameter("tDate");
		transactionVO.setToDate(request.getParameter("tDate"));
		transactionVO.setTransactionType(request.getParameter("transactionType"));
		String typee=transactionVO.getTransactionType();
		
		//transactionVO.setUsername("admin");
		int noofTransactions = Integer.parseInt(request.getParameter("limit"));
		
		
		HttpSession session = request.getSession();
		session.setAttribute("fdate", f);
		session.setAttribute("tdate", t);
		
		String cs=(String) session.getAttribute("cusID");
		//System.out.println(cs+"in controller of stat");
		transactionVO.setCusId(cs);
		
		RequestDispatcher dispatcher = null;
		// create StatementBO object
		StatementBO statementBO = new StatementBO();
//		session.setAttribute("type", typee);
//		System.out.println(typee+ " in controller ");
		// invoke method of statemwent bo by passing transaction vo
		try {
			List<TransactionVO> transactionList = 	statementBO.generateStatement(transactionVO);
			//System.out.println(transactionList.size()+"to controller");
			if(transactionList!=null){
				
				// set transactionList to session object
				session.setAttribute("tList", transactionList);
				dispatcher = request.getRequestDispatcher("statementDisplay.jsp");
				dispatcher.forward(request, response);
				
			}
			
		} catch (BMSException e) {
			// TODO Auto-generated catch block
			LOG.error("BMSException in StatementController doPost() method");
			//e.printStackTrace();
			session.setAttribute("errmsg1", "database error! try after some time....");
			RequestDispatcher rd1=request.getRequestDispatcher("erroePage1.jsp");
			rd1.forward(request, response);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			LOG.error("ParseException in StatementController doGet() method");
			e.printStackTrace();
		} catch (BMSBussinessException e) {
			// TODO Auto-generated catch block
			LOG.error("BMSBussinessException in StatementController doGet() method");
			//e.printStackTrace();
			//session.setAttribute("errmsg1", "Application Error....");
			session.setAttribute("errmsg1", e.getMessage());
			dispatcher=request.getRequestDispatcher("errorpage1.jsp");
			dispatcher.forward(request,response);
		}
		
		LOG.info("Out of DoGet Method in StatementController");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
