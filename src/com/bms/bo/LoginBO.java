package com.bms.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.bms.dao.LoginDAO;
import com.bms.vo.LoginVO;

public class LoginBO {
	LoginDAO loginDAO=new LoginDAO();
	/**
	 * The Logger for logging the errors and info
	 */
	public static final Logger LOG = Logger.getLogger("LoginBO");
	public boolean validateUser(LoginVO loginVO){
		LOG.info("LoginBO initialized - validateUser method got invoked...");
		boolean b=false;
		//System.out.println("before list in BO");
		List<LoginVO> loginList=loginDAO.validateList(loginVO);
		//System.out.println("after BO list");
		for(LoginVO login:loginList)
		{
			//System.out.println("inside for each");
			if(loginVO.getUsername().equals(login.getUsername()) && loginVO.getPassword().equals(login.getPassword()))
					{
						b=true;
						break;
					}
		}
		
		LOG.info("Out of LoginBO validateUser method ");
		return b;
		
	}
	
	public LoginVO data(LoginVO loginVO)
	{
		
		LoginVO loginVO1=loginDAO.returndata(loginVO);
		
		
		return loginVO1;	
	}

	
}
