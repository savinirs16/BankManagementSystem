package com.bms.bo;



import java.text.ParseException;

import com.bms.dao.TransactionDAO;
import com.bms.exceptions.BMSBussinessException;
import com.bms.exceptions.BMSException;

import com.bms.vo.AccountDetailsVO;
import org.apache.log4j.Logger;



public class TransactionBO {
	public static final Logger LOG = Logger.getLogger("Transaction");
	
	TransactionDAO transactionDAO=new TransactionDAO();  
	long balance;

	//static int transID = 0;

	public AccountDetailsVO getAccountDetails(long accNumber) throws BMSException {
		// TODO Auto-generated method stub
		
		LOG.info("TransactionBO getAccountDetails() method got invoked ");
		
		AccountDetailsVO accountDetailsVO = transactionDAO.getAccDetails(accNumber);
		balance = accountDetailsVO.getBalance();
		String transID=generateTransactionID();
		accountDetailsVO.setTransactionID(transID);
		LOG.info("Out of TransactionBO getAccountDetails() method");
		return accountDetailsVO;
	}
	public String generateTransactionID(){
		LOG.info("TransactionBO generateTransactionID() method got invoked ");
		//   
		   String ID=null;
			//System.out.println("IN BO generateTRansactioID");
			String transID=transactionDAO.getTransactioID();
//			System.out.println("into gentrans id bo");
//			System.out.println("transaction ID came from DB"+transID);
			String[] transid=transID.split("-");
			
			int count=Integer.parseInt(transid[1]);
			
			
			count++;
			//System.out.println("In generate TransactionID");
			//TransactionBO.transID++;
			if(count<=10)
			{
			ID = "T-" + "00" +count;
		  //System.out.println(ID);
			}
			else{
			ID= "T-" + "0" +count;
			}
		  //System.out.println("out of method");
			LOG.info("Out of TransactionBO generateTransactionID() method");
			
			return  ID;
		}



	public long depositAmount(AccountDetailsVO accountDetailsVO) throws BMSException, BMSBussinessException, ParseException {
		// TODO Auto-generated method stub
		
		LOG.info("TransactionBO depositAmount() method got invoked ");
		String transactionID =null;
		
		transactionID = generateTransactionID();
		
		if(transactionID==null){
			throw new BMSBussinessException();
		}else{
		
		long final_amount = balance+accountDetailsVO.getAmount();
		
		accountDetailsVO.setTransactionID(transactionID);
		accountDetailsVO.setBalance(final_amount);
		
		boolean result = transactionDAO.depositAmount(accountDetailsVO);
		LOG.info("Out of TransactionBO depositAmount() method");
		if(result){
			return final_amount;
			
		}else{
			throw new BMSBussinessException();
		}
	
		
		}
	}
	
public long withDrawalAmount(AccountDetailsVO accountDetailsVO) throws BMSBussinessException, BMSException{
	LOG.info("TransactionBO withDrawalAmount() method got invoked ");
    String transactionID =null;
	
	transactionID = generateTransactionID();
	
	if(transactionID==null){
		throw new BMSBussinessException();
	}
	else if(balance>=accountDetailsVO.getAmount()){
	
	long final_amount = balance-accountDetailsVO.getAmount();
	
	accountDetailsVO.setTransactionID(transactionID);
	accountDetailsVO.setBalance(final_amount);
	
	boolean result = transactionDAO.withdrawalAmount(accountDetailsVO);
	LOG.info("Out of TransactionBO withDrawalAmount() method ");
	if(result){
		return final_amount;
		
	}else{
		throw new BMSBussinessException("Insufficient funds");
	}

	}else
	{
		throw new BMSBussinessException("Insufficient funds");
	}
	
}

public double loanEMIDebit(AccountDetailsVO accountDetailsVO) throws BMSBussinessException, BMSException, ParseException{
	
	LOG.info("TransactionBO loanEMIDebit() method got invoked ");
     String transactionID =null;
	
	transactionID = generateTransactionID();
	
	if(transactionID==null){
		throw new BMSBussinessException();
	}
	else if(balance>accountDetailsVO.getAmount())
	{
		long final_amount= balance-accountDetailsVO.getAmount();
		
		accountDetailsVO.setTransactionID(transactionID);
		accountDetailsVO.setBalance(final_amount);
	
       boolean result = transactionDAO.loanEMIDebit(accountDetailsVO);
       LOG.info("Out of TransactionBO loanEMIDebit() method ");
	if(result){
		return final_amount;
		
	}else{
		throw new BMSBussinessException("Insufficient funds");
	}

	}else
	{
		throw new BMSBussinessException("Insufficient funds");
	}
}
}