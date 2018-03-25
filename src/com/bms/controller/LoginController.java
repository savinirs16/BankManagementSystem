package com.bms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bms.bo.LoginBO;
import com.bms.exceptions.BMSException;
import com.bms.vo.LoginVO;


/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * The Logger for logging the errors and info
	 */
	public static final Logger LOG = Logger.getLogger("LoginController");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  LoginVO loginVO=null;
  LoginBO loginBO=null;
  
  HttpSession session=null;
  String cusID = new String();
  String cname = new String();
  long acctnum  ;
  int balance;
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//System.out.println("Enters login controller");
    	// TODO Auto-generated method stub
    	String uname=new String();
    	String password=new String();
    	
    	
    	uname=request.getParameter("uname");
    	password=request.getParameter("pass");
    	LOG.info("LoginController Initialized - doGet method got invoked with "+uname+", "+password);
    	loginVO = new LoginVO();
    	 
    	//set values to VO object
    	loginVO.setUsername(uname);
    	//System.out.println(loginVO.getUsername());
    	loginVO.setPassword(password);    	 
    	//System.out.println(loginVO.getPassword());
    	loginBO=new LoginBO();
    	//System.out.println("before going controller into bo in controller");
    	boolean b=loginBO.validateUser(loginVO);
    	session=request.getSession();
    	
    	
    	if(b==true)
    	{
    		
    		LOG.info("Going to customer home page");
    		
    		LoginVO loginVO1=loginBO.data(loginVO);
    		cusID=loginVO1.getCustid();   		
    		//System.out.println("customer id is"+cusID);
    		
    		cname=loginVO1.getCname();
    		//System.out.println("in controller"+cname);
    		acctnum = loginVO1.getAcctnum();
    		
    		balance=loginVO1.getBalance();
    		//System.out.println(balance);
    		
    		
    		HttpSession session = request.getSession();
    		session.setAttribute("cusID", cusID);
    		session.setAttribute("cname", cname);
    		session.setAttribute("acctnum", acctnum);
    		session.setAttribute("balance", balance);
    		//System.out.println("before disp");
    		RequestDispatcher dispatcher=request.getRequestDispatcher("CustomerHomePage.jsp");
    		dispatcher.forward(request, response);
    		
    	} 
    else
    {
    		LOG.info("Login error, going to login page back");
    		RequestDispatcher dispatcher=request.getRequestDispatcher("LoginError.jsp");
    		dispatcher.forward(request, response);
    	}
    		
    	
    	}
    	 
    	}