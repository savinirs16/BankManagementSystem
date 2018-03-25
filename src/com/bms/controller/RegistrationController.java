package com.bms.controller;

import java.io.IOException;
//import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

//import com.aip.bo.RegistrationBo;
import com.bms.bo.RegistrationBO;
import com.bms.exceptions.BMSBussinessException;
import com.bms.exceptions.BMSException;
import com.bms.vo.RegistrationVO;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * The Logger for logging the errors and info
	 */
	public static final Logger LOG = Logger.getLogger("RegistrationController");
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//private long accountNum;
	//private String cusID;
	private String name;
	private String uname;
	private String pass;
	private String rpass;
	private String gtype;
	private String gname;
	private String address;
	private String gender;
	private String citizenship;
	private String citizenstatus;
	private String email;		
	private String contact;
	private String dob;
	private String date;	
	private String acctype;
	private String branchName;
	private int inidepamo;
	private String idproof;
	private String idnum;
	private String refname;
	private String refaddress;
	private long refaccnum;
	private String state;
	private String country;
	private String maritalStatus;
	HashMap<String, String> countryDetails = new HashMap<String, String>();
	HashMap<String, String> stateDetails = new HashMap<String, String>();
	
	
	
	

	 RegistrationVO registrationVo = new RegistrationVO();
	 RegistrationBO registrationBO = new RegistrationBO();
	

	//public static final Logger LOG=Logger.getLogger("RegistrationController method invoked");
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("RegistrationController Initialized - doPost method got invoked");
		HttpSession session = request.getSession();
	    //System.out.println("in controller post");
		//System.out.println("Flow came to Registration Controller");
		//account_num=Long.parseLong(request.getParameter("account_num"));
		//cusID = request.getParameter("cus_id");
		name=request.getParameter("name");
		//System.out.println(name);
		uname=request.getParameter("uname");
		//System.out.println(uname);
		pass=request.getParameter("pass");
		//System.out.println(pass);
		rpass=request.getParameter("rpass");
		//System.out.println(rpass);
		gtype=request.getParameter("gtype");
		//System.out.println(gtype);
		gname=request.getParameter("gname");
		//System.out.println(gname);
		address=request.getParameter("address");
		//System.out.println(address);
		gender=request.getParameter("gender");
		//System.out.println(gender);
		citizenship=request.getParameter("citizenship");
		//System.out.println(citizenship);
		citizenstatus=request.getParameter("citizenstatus");
		//System.out.println(citizenstatus);
		email=request.getParameter("email");
		//System.out.println(email);
		contact=request.getParameter("contact");
		//System.out.println(contact);
		dob=request.getParameter("dob");
		//System.out.println(dob);
		date=request.getParameter("date");
		//System.out.println(date);
		acctype=request.getParameter("Acctype");
		//System.out.println(acctype);
		branchName=request.getParameter("branchName");
		//System.out.println(branchName);
		citizenstatus=request.getParameter("citizenstatus");
		inidepamo=Integer.parseInt(request.getParameter("inidepamo"));
		idproof=request.getParameter("idproof");
		//System.out.println(idproof);
		idnum=request.getParameter("idnum");
		//System.out.println(idnum);
		refname=request.getParameter("refname");
		//System.out.println(refname);
		refaddress=request.getParameter("refaddress");
		//System.out.println(refaddress);
		//refaccnum=Integer.parseInt(request.getParameter("refaccnum"));
		refaccnum=Long.parseLong(request.getParameter("refaccnum"));
		//System.out.println(refaccnum);
		state=request.getParameter("stateid");
		//System.out.println(state);
		country=request.getParameter("countryid");
		//System.out.println(country);
		maritalStatus=request.getParameter("maritalStatus");
		//System.out.println(maritalStatus);

		//System.out.println(" Data given in the page set into resgistrationVO at Registration Controller");
		// System.out.println(" helloooooooooo");
		registrationVo.setName(name);
		// System.out.println(" name from VO is "+registrationVo.getName());
		 registrationVo.setUname(uname);
		 registrationVo.setPass(pass);
		 registrationVo.setRpass(rpass);
		 registrationVo.setGtype(gtype);
		 registrationVo.setGname(gname);
		 registrationVo.setAddress(address);
		 registrationVo.setGender(gender);
		 registrationVo.setCitizenship(citizenship);
		 registrationVo.setCitizenstatus(citizenstatus);
		 registrationVo.setEmail(email);
		 registrationVo.setContact(contact);
		 registrationVo.setDob(dob);
		 registrationVo.setDate(date);
		 registrationVo.setAcctype(acctype);
		 registrationVo.setBranchName(branchName);
		 registrationVo.setInidepamo(inidepamo);
		 registrationVo.setIdproof(idproof);
		 registrationVo.setIdnum(idnum);
		 registrationVo.setRefname(refname);
		 registrationVo.setRefaddress(refaddress);
		 registrationVo.setRefaccnum(refaccnum);
		 registrationVo.setState(state);
		 registrationVo.setCountry(country);
		 registrationVo.setMaritalStatus(maritalStatus);
		 //registrationVo.setCusID(cusID);
		 //registrationVo.setAccount_num(account_num);
			registrationBO = new RegistrationBO();
			try {
				String cusid = (String) registrationBO.registerCustomer(registrationVo);
					session.setAttribute("cusid", cusid);
					RequestDispatcher rd=request.getRequestDispatcher("successPage.jsp");
					rd.forward(request, response);
				
			} catch (BMSException e) {
				// TODO Auto-generated catch block
				LOG.error("BMSException in RegistrationController"+e.getMessage());
				//e.printStackTrace();
				session.setAttribute("errmsg1", "Database Error .....");
				RequestDispatcher rd1=request.getRequestDispatcher("errorPage1.jsp");
				rd1.forward(request, response);
			} catch (BMSBussinessException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				LOG.error("BMSBusinessException in RegistrationController"+e.getMessage());
				session.setAttribute("errmsg1", "Registration Error.....");
				RequestDispatcher rd1=request.getRequestDispatcher("erroePage1.jsp");
				rd1.forward(request, response);
			} catch (ParseException e) {
				LOG.error("ParseException in RegistrationController"+e.getMessage());
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			//System.out.println("before calling acct in cont");
			 //long accno=registrationBO.getAccountNum();
			 //System.out.println("from acct bo to cont");
			 //registrationVo.setAccountNum(accno);
			// System.out.println(registrationVo.getAccountNum());
			
		 
		// System.out.println(" RegistrationBO - generatedCustID method invoked from Registartion Controller doPost method");
		
			LOG.info("Leaving RegistrationController doPost() method");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("in controller get");
		LOG.info("RegistrationController Initialized - doGet method got invoked");
		HttpSession session = request.getSession();
		
		
			
			try {
				countryDetails = registrationBO.getCountryDetails();
				session = request.getSession();
				session.setAttribute("countryDetails", countryDetails);
				stateDetails = registrationBO.getStateDetails();
				session.setAttribute("stateDetails", stateDetails);
				//System.out.println("after");
				RequestDispatcher dispatcher=request.getRequestDispatcher("empRegistration1.jsp");
				//System.out.println("error");
				dispatcher.forward(request, response);
			} catch (BMSException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				LOG.error("BMSException in RegistrationController"+e.getMessage());
				session.setAttribute("errmsg1", "Database Error.....");
				RequestDispatcher dispatcher=request.getRequestDispatcher("erroePage1.jsp");
				dispatcher.forward(request, response);
				
			}
			
			
			 
		 LOG.info("Leaving RegistrationController doGet method");
		
	}
	
	
	
					
	}

