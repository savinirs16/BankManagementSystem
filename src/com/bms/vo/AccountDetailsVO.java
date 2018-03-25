package com.bms.vo;



public class AccountDetailsVO {

	//data members for account details
private String customerID;
private String accountType;
private long accountNumber;
private int initialDA;
private String branchName;
private String bankName;
private String ifscCode;
private String registereddate;
private String actualdate;
private String citizenStatus;


//data members for transaction details

private String transactionDate;
private String customername;
private String transactionType;
private String transactionID;
private long balance;
private long amount;
private long loanID;
private double emi;

 


public double getEmi() {
	return emi;
}
public void setEmi(double emi) {
	this.emi = emi;
}
public long getLoanID() {
	return loanID;
}
public void setLoanID(long loanID) {
	this.loanID = loanID;
}
//public Date getTransactionDate() {
//	return transactionDate;
//}
//public void setTransactionDate(Date transactionDate) {
//	this.transactionDate = transactionDate;
//}


public String getTransactionID() {
	return transactionID;
}
public String getTransactionDate() {
	return transactionDate;
}
public void setTransactionDate(String transactionDate) {
	this.transactionDate = transactionDate;
}
public void setTransactionID(String transactionID) {
	this.transactionID = transactionID;
}



public String getCusID() {
	return customerID;
}
public void setCusID(String cusID) {
	this.customerID = cusID;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public long getAccountNum() {
	return accountNumber;
}
public void setAccountNum(long accountNum) {
	this.accountNumber = accountNum;
}
public int getInitialDepositAmount() {
	return initialDA;
}
public void setInitialDepositAmount(int initialDepositAmount) {
	this.initialDA = initialDepositAmount;
}
public String getBranchName() {
	return branchName;
}
public void setBranchName(String branchName) {
	this.branchName = branchName;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public String getIfscCode() {
	return ifscCode;
}
public void setIfscCode(String ifscCode) {
	this.ifscCode = ifscCode;
}
public String getRegdate() {
	return registereddate;
}
public void setRegdate(String regdate) {
	this.registereddate = regdate;
}
public String getActdate() {
	return actualdate;
}
public void setActdate(String actdate) {
	this.actualdate = actdate;
}
public String getCitizenStatus() {
	return citizenStatus;
}
public void setCitizenStatus(String citizenStatus) {
	this.citizenStatus = citizenStatus;
}
public String getCname() {
	return customername;
}
public void setCname(String cname) {
	this.customername = cname;
}
public String getTransactionType() {
	return transactionType;
}
public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}
public long getBalance() {
	return balance;
}
public void setBalance(long balance) {
	this.balance = balance;
}
public long getAmount() {
	return amount;
}
public void setAmount(long amount) {
	this.amount = amount;
}


 
	
	 
	
}
