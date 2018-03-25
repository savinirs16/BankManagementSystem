package com.bms.constants;

public class QueryConstants {
 
	
	//Registration
	public static final String REGISTERLOGINDETAILS = "insert into login_details values(?,?,?)";
	public static final String REGISTERPERSONALDETAILS = "insert into personal_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String REGISTERACCOUNTDETAILS = "insert into account_details values(?,?,?,?,?,?,?,?,?,?)";
	public static final String REGISTERREFERENCEDETAILS = "insert into reference_details values(?,?,?,?)";
	public static final String INITIALDEPSAVING=" insert into initial_deposit_savings values(?,?)";
	public static final String IFSCCODE="select ifsc_code from branch_ifsc where branch_name=?";
	public static final String CUSTID = "select * from login_details";
	public static final String ACCT="update account set account_type=? ";
	
	
	/** Query for Country details. */
	public static final String COUNTRYDETAILS = "select * from country_details";
	
	/** The State details. */
	public static final String STATEDETAILS = "select * from state_details";
	
	
	//Statement Generations 
	
	public static final String GET_TRANSACTIONS1 ="select transaction_date, transaction_type, amount, balance from transaction_details where transaction_date between ? and ? and transaction_type=? and customer_id=?";
	public static final String GET_TRANSACTIONS3="Select transaction_date, transaction_type, amount, balance from transaction_details where transaction_date between ? and ? and customer_id=?";
	
	
	//Loan Queries... 
	public static final String REGISTER_LOAN = "insert into loan_details(customer_id,loan_id,loan_amount,loan_apply_date,rate_interest,duration,emi,loan_type) values(?,?,?,?,?,?,?,?)";
	
	public static final String EDUCATIONAL_LOAN = "insert into education_loan_details(loan_id,course_fee,course,fathername,fatheroccupation,fathertotexperience,fathercurexperience,ratncard_num,annual_income) values(?,?,?,?,?,?,?,?,?)";
	
	public static final String PERSONAL_LOAN="insert into personal_loan_details(loan_id,annual_income,company_name,designation,totexperience,curexperience) values(?,?,?,?,?,?)";

	public static final String LOANRECORDSCOUNT="select * from loan_details";
	
	//Login
	
	public static final String GET_USERLIST =" select customer_id,username,password from login_details";
	
	//getcusid
	public static final String GET_CUSID="select customer_id from login_details where username=? and password=?";
	
	
	//Accountnumber
	public static final String GET_ACCOUNTNUM="select account_num from account_details where customer_id=?";
	
	//balance
	public static final String GET_BALANCE="select balance from account_details where customer_id=?";
	
	//customer name 
	public static final String GET_NAME="select customername from personal_details where customer_id=?";

	
	//transactions
	
	public static final String GET_TRANSACTIONS="Select * from transaction_details ";
	public static final String GET_TRANSACTION_ID="SELECT transaction_id FROM transaction_details Order by transaction_id desc";
	public static final String transRecordsCount=  "select count(transaction_id) from transaction_details";
	public static final String GET_ACCOUNTDETAILS = "select ld.customer_id,pd.customername,ad.account_num,ad.balance,ad.account_type from personal_details pd,login_details ld,account_details ad where pd.customer_id=ld.customer_id and ld.customer_id=ad.customer_id and ad.account_num=?";
	
	
	public static final String TRANSACTION_DEPOSIT = "insert into transaction_details(account_num,customername,customer_id,account_type,transaction_id,transaction_type,transaction_date,amount,balance) values(?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_ACCOUNTDETAILS = "update account_details set balance = ? where account_num = ?"; 
	
	public static final String TRANSACTION_WITHDRAWAL="insert into transaction_details(account_num,customername,customer_id,account_type,transaction_id,transaction_type,transaction_date,amount,balance) values(?,?,?,?,?,?,?,?,?)";
	
	public static final String TRANSACTION_LOANDETAILS="select loan_id from loan_details where customer_id=?";
	public static final String TRANSACTION_LOANEMIDEBIT="insert into transaction_details values(?,?,?,?,?,?,?,?,?)";
	
	//update
	
	public static final String GET_CUSTOMER_DETAILS = " select l.customer_id,p.customername,p.guardian_type,p.guardian_name,p.address, p.citizenship,p.state,p.country,p.email,p.gender,p.marital_status,p.contactno,p.dob,p.proof_type,p.doc_num,r.reference_name,r.reference_num,r.reference_address,ad.account_num,ad.account_type,ad.branch_name,ad.registerdate,ad.citizen_status,b.ifsc_code from personal_details p,login_details l,account_details ad, country_details c,branch_ifsc b,reference_details r where l.customer_id=p.customer_id and l.customer_id=ad.customer_id and l.customer_id=r.customer_id and ad.ifsc_code=b.ifsc_code and l.customer_id=? ";
	public static final String SET_CUSTOMER="update personal_details p,account_details ad,login_details l set p.country=?,p.country_id=?,p.state=?, p.proof_type=?,p.doc_num=?, p.address=?, p.contactno=?,p.email=?, p.marital_status=?,ad.account_type=?, p.citizenship=?,p.guardian_type=?,  p.guardian_name=? where p.customer_id=l.customer_id and l.customer_id=ad.customer_id and p.customer_id='";
	
	
}
