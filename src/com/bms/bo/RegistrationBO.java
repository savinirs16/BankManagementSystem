package com.bms.bo;

import java.text.ParseException;
import java.util.HashMap;


import com.bms.dao.*;
import com.bms.exceptions.BMSBussinessException;
import com.bms.exceptions.BMSException;
import com.bms.vo.RegistrationVO;
import com.bms.dao.RegistrationDao;
import com.bms.exceptions.BMSException;
import com.bms.exceptions.BMSException;
import org.apache.log4j.Logger;

public class RegistrationBO {


	public static final Logger LOG=Logger.getLogger("RegistrationBO  method invoked");
	
	
	String custID;
	long accNum;
	RegistrationDao registrationDao=null;
	
	public String registerCustomer(RegistrationVO registrationVO) throws BMSException, ParseException, BMSBussinessException{
		LOG.info("RegistrationBO registerCustomer() method got invoked ");
		//System.out.println("in register cust");
		custID = generateCustId();
		accNum = getAccountNum();
		registrationVO.setCusID(custID);
		registrationVO.setAccountNum(accNum);
		//System.out.println(registrationVO.getCusID());
		
		// validate userName
		
		
		
		RegistrationDao registrationDAO=new RegistrationDao();
		//System.out.println("before calling insert method");
		boolean result = registrationDAO.insertDetails(registrationVO);
		//System.out.println("after insert method");
		
		LOG.info("Out of RegistrationBO registerCustomer() method ");
		if(result){
			//System.out.println("leaving reg cust ");
			
			return custID;
			
		}else{
			
			throw new BMSBussinessException();
			
			
		}
		
		
	}

	

	public HashMap<String, String> getCountryDetails() throws BMSException {
		// TODO Auto-generated method stub
		
		LOG.info("RegistrationBO getCountryDetails() method got invoked ");
		registrationDao=new RegistrationDao();
		LOG.info("Out of RegistrationBO getCountryDetails() method");
		return registrationDao.getCountryDetails();
	}
	
	public HashMap<String, String> getStateDetails() throws BMSException {
		// TODO Auto-generated method stub
		LOG.info("RegistrationBO getStateDetails() method got invoked ");
		registrationDao=new RegistrationDao();
		LOG.info("Out of RegistrationBO getStateDetails() method");
		return registrationDao.getStateDetails();
	}
	
	public String generateCustId(){
		
		LOG.info("RegistrationBO generateCustId() method got invoked ");
		//System.out.println(" Flow came to RegistartionBO - generateCustID method");

		int countcustId;
	
		//instantiate dao object
		RegistrationDao registrationdao=new RegistrationDao();
		
		countcustId= registrationdao.getCustCount();
		//System.out.println(custId);


		String custId;
		if(countcustId<10)
		{
			 custId = "C-"+"00"+(countcustId);
		}
		else{
			custId="C-"+"0"+(countcustId);
		}
		//System.out.println(" Flow returning to Registartion controller");
		LOG.info("Out of RegistrationBO generateCustId() method");
		return custId;
		
		
		
		
	}

	public long getAccountNum()
	{
		LOG.info("RegistrationBO getAccountNum() method got invoked ");
		//System.out.println("in bo acct");
		long accno = (long) (Math.random() * 10000000000000000L);
		
		//System.out.println("leaving aact");
		//System.out.println("number in bo is"+accno);
		LOG.info("out of RegistrationBO getAccountNum() method"); 
		return accno;

	
	}
}
