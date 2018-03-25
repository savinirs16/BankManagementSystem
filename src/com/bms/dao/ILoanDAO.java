package com.bms.dao;

import com.bms.exceptions.BMSException;
import com.bms.vo.LoanVO;

public interface ILoanDAO {
	public int issueLoan1(LoanVO loanVO) throws BMSException;
	public int getLoanRecordsCount();
}
