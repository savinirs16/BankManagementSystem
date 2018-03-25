package com.bms.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bms.bo.UpdateProfileBO;

import com.bms.exceptions.BMSException;
import com.bms.exceptions.BMSBussinessException;
import com.bms.exceptions.BMSException;
import com.bms.vo.UpdateProfileVO;
import org.apache.log4j.Logger;



/**
 * Servlet implementation class UpdateProfileController
 */
public class UpdateProfileController extends HttpServlet {
	
	public static final Logger LOG = Logger.getLogger("UpdateProfileController");
	private static final long serialVersionUID = 1L;
      
	boolean result;
	public String customerID;
	UpdateProfileBO updateprofileBO=new UpdateProfileBO();
	UpdateProfileVO customerVO = null; 
	HashMap<String, String> countryDetails = new HashMap<String, String>();
	HashMap<String, String> stateDetails = new HashMap<String, String>();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	LOG.info("UpdateProfileController doGet() method got invoked");
	//System.out.println("in controller get");
	
	
		
		//System.out.println(" Flow came to controller... get method");
		//String customerID=(String) session.getAttribute("customerID")
		
		HttpSession session=request.getSession();
		customerID = (String) session.getAttribute("cusID");
		RequestDispatcher dispatcher=null;
		
		
		try {
			customerVO = updateprofileBO.getCustomerdetails(customerID);
//			System.out.println("State came to controller"+customerVO.getState());
//			System.out.println(" Address came to controller"+customerVO.getAdd());
//			System.out.println("Ifsc code came to controller"+customerVO.getIfsc());
//			System.out.println("Proof type in controller"+customerVO.getIdtype());
			session.setAttribute("customerVO", customerVO);
			dispatcher=request.getRequestDispatcher("UpdateProfile.jsp");
			dispatcher.forward(request, response);
		} catch (BMSException e) {
			// TODO Auto-generated catch block
			LOG.error("BMSException in UpdateProfileController doGet() method"+e.getMessage());
			//e.printStackTrace();
			session.setAttribute("errMsg", "Data Base Error!!!");
			dispatcher=request.getRequestDispatcher("erroePage.jsp");
			dispatcher.forward(request, response);
		} catch (BMSBussinessException e) {
			// TODO Auto-generated catch block
			LOG.error("BMSBussinessException in UpdateProfileController doGet() method"+e.getMessage());
			//e.printStackTrace();
			session.setAttribute("errMsg", "Data Base Error!!!");
			dispatcher=request.getRequestDispatcher("erroePage.jsp");
			dispatcher.forward(request, response);
		}
		
		LOG.info("Out of UpdateProfileController doGet() method");
		
		
		//instantiate the CustomerUpdateBO
		//System.out.println("entered into controller get customer");
		UpdateProfileBO updateprofileBO=new UpdateProfileBO();
		
		//invoke get customer details method 
//		UpdateProfileVO customerVO = null;
//		try {
//			
//			session.setAttribute("customerVO",customerVO);
//			rd=request.getRequestDispatcher("UpdateProfile.jsp");
//			rd.forward(request, response);
//			
//		} catch (BMSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (BMSBussinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//System.out.println("flow in post method");
		LOG.info("UpdateProfileController doPost() method got invoked");
		HttpSession session=request.getSession();
		RequestDispatcher rd=null;
		customerID = (String) session.getAttribute("cusID");
		//System.out.println("entered into controller update controller");
		//instantiate updateprofileVO
		UpdateProfileBO updateprofileBO=new UpdateProfileBO();
		UpdateProfileVO updateprofileVO=new UpdateProfileVO();
		
		UpdateProfileVO customerVO = (UpdateProfileVO) session.getAttribute("customerVO");
		
		//session.setAttribute("customerVO",customerVO);
		
		
		
		
		//session value after login
		updateprofileVO.setCusid(customerID);
		//System.out.println(" +++++ Customer Id at controller is "+updateprofileVO.getCusid());
		updateprofileVO.setCountry(request.getParameter("countryid"));
		//System.out.println(updateprofileVO.getCountry());
		updateprofileVO.setState(request.getParameter("stateid"));
		System.out.println(updateprofileVO.getState());
		updateprofileVO.setIdtype(request.getParameter("Identificationprooftype"));
		//System.out.println(updateprofileVO.getIdtype());
        updateprofileVO.setDocnum(request.getParameter("IdentificationDocumentNumber"));
        //System.out.println(updateprofileVO.getDocnum());
        updateprofileVO.setAdd(request.getParameter("address"));
		//System.out.println(updateprofileVO.getAdd());
		updateprofileVO.setContact(request.getParameter("ContactNumber"));
	    //System.out.println(updateprofileVO.getContact());
		updateprofileVO.setEmailID(request.getParameter("EmailID"));
        //System.out.println(updateprofileVO.getEmailID());
		updateprofileVO.setMarital(request.getParameter("MaritalStatus"));
		//System.out.println(updateprofileVO.getMarital());
		 updateprofileVO.setAcctype(request.getParameter("AccountType"));
		  //  System.out.println(updateprofileVO.getAcctype());
			updateprofileVO.setCitizenship(request.getParameter("CitizenShip"));
			//System.out.println(updateprofileVO.getCitizenship());
		updateprofileVO.setGuardiantype(request.getParameter("GuardianType"));
		//System.out.println(updateprofileVO.getGuardiantype());
		updateprofileVO.setGuardianname(request.getParameter("GuardianName"));
		//System.out.println(updateprofileVO.getGuardianname());
		
	
		
		
		
       
	
	//PrintWriter out=response.getWriter();
	//out.print("All Validations passedsuccessfully");
		
		try {
			int result = updateprofileBO.getupdateCustomerdetails(updateprofileVO);
            if(result>=0);
			//System.out.println("reached here - update success page");
			rd=request.getRequestDispatcher("UpdateSuccess.jsp");
			session.setAttribute("msg","Account Details Updated Successfully!!!");
			session.setAttribute("updateprofileVO",updateprofileVO );
			rd.forward(request, response);
    
		} catch (BMSException e) {
			// TODO Auto-generated catch block
			LOG.error("BMSException in UpdateProfileController doPost() method"+e.getMessage());
			//e.printStackTrace();
		} catch (BMSBussinessException e) {
			// TODO Auto-generated catch block
			LOG.error("BMSBussinessException in UpdateProfileController doPost() method"+e.getMessage());
			//e.printStackTrace();
		}
		
		
	}

}
