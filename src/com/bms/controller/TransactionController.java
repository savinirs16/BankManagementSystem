package com.bms.controller;

import java.io.IOException;
import java.text.ParseException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.bms.bo.TransactionBO;
import com.bms.exceptions.BMSBussinessException;
import com.bms.exceptions.BMSException;
import com.bms.vo.AccountDetailsVO;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class TransactionController
 */
public class TransactionController extends HttpServlet {
	public static final Logger LOG = Logger.getLogger("TransactionController");
	private static final long serialVersionUID = 1L;

	private long accNumber;
	private String transactionid;

	/**
	 * @param transactionVO
	 * @see HttpServlet#doPost(HttpServletRequest request,
	 *      ---HttpServletResponse response)
	 */
	
	
	
	AccountDetailsVO accountDetailsVO = new AccountDetailsVO();
	TransactionBO transactionBO = new TransactionBO();
	RequestDispatcher dispatcher = null;
	
	

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		{
		
			
		

		//doPost(req, resp);
		
		//System.out.println("came to DOGet Method in Controller ");
		LOG.info("DoGet Method in TransactionController got invoked");
		accNumber = Long.parseLong(request.getParameter("accNumber"));
		//System.out.println(accNumber);
		HttpSession session = request.getSession();
		String cusid=(String) session.getAttribute("cusID");
		accountDetailsVO.setCusID(cusid);
		//transactionid = (request.getParameter("transactionID"));
		//System.out.println(transactionid);
		
		
		try {
			accountDetailsVO = transactionBO.getAccountDetails(accNumber);
			//System.out.println(accountDetailsVO.getTransactionID());
			if(accountDetailsVO!=null){
				session.setAttribute("accountVO", accountDetailsVO);
				dispatcher = request.getRequestDispatcher("Success1.jsp");
				dispatcher.forward(request, response);
			}
			
		
		} catch (BMSException e) {
			// TODO Auto-generated catch block
			LOG.error("BMSException in TransactionController doGet() method");
			//e.printStackTrace();
			session.setAttribute("emsg1", "Invalid account Number...");
			RequestDispatcher rd1=request.getRequestDispatcher("erroePage1.jsp");
			rd1.forward(request, response);
		
		}
		LOG.info("Out of  TransactionController DoGet Method ");
		}
//		catch (BMSBusinessException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//			session.setAttribute("emsg1", "Transaction Deposit is not successfull...");
//			dispatcher=request.getRequestDispatcher("errorDeposit.jsp");
//			dispatcher.forward(request, response);
//		
//		
//		}finally{
//			
//		}
//		}
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//System.out.println(" Flow came to Controller DoPost method");
	LOG.info("TransactionController doPost() method got invoked");

	
	
	String transactionType = request.getParameter("transactionType");
	//System.out.println(transactionType);
	long amount = Long.parseLong(request.getParameter("amount"));
	
	
	//System.out.println(amount);
	HttpSession session = request.getSession();
	String cusid=(String) session.getAttribute("cusID");
	accountDetailsVO.setCusID(cusid);
	AccountDetailsVO accountDetailsVO = (AccountDetailsVO) session.getAttribute("accountVO");
	
	accountDetailsVO.setAmount(amount);
	session.setAttribute("amount", accountDetailsVO.getAmount());
	accountDetailsVO.setTransactionType(transactionType);
	session.setAttribute("transType",accountDetailsVO.getTransactionType());
	//System.out.println(accountDetailsVO.getAmount());
	transactionid=transactionBO.generateTransactionID();
	//System.out.println("in contro"+transactionid);
	accountDetailsVO.setTransactionID(transactionid);
	session.setAttribute("transactionid", transactionid);
	accountDetailsVO.setTransactionDate( (String) session.getAttribute("date"));
//	System.out.println(accountDetailsVO.getTransactionDate());
	
	 
	try {
		  if(transactionType.equalsIgnoreCase("deposit")){
			try
			{
		long final_amount = transactionBO.depositAmount(accountDetailsVO);
		
		session.setAttribute("final_amount", final_amount);
		dispatcher = request.getRequestDispatcher("finalSuccess.jsp");
		dispatcher.forward(request, response);
	} catch (BMSException e) {
		// TODO Auto-generated catch block
		LOG.error("BMSException for deposit in TransactionController doPost() method"+e.getMessage());
		//e.printStackTrace();
		session.setAttribute("errmsg1", "Database Error ....");
		RequestDispatcher rd1=request.getRequestDispatcher("erroePage1.jsp");
		rd1.forward(request, response);
		
	} catch (BMSBussinessException e) {
		// TODO Auto-generated catch block
		LOG.error("BMSBussinessException for deposit in TransactionController doPost() method"+e.getMessage());
		//e.printStackTrace();
		session.setAttribute("emsg1", "Transaction Deposit is not successfull...");
		dispatcher=request.getRequestDispatcher("errorDeposit.jsp");
		dispatcher.forward(request, response);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		LOG.error("ParseException for deposit in TransactionController doPost() method"+e.getMessage());
		//e.printStackTrace();
		session.setAttribute("emsg1", "Transaction Deposit is not successfull...");
		dispatcher=request.getRequestDispatcher("errorDeposit.jsp");
		dispatcher.forward(request, response);
	}
}
	else if(transactionType.equalsIgnoreCase("withdrawal"))
	{
		try
		{
			long final_amount = transactionBO.withDrawalAmount(accountDetailsVO);
			
			session.setAttribute("final_amount", final_amount);
			dispatcher = request.getRequestDispatcher("finalSuccess.jsp");
			dispatcher.forward(request, response);
	}catch (BMSException e) {
		// TODO Auto-generated catch block
		LOG.error("BMSException for withdrawal in TransactionController doPost() method"+e.getMessage());
		e.printStackTrace();
		
	} catch (BMSBussinessException e) {
		// TODO Auto-generated catch block
		LOG.error("BMSBussinessException for withdrawal in TransactionController doPost() method"+e.getMessage());
		//e.printStackTrace();
		session.setAttribute("emsg1", "Insufficient funds...Transaction withdrawal is not successfull...");
		dispatcher=request.getRequestDispatcher("errorwithdrawal.jsp");
		dispatcher.forward(request, response);
	}
}
	else if(transactionType.equalsIgnoreCase("loanEMIDebit")){
		try
		{
		long final_amount = (long) transactionBO.loanEMIDebit(accountDetailsVO);
		
		session.setAttribute("final_amount", final_amount);
		dispatcher = request.getRequestDispatcher("finalSuccess.jsp");
		dispatcher.forward(request, response);
	}catch (BMSException e) {
		// TODO Auto-generated catch block
		LOG.error("BMSException for loanEMIDebit in TransactionController doPost() method"+e.getMessage());
		e.printStackTrace();
		
	} catch (BMSBussinessException e) {
		// TODO Auto-generated catch block
		LOG.error("BMSBussinessException for loanEMIDebit in TransactionController doPost() method"+e.getMessage());
		//e.printStackTrace();
		session.setAttribute("emsg1", "Transaction Loan EMI Debit is not successfull...");
		dispatcher=request.getRequestDispatcher("errorLoanEMIDebit.jsp");
		dispatcher.forward(request, response);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		LOG.error("ParseException for loanEMIDebit in TransactionController doPost() method"+e.getMessage());
		e.printStackTrace();
	} 
	}
	}		finally{
		
	}
	LOG.info("Out of TransactionController doPost() method ");
//	catch (BMSException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		
//	} catch (BMSBusinessException e) {
//		// TODO Auto-generated catch block
//		//e.printStackTrace();
//		session.setAttribute("emsg1", "Insufficent funds...");
//		dispatcher=request.getRequestDispatcher("errorPage.jsp");
//		dispatcher.forward(request, response);
//	} catch (ParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}
}

	

	
	