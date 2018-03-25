package com.bms.dao;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

import com.bms.constants.QueryConstants;
import com.bms.util.DBUtil;
import com.bms.exceptions.BMSException;
import com.bms.vo.AccountDetailsVO;


public class TransactionDAO {
	public static final Logger LOG = Logger.getLogger("TransactionDAO");
	// connection
	Connection connection = null;
	
	// ResultSet
	ResultSet resultSet = null; 
	// prepared statement
	PreparedStatement  pStatement1 = null; 
	PreparedStatement  pStatement2 = null; 
	PreparedStatement  pStatement3 = null; 
	PreparedStatement  pStatement4 = null;
	PreparedStatement  pStatement5 = null;
	PreparedStatement  pStatement6 = null;
	PreparedStatement  pStatement7 = null;
	PreparedStatement pStatement8  = null;
	PreparedStatement pStatement9= null;
	PreparedStatement pStatement10=null;
	//Statement statement=null;
	//private long amount;
	List<AccountDetailsVO> accountDetailsList = new ArrayList<AccountDetailsVO>();
	AccountDetailsVO accountDetailsVO = null;
	boolean result;
	
	
	
	
	

	public AccountDetailsVO getAccDetails(long accountNum) throws BMSException {
		LOG.info("TransactionDAO getAccDetails() method got invoked ");
		
		try {
			connection = DBUtil.getConnection();
			pStatement1 = connection.prepareStatement(QueryConstants.GET_ACCOUNTDETAILS);
			
			pStatement1.setLong(1, accountNum);
			
			resultSet = pStatement1.executeQuery();
			accountDetailsVO = new AccountDetailsVO();
			
			while(resultSet.next()){
				accountDetailsVO.setCusID(resultSet.getString(1));
				//System.out.println(accountDetailsVO.getCusID());
				accountDetailsVO.setCname(resultSet.getString(2));
				accountDetailsVO.setAccountNum(resultSet.getLong(3));
				accountDetailsVO.setBalance(resultSet.getLong(4));
				accountDetailsVO.setAccountType(resultSet.getString(5));
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("IOException in TransactionDAO getAccDetails() method "+e.getMessage());
			//e.printStackTrace();
			throw new BMSException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("SQLException in TransactionDAO getAccDetails() method "+e.getMessage());
			//e.printStackTrace();
			throw new BMSException();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOG.error("ClassNotFoundException in TransactionDAO getAccDetails() method "+e.getMessage());
			//e.printStackTrace();
			throw new BMSException();
		}finally{
			
			try {
				resultSet.close();
				pStatement1.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOG.error("SQLException in TransactionDAO getAccDetails() method "+e.getMessage());
				e.printStackTrace();
				throw new BMSException();
			}
			
		}
		LOG.info("Out of TransactionDAO getAccDetails() method ");
		
		return accountDetailsVO;
	}

	public String getTransactioID()
	 {
		//System.out.println("in dao id");
		LOG.info("TransactionDAO getTransactioID() method got invoked ");
		String transactionID=null;
		boolean result=false;
		try {
			connection = DBUtil.getConnection();
			pStatement10=connection.prepareStatement(QueryConstants.GET_TRANSACTION_ID);
			//System.out.println(resultSet);
			//pStatement10.setString(1,accountDetailsVO.getTransactionID());
			resultSet=pStatement10.executeQuery();
			while (resultSet.next()) {
				
				transactionID=resultSet.getString(1);
				break;
			}
			
					
			//System.out.println(transactionID);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("IOException in TransactionDAO getTransactioID() method"+e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("SQLException in TransactionDAO getTransactioID() method "+e.getMessage());
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOG.error("ClassNotFoundException in TransactionDAO getTransactioID() method "+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				pStatement10.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOG.error("SQLException in TransactionDAO getTransactioID() method "+e.getMessage());
				e.printStackTrace();
			}
			
		}
		
		//System.out.println("transaction id in DAO"+transactionID);
		LOG.info("Out of TransactionDAO getTransactioID() method");
		return transactionID;
		 
	 }
	 
	 
	
	public boolean depositAmount(AccountDetailsVO accountDetailsVO) throws BMSException, ParseException {
		// TODO Auto-generated method stub
		
		LOG.info("TransactionDAO depositAmount() method got invoked ");
		
		try {
			connection = DBUtil.getConnection();
			pStatement2 = connection.prepareStatement(QueryConstants.TRANSACTION_DEPOSIT);
			pStatement3 = connection.prepareStatement(QueryConstants.UPDATE_ACCOUNTDETAILS);
			
			pStatement2.setLong(1, accountDetailsVO.getAccountNum());
			pStatement2.setString(2, accountDetailsVO.getCname());
			pStatement2.setString(3, accountDetailsVO.getCusID());
			pStatement2.setString(4, accountDetailsVO.getAccountType());
			pStatement2.setString(5, accountDetailsVO.getTransactionID());
			pStatement2.setString(6, accountDetailsVO.getTransactionType());
			SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			//java.sql.Date date = new java.sql.Date((accountDetailsVO.getTransactionDate()).getTime());
			String d=accountDetailsVO.getTransactionDate();
		//	System.out.println(d);
			Date dt = sdf1.parse(d);
		//	System.out.println(dt);
			String newDate = sdf.format(dt);
		//	System.out.println(newDate);
			
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(newDate);
			
			//System.out.println("sqldate is"+date);
			pStatement2.setString(7, newDate);
			pStatement2.setLong(8, accountDetailsVO.getAmount());
			pStatement2.setLong(9, accountDetailsVO.getBalance());
			
			pStatement3.setLong(1, accountDetailsVO.getBalance());
			pStatement3.setLong(2, accountDetailsVO.getAccountNum());
			
			int count1 = pStatement2.executeUpdate();
			
			int count2 = pStatement3.executeUpdate();
			
			if(count1!=0 && count2!=0){
				
				result = true;
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("IOException in TransactionDAO depositAmount() method "+e.getMessage());
			e.printStackTrace();
			throw new BMSException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("SQLException in TransactionDAO depositAmount() method "+e.getMessage());
			e.printStackTrace();
			throw new BMSException();
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			LOG.error("ClassNotFoundException in TransactionDAO depositAmount() method "+e.getMessage());
			e.printStackTrace();
			throw new BMSException();
		}finally{
			
			try {
				resultSet.close();
				pStatement2.close();
				pStatement3.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOG.error("SQLException in TransactionDAO depositAmount() method "+e.getMessage());
				e.printStackTrace();
				throw new BMSException();
			}
			
		}
		
		LOG.info("Out of TransactionDAO depositAmount() method");
		return result;
	}
	
public boolean withdrawalAmount(AccountDetailsVO accountDetailsVO) throws BMSException {
	LOG.info("TransactionDAO withdrawalAmount() method got invoked ");
	
	try {
		connection = DBUtil.getConnection();
		pStatement4 = connection.prepareStatement(QueryConstants.TRANSACTION_WITHDRAWAL);
		pStatement5 = connection.prepareStatement(QueryConstants.UPDATE_ACCOUNTDETAILS);
		
		pStatement4.setLong(1, accountDetailsVO.getAccountNum());
		pStatement4.setString(2, accountDetailsVO.getCname());
		pStatement4.setString(3, accountDetailsVO.getCusID());
		pStatement4.setString(4, accountDetailsVO.getAccountType());
		pStatement4.setString(5, accountDetailsVO.getTransactionID());
		pStatement4.setString(6, accountDetailsVO.getTransactionType());
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//java.sql.Date date = new java.sql.Date((accountDetailsVO.getTransactionDate()).getTime());
		String d=accountDetailsVO.getTransactionDate();
	//	System.out.println(d);
		Date dt = sdf1.parse(d);
	//	System.out.println(dt);
		String newDate = sdf.format(dt);
//		System.out.println(newDate);
		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(newDate);
		
		//System.out.println("sqldate is"+date);
		pStatement4.setString(7, newDate);
		pStatement4.setLong(8, accountDetailsVO.getAmount());
		pStatement4.setLong(9, accountDetailsVO.getBalance());
		
		pStatement5.setLong(1, accountDetailsVO.getBalance());
		pStatement5.setLong(2, accountDetailsVO.getAccountNum());
		
		int count3 = pStatement4.executeUpdate();
		
		int count4 = pStatement5.executeUpdate();
		
		if(count3!=0 && count4!=0){
			
			result = true;
			
		}
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		LOG.error("IOException in TransactionDAO withdrawalAmount() method "+e.getMessage());
		//e.printStackTrace();
		throw new BMSException();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		LOG.error("SQLException in TransactionDAO withdrawalAmount() method "+e.getMessage());
		//e.printStackTrace();
		throw new BMSException();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		LOG.error("ClassNotFoundException in TransactionDAO withdrawalAmount() method "+e.getMessage());
		//e.printStackTrace();
		throw new BMSException();
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		LOG.error("ParseException in TransactionDAO withdrawalAmount() method "+e.getMessage());
		//e.printStackTrace();
	}finally{
		try {
			resultSet.close();
			pStatement4.close();
			pStatement5.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("SQLException in TransactionDAO withdrawalAmount() method "+e.getMessage());
			//e.printStackTrace();
			throw new BMSException();
		}
	}
	LOG.info("Out of TransactionDAO withdrawalAmount() method");
	return result;
	
}
	
public boolean loanEMIDebit(AccountDetailsVO accountDetailsVO) throws BMSException, ParseException{
	LOG.info("TransactionDAO loanEMIDebit() method got invoked ");
	
	try {
		connection = DBUtil.getConnection();
		//pStatement6 = connection.prepareStatement(QueryConstants.TRANSACTION_LOANDETAILS);
		pStatement7 = connection.prepareStatement(QueryConstants.TRANSACTION_LOANEMIDEBIT);
		pStatement8=connection.prepareStatement(QueryConstants.UPDATE_ACCOUNTDETAILS);
		
		//pStatement6.setLong(1, accountDetailsVO.getLoanID());
		//pStatement6.setDouble(2, accountDetailsVO.getEmi());
		//pStatement6.setString(1, accountDetailsVO.getCusID());
		
		pStatement7.setLong(1, accountDetailsVO.getAccountNum());
		pStatement7.setString(2, accountDetailsVO.getCname());
		pStatement7.setString(3, accountDetailsVO.getCusID());
		pStatement7.setString(4, accountDetailsVO.getAccountType());
		pStatement7.setString(5, accountDetailsVO.getTransactionID());
		pStatement7.setString(6, accountDetailsVO.getTransactionType());
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//java.sql.Date date = new java.sql.Date((accountDetailsVO.getTransactionDate()).getTime());
		String d=accountDetailsVO.getTransactionDate();
		//System.out.println(d);
		Date dt = sdf1.parse(d);
	//	System.out.println(dt);
		String newDate = sdf.format(dt);
	//	System.out.println(newDate);
		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(newDate);
		
		//System.out.println("sqldate is"+date);
		pStatement7.setString(7, newDate);
		pStatement7.setLong(8, accountDetailsVO.getAmount());
		//pStatement7.setLong(9, accountDetailsVO.getLoanID());
		pStatement7.setLong(9, accountDetailsVO.getBalance());
		
		
		pStatement8.setLong(1, accountDetailsVO.getBalance());
		pStatement8.setLong(2, accountDetailsVO.getAccountNum());
		
		//int count5 = pStatement6.executeQuery();
		
		int count6 = pStatement7.executeUpdate();
		
		int count7=pStatement8.executeUpdate();
		
		if(count6!=0 &&  count7!=0){
			
			result = true;
			
		}
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		LOG.error("IOException in TransactionDAO loanEMIDebit() method "+e.getMessage());
		//e.printStackTrace();
		throw new BMSException();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		LOG.error("SQLException in TransactionDAO loanEMIDebit() method "+e.getMessage());
		//e.printStackTrace();
		throw new BMSException();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		LOG.error("ClassNotFoundException in TransactionDAO loanEMIDebit() method "+e.getMessage());
		//e.printStackTrace();
		throw new BMSException();
	}finally{
		try {
			resultSet.close();
			//pStatement6.close();
			pStatement7.close();
			pStatement8.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("SQLException in TransactionDAO loanEMIDebit() method "+e.getMessage());
			e.printStackTrace();
			throw new BMSException();
		}
	}
	LOG.info("Out of TransactionDAO loanEMIDebit() method");
	return result;
	
}
}
