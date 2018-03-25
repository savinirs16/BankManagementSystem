package com.bms.bo;

import java.util.HashMap;



import com.bms.dao.UpdateProfileDAO;
import com.bms.dao.UpdateProfileDAO;
import com.bms.exceptions.BMSException;
import com.bms.exceptions.BMSBussinessException;
import com.bms.exceptions.BMSException;
import com.bms.vo.UpdateProfileVO;
import org.apache.log4j.Logger;

public class UpdateProfileBO {

	public static final Logger LOG = Logger.getLogger("UpdateProfileBO");
	
public  UpdateProfileVO getCustomerdetails(String customerID) throws BMSException, BMSBussinessException {
	//LOG.info("Update profile getCustomerdaetails method  invoked");
	// TODO Auto-generated method stub
	//instantiate DAO
	LOG.info(" UpdateProfileBO getCustomerdetails() method got invoked");
	
	UpdateProfileDAO updateprofileDAO= new UpdateProfileDAO();	
	
	UpdateProfileVO updateprifileVO = updateprofileDAO.getCustomer(customerID);
	//System.out.println("leaving bo get customer");
	LOG.info("Out of  UpdateProfileBO getCustomerdetails() method");
	
	return updateprifileVO;
}

public int getupdateCustomerdetails(UpdateProfileVO updateprofileVO) throws BMSException,BMSBussinessException {
	//LOG.info("Update profile getupdatecustomerdetails method  invoked");
	//System.out.println("entered bo update customer");
	//System.out.println(" Customer id at BO is "+updateprofileVO.getCusid());
	LOG.info(" UpdateProfileBO getupdateCustomerdetails() method got invoked");
	
	UpdateProfileDAO updateprofileDAO= new UpdateProfileDAO();
	//return updateprofileDAO.getupdateCustomer(updateprofileVO);
	LOG.info("Out of  UpdateProfileBO getupdateCustomerdetails() method");
	return updateprofileDAO.getupdateCustomerdetails(updateprofileVO);
}


UpdateProfileDAO udao=null;

public HashMap<String, String> getCountryDetails() throws BMSException {
	// TODO Auto-generated method stub
	LOG.info(" UpdateProfileBO getCountryDetails() method got invoked");
	udao=new UpdateProfileDAO();
	LOG.info("Out of  UpdateProfileBO getCountryDetails() method");
	return udao.getCountryDetails();
}

public HashMap<String, String> getStateDetails() throws BMSException {
	// TODO Auto-generated method stub
	LOG.info(" UpdateProfileBO getStateDetails() method got invoked");
	udao=new UpdateProfileDAO();
	LOG.info("Out of  UpdateProfileBO getStateDetails() method");
	return udao.getStateDetails();
}
}




