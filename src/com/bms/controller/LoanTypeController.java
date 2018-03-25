package com.bms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.bms.bo.LoanBO;
import com.bms.exceptions.BMSBussinessException;
import com.bms.exceptions.BMSException;
import com.bms.vo.LoanVO;
import org.apache.log4j.Logger;
/**
 * Servlet implementation class LoanTypeController
 */
public class LoanTypeController extends HttpServlet {
	public static final Logger LOG = Logger.getLogger("LoanTypeController");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	
	
    public LoanTypeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    HttpSession session=null;
    RequestDispatcher dispatcher=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("LoanTypeController doGet() method invoked");
		try {
	// Instantiate LoanVO
		LoanVO loanVO = new LoanVO();
		 LoanBO loanBO = new LoanBO();
		 RequestDispatcher dispatcher=null;
		
    // Set LoanDetails
		 HttpSession session=request.getSession();
		 //System.out.println("In controller");
		 String cusID=(String) session.getAttribute("cusID");
		 loanVO.setCustid(cusID);
		 //System.out.println("in loan cont cus id"+loanVO.getCustid());
		 String loanType=(String) session.getAttribute("loanType");
		 //String loanType = request.getParameter("loanType");
//		System.out.println(loanType);
		 if(loanType.equalsIgnoreCase("educational")){
			 loanVO.setLoanType(loanType);
			 
			 loanVO.setLoanAmount(Integer.parseInt((request.getParameter("loanAmount"))));
			 loanVO.setLoanApplyDate(request.getParameter("loanApplyDate"));
//			System.out.println(loanVO.getLoanApplyDate());
			 loanVO.setCourse(request.getParameter("course"));
			 
			 loanVO.setCourseFee(Integer.parseInt(request.getParameter("courseFee")));
			//System.out.println(loanVO.getCourseFee());
			 loanVO.setFatherName(request.getParameter("fathersName"));
			 
			 loanVO.setFatherOccupation(request.getParameter("fathersOccupation"));
			 loanVO.setFatherTotalExperience(request.getParameter("fathersTotalExperience"));
			 
			 loanVO.setFatherTotalExperienceWithCurrentCompany(Integer.parseInt(request.getParameter("fathersTotalExpWithCurrentCompany")));
			 
		 loanVO.setRationCardNumber(request.getParameter("rationCardNumber"));
		 loanVO.setAnnualIncome(Integer.parseInt(request.getParameter(("annualIncome"))));
		
		 loanVO.setDuration(Integer.parseInt((request.getParameter("duration"))));
		 //System.out.println("loan vo is "+loanVO);
		 //System.out.println("before");
		String s =  loanBO.eMIEduCalculation(loanVO);
		 //System.out.println("after");
		 //String s=loanBO.generateLoanID();
		double d1=loanBO.emivalueEdu(loanVO);
		 session.setAttribute("d1", d1);
		 session.setAttribute("LoanID", s);
		dispatcher=request.getRequestDispatcher("LoanSuccess.jsp");
		dispatcher.forward(request, response);
		 }
		 
		 else if(loanType.equalsIgnoreCase("personal")){
			   
			 loanVO.setLoanType(loanType);
			 loanVO.setLoanAmount(Integer.parseInt((request.getParameter("loanAmount"))));
			 loanVO.setLoanApplyDate(request.getParameter("loanApplyDate"));
			 loanVO.setDuration(Integer.parseInt((request.getParameter("duration"))));
			 loanVO.setAnnualIncome(Integer.parseInt(request.getParameter(("annualIncome"))));
			 loanVO.setDesignation(request.getParameter("designation"));
			 loanVO.setMyExperiencewithCurrentCompany(Integer.parseInt(request.getParameter("totalExperience")));
			 loanVO.setMyExperiencewithCurrentCompany(Integer.parseInt(request.getParameter("myExperienceWithCurrentCompany")));
			 loanVO.setCompany(request.getParameter("company"));
			 loanVO.setGuarenteerName(request.getParameter("guaranteerName"));
			 loanVO.setGuarenteerAddress(request.getParameter("guaranteerAddress"));
			 loanVO.setGuarenteerIncome(request.getParameter("guaranteerIncome"));
			 
			 double d2=loanBO.emivaluePer(loanVO);
			
			 session.setAttribute("d2", d2);
			 String s=loanBO.eMIPersCalculation(loanVO);
			 session.setAttribute("LoanID", s);
				dispatcher=request.getRequestDispatcher("LoanSuccess.jsp");
				dispatcher.forward(request, response);
		 
		 }
	
	} catch (BMSException e) {
		// TODO Auto-generated catch block
		LOG.error("BMSException in LoanTypeController doGet() ");
//		e.printStackTrace();
		session.setAttribute("errmsg1", "Database Error ....");
		RequestDispatcher rd1=request.getRequestDispatcher("erroePage1.jsp");
		rd1.forward(request, response);
	} catch (BMSBussinessException e) {
		// TODO Auto-generated catch block
		LOG.error("BMSBussinessException in LoanTypeController doGet() ");
		e.printStackTrace();
		session.setAttribute("errmsg1", "Application Error ....");
		RequestDispatcher rd1=request.getRequestDispatcher("erroePage1.jsp");
		rd1.forward(request, response);
	}	 
		 
		//System.out.println("out of controller"); 
	LOG.info("Out of LoanTypeController doGet()");
	}

	

}
