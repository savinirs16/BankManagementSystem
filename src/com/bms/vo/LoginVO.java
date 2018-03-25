package com.bms.vo;

public class LoginVO {
private String username;
private String password;
private String custid;
private int balance;
private String cname;
private Long acctnum; 
 
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public Long getAcctnum() {
	return acctnum;
}
public void setAcctnum(Long acctnum) {
	this.acctnum = acctnum;
}
public String getUsername() {
return username;
}
public void setUsername(String username) {
this.username = username;
}
 
public String getCustid() {
	return custid;
}
public void setCustid(String custid) {
	this.custid = custid;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
}
