package com.bms.vo;

import java.io.Serializable;

public class TransactionVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -219287534220296930L;
	
	// properties
	private String fromDate;
	private String toDate;
	private String transactionDate;
	private double debit;
	private double credit;
	private double balance;
	private String username;
	private String cusId;
	private String cusName;
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getDebit() {
		return debit;
	}
	public void setDebit(double debit) {
		this.debit = debit;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	private int transactionID;
	private String transactionType;
	private double transactionAmount;
	private double transactionAmountw;
	private double transactionAmountd;
	public double getTransactionAmountw() {
		return transactionAmountw;
	}
	public void setTransactionAmountw(double transactionAmountw) {
		this.transactionAmountw = transactionAmountw;
	}
	public double getTransactionAmountd() {
		return transactionAmountd;
	}
	public void setTransactionAmountd(double transactionAmountd) {
		this.transactionAmountd = transactionAmountd;
	}
	private int limit;
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
	

}
