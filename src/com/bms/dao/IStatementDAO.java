package com.bms.dao;

import java.util.ArrayList;
import java.util.List;


import com.bms.exceptions.BMSException;
import com.bms.vo.TransactionVO;

public interface IStatementDAO {
	
	
	// abstract method
	public List<TransactionVO> getTransaction(TransactionVO transactionVO) throws BMSException;

	
		
	
}
