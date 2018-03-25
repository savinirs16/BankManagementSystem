package com.bms.bo;

import com.bms.dao.LoanDAO;

import com.bms.exceptions.BMSBussinessException;
import com.bms.exceptions.BMSException;
import com.bms.vo.LoanVO;
import org.apache.log4j.Logger;

public class LoanBO {
	public static final Logger LOG = Logger.getLogger("LoanBO");
	
//Edu EMI
	public String eMIEduCalculation(LoanVO loanVO) throws BMSException, BMSBussinessException{
		
		LOG.info("LoanBO eMIEduCalculation() method got invoked ");
	String loanID = generateLoanID();
	loanVO.setLoanid(loanID);
	//System.out.println("entered edu BO");
	int p = loanVO.getLoanAmount();
	int n = loanVO.getDuration();
	//int r = (int) loanVO.getE();
	
	
	
 	double temp = 1200; 			    
	
	 
    //(r/12)
	double interestPerMonth = 9/temp;       

    //(1+r/12)
    double onePlusInterestPerMonth = 1 + interestPerMonth;    

    //(1+r/12)^n)
    double powerOfOnePlusInterestPerMonth = Math.pow(onePlusInterestPerMonth,n);    

    //(1+r/12)^n - 1)-den
    double powerofOnePlusInterestPerMonthMinusOne = powerOfOnePlusInterestPerMonth-1;       

   //(1+r/12)^n - 1)
    double divides = powerOfOnePlusInterestPerMonth/powerofOnePlusInterestPerMonthMinusOne;    
	
    //(p*r)
    double principleMultiplyInterestPerMonth = p * interestPerMonth;        
 
    //(p*r)*(1+r/12)^n - 1)
    double totalEmi =  principleMultiplyInterestPerMonth*divides;        
			    
    double Emi = Math.round( totalEmi * 100.0 ) / 100.0;     
		
    loanVO.setEmi(Emi);
	
   
    LoanDAO loanDAO=new LoanDAO();
   //System.out.println("before calling dao");
    loanDAO.issueLoan1(loanVO);
    //System.out.println("after calling dao");
   LOG.info("Out of LoanBO eMIEduCalculation() method ");
    return loanID;
}

	//Personal EMI
	
	public String eMIPersCalculation(LoanVO loanVO) throws BMSException, BMSBussinessException{
		
		LOG.info("LoanBO eMIPersCalculation() method got invoked ");
	//System.out.println("Entering personal BO");
	int p = loanVO.getLoanAmount();
	int n = loanVO.getDuration();
	//int r = (int) loanVO.getP();
	
	String loanID = generateLoanID();
	
 	double temp = 1200; 			    
	
	 
    //(r/12)
	double interestPerMonth = 11/temp;       

    //(1+r/12)
    double onePlusInterestPerMonth = 1 + interestPerMonth;    

    //(1+r/12)^n)
    double powerOfOnePlusInterestPerMonth = Math.pow(onePlusInterestPerMonth,n);    

    //(1+r/12)^n - 1)-den
    double powerofOnePlusInterestPerMonthMinusOne = powerOfOnePlusInterestPerMonth-1;       

   //(1+r/12)^n - 1)
    double divides = powerOfOnePlusInterestPerMonth/powerofOnePlusInterestPerMonthMinusOne;    
	
    //(p*r)
    double principleMultiplyInterestPerMonth = p * interestPerMonth;        
 
    //(p*r)*(1+r/12)^n - 1)
    double totalEmi =  principleMultiplyInterestPerMonth*divides;        
			    
    double Emi = Math.round( totalEmi * 100.0 ) / 100.0;     
		
    loanVO.setEmi(Emi);
	
    //System.out.println("Exiting Per BO");
    // call DAo method by passing LoanVO after updated EMI
    String loanid=generateLoanID();
    loanVO.setLoanid(loanid);
    LoanDAO loanDAO=new LoanDAO();
    
    loanDAO.issueLoan1(loanVO);
    LOG.info(" Out of LoanBO eMIPersCalculation() method");
    return loanID;
    
}
	

	

	
	public  double emivalueEdu(LoanVO loanVO) throws BMSException, BMSBussinessException{
		// TODO Auto-generated method stub
		LOG.info("LoanBO emivalueEdu() method got invoked ");
	//	System.out.println("in emi edu");
		int p = loanVO.getLoanAmount();
		int n = loanVO.getDuration();
		//int r = (int) loanVO.getE();
		
		
		
	 	double temp = 1200; 			    
		
		 
	    //(r/12)
		double interestPerMonth = 9/temp;       

	    //(1+r/12)
	    double onePlusInterestPerMonth = 1 + interestPerMonth;    

	    //(1+r/12)^n)
	    double powerOfOnePlusInterestPerMonth = Math.pow(onePlusInterestPerMonth,n);    

	    //(1+r/12)^n - 1)-den
	    double powerofOnePlusInterestPerMonthMinusOne = powerOfOnePlusInterestPerMonth-1;       

	   //(1+r/12)^n - 1)
	    double divides = powerOfOnePlusInterestPerMonth/powerofOnePlusInterestPerMonthMinusOne;    
		
	    //(p*r)
	    double principleMultiplyInterestPerMonth = p * interestPerMonth;        
	 
	    //(p*r)*(1+r/12)^n - 1)
	    double totalEmi =  principleMultiplyInterestPerMonth*divides;        
				    
	    double Emi = Math.round( totalEmi * 100.0 ) / 100.0;
	    LOG.info("Out of LoanBO emivalueEdu() method");
	    return Emi;
	    
		}
		
	public  double emivaluePer(LoanVO loanVO) throws BMSException, BMSBussinessException{
		
		LOG.info("LoanBO emivaluePer() method got invoked ");
		int p = loanVO.getLoanAmount();
		int n = loanVO.getDuration();
		//int r = (int) loanVO.getP();
		
		String loanID = generateLoanID();
		
	 	double temp = 1200; 			    
		
		 
	    //(r/12)
		double interestPerMonth = 11/temp;       

	    //(1+r/12)
	    double onePlusInterestPerMonth = 1 + interestPerMonth;    

	    //(1+r/12)^n)
	    double powerOfOnePlusInterestPerMonth = Math.pow(onePlusInterestPerMonth,n);    

	    //(1+r/12)^n - 1)-den
	    double powerofOnePlusInterestPerMonthMinusOne = powerOfOnePlusInterestPerMonth-1;       

	   //(1+r/12)^n - 1)
	    double divides = powerOfOnePlusInterestPerMonth/powerofOnePlusInterestPerMonthMinusOne;    
		
	    //(p*r)
	    double principleMultiplyInterestPerMonth = p * interestPerMonth;        
	 
	    //(p*r)*(1+r/12)^n - 1)
	    double totalEmi =  principleMultiplyInterestPerMonth*divides;        
				    
	    double Emi = Math.round( totalEmi * 100.0 ) / 100.0; 
	    
	    LOG.info(" Out of LoanBO emivaluePer() method");
		return Emi;
	}
		
	

	
	
	
	
	public String generateLoanID(){
		LOG.info("LoanBO generateLoanID() method got invoked ");
	String loan_id=null;
	int countLoanId; 
	LoanDAO countLoanIDDAO = new LoanDAO();
	//System.out.println("before calling dap in gen");
	countLoanId=countLoanIDDAO.getLoanRecordsCount();
	if(countLoanId<10){
		loan_id="L-"+"00"+countLoanId;
	}else if(countLoanId>=10&&countLoanId<100){
		loan_id="L-"+"0"+countLoanId;
	}else
		loan_id="L-"+countLoanId;
	
	LOG.info("Out of LoanBO generateLoanID() method");
	return loan_id;
		
	}
}
