package com.bms.bo;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

import com.bms.dao.StatementDAO;
//import com.bms.exceptions.BMSBusinessException;
import com.bms.exceptions.*;
import com.bms.vo.TransactionVO;
import com.bms.exceptions.BMSException;
import com.bms.exceptions.BMSBussinessException;


public class StatementBO {
	public static final Logger LOG = Logger.getLogger("StatementBO");
	StatementDAO statementDAO = new StatementDAO();	
	// method
	List<TransactionVO> transactionList = null;
	public List<TransactionVO> generateStatement(TransactionVO transactionVO) throws BMSException, BMSBussinessException , ParseException{
		LOG.info(" StatementBO generateStatement() method got invoked");
		String f1=transactionVO.getFromDate();
		String t1=transactionVO.getToDate();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Date d1=sdf.parse(f1);
		Date d2=sdf.parse(t1);
		if(d1.before(d2))
		{
			//System.out.println(" Flow came to BO");
			String uName=transactionVO.getUsername();
			//System.out.println(uName);
			// invoke getTransaction method of SatementDAO by passing TransactionVO obejct as argument
			
			transactionList = statementDAO.getTransaction(transactionVO);
			int n=transactionList.size();
			if(n<=0){				
				throw new BMSBussinessException("No Transactions Found between these dates");
		}
		}
		else
		{
			//System.out.println("in else");
			throw new BMSBussinessException("ToDate cannot be greater than FromDate");
		}
		LOG.info("Out of UpdateProfileBO generateStatement() method"); 
		return transactionList;	
	}
}
