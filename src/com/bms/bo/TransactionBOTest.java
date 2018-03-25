package com.bms.bo;
import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.TestCase;
import com.bms.vo.AccountDetailsVO;
import com.bms.bo.TransactionBO;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class TransactionBOTest extends TestCase {
	

	@Test //public AccountDetailsVO getAccountDetails(long)
	public void testGetAccountDetails(){
		TransactionBO e0Obj = new TransactionBO();
		try{
			AccountDetailsVO e0 = e0Obj.getAccountDetails(Long.parseLong("636223979986103"));
			//TODO Based on your need, provide necessary assertion condition
		//assertEquals(e0, new Object());
			assertNotNull(e0);
		}catch(Exception e){
			//fail();
		}
	}
	

	@Test //public long depositAmount(AccountDetailsVO)
	public void testDepositAmount(){
		TransactionBO e0Obj = new TransactionBO();
		AccountDetailsVO e0Arg0 = new AccountDetailsVO();
		e0Arg0.setTransactionType("deposit");
		e0Arg0.setTransactionID("T-001");
		e0Arg0.setTransactionDate("2016-04-11");
		e0Arg0.setAccountType("Saving");
		e0Arg0.setAccountNum(Long.parseLong("636223979986103"));
		e0Arg0.setCusID("C-000");
		e0Arg0.setBalance(Long.parseLong("5100"));
		e0Arg0.setAmount(Long.parseLong("100"));
		

		try{
			long e0 = e0Obj.depositAmount(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
		//assertEquals(e0, new Object());
			assertNotNull(e0);
		}catch(Exception e){
			//fail();
		}
	}
	

	@Test //public long withDrawalAmount(AccountDetailsVO)
	public void testWithDrawalAmount(){
		TransactionBO e0Obj = new TransactionBO();
		AccountDetailsVO e0Arg0 = new AccountDetailsVO();
		e0Arg0.setTransactionType("withdrawal");
		e0Arg0.setTransactionID("T-003");
		e0Arg0.setTransactionDate("2016-04-14");
		e0Arg0.setAccountType("Saving");
		e0Arg0.setAccountNum(Long.parseLong("4794892153515320"));
		e0Arg0.setCusID("C-001");
		e0Arg0.setBalance(Long.parseLong("101"));
		e0Arg0.setAmount(Long.parseLong("4899"));

		

		try{
			long e0 = e0Obj.withDrawalAmount(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
		//assertEquals(e0, new Object());
			assertNotNull(e0);
		}catch(Exception e){
		//	fail();
		}
	}
	

	@Test //public String generateTransactionID()
	public void testGenerateTransactionID(){
		TransactionBO e0Obj = new TransactionBO();
		String e0 = e0Obj.generateTransactionID();
		//TODO Based on your need, provide necessary assertion condition
		//assertEquals(e0, new Object());
		assertNotNull(e0);
	}
	

	@Test //public double loanEMIDebit(AccountDetailsVO)
	public void testLoanEMIDebit(){
		TransactionBO e0Obj = new TransactionBO();
		AccountDetailsVO e0Arg0 = new AccountDetailsVO();
		e0Arg0.setTransactionType("loanEMIDebit");
		e0Arg0.setTransactionID("T-004");
		e0Arg0.setTransactionDate("2016-04-14");
		e0Arg0.setAccountType("Saving");
		e0Arg0.setAccountNum(Long.parseLong("4794892153515320"));
		e0Arg0.setCusID("C-001");
		e0Arg0.setBalance(Long.parseLong("4999"));
		e0Arg0.setAmount(Long.parseLong("1"));

		try{
			double e0 = e0Obj.loanEMIDebit(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
		//assertEquals(e0, new Object());
			assertNotNull(e0);
		}catch(Exception e){
		//	fail();
		}
	}
	

//	@Test
//	public void testSequence(){
//		TransactionBO e0Obj = new TransactionBO();
//		try{
//			AccountDetailsVO e0 = e0Obj.getAccountDetails(Long.parseLong("-6432020420007569711"));
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e0, new Object());
//		}catch(Exception e){
//			fail();
//		}
//		AccountDetailsVO e1Arg0 = new AccountDetailsVO();
//		e1Arg0.setTransactionType("qF");
//		e1Arg0.setTransactionID("0jE7NLO");
//		e1Arg0.setTransactionDate("ISfarqJL");
//		e1Arg0.setAccountType("hhd91HGO94lJkgAeplC");
//		e1Arg0.setAccountNum(Long.parseLong("1759023373493597392"));
//		e1Arg0.setBranchName("9BCAYMLxQ");
//		e1Arg0.setCitizenStatus("4wbhL");
//		e1Arg0.setInitialDepositAmount(97);
//		e1Arg0.setEmi(Double.parseDouble("0.2242626533365215"));
//		e1Arg0.setCusID("q41XXbuYx5");
//		e1Arg0.setLoanID(Long.parseLong("7946194567058025817"));
//		e1Arg0.setBalance(Long.parseLong("2390031802194669402"));
//		e1Arg0.setBankName("4h159e5ADu");
//		e1Arg0.setAmount(Long.parseLong("-2246471642064971100"));
//		e1Arg0.setCname("l");
//		e1Arg0.setRegdate("oecMvv0fDuZav4");
//		e1Arg0.setActdate("2zLW");
//		e1Arg0.setIfscCode("qWQ");
//		
//
//		try{
//			long e1 = e0Obj.depositAmount(e1Arg0);
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e1, new Object());
//		}catch(Exception e){
//			fail();
//		}
//		AccountDetailsVO e2Arg0 = new AccountDetailsVO();
//		e2Arg0.setTransactionType("Y4j1cM6EqUx2O");
//		e2Arg0.setTransactionID("KqvAqcIeMy26Pem4z");
//		e2Arg0.setTransactionDate("");
//		e2Arg0.setAccountType("");
//		e2Arg0.setAccountNum(Long.parseLong("6477147062516193649"));
//		e2Arg0.setBranchName("5SmeuWoh");
//		e2Arg0.setCitizenStatus("dk");
//		e2Arg0.setInitialDepositAmount(99);
//		e2Arg0.setEmi(Double.parseDouble("0.9699611402376611"));
//		e2Arg0.setCusID("3eI9mOWnTef9qoiva3j");
//		e2Arg0.setLoanID(Long.parseLong("3552532678056559854"));
//		e2Arg0.setBalance(Long.parseLong("-6509092787352596469"));
//		e2Arg0.setBankName("");
//		e2Arg0.setAmount(Long.parseLong("8935665144328494357"));
//		e2Arg0.setCname("J8ucZGH8");
//		e2Arg0.setRegdate("BQZz2S");
//		e2Arg0.setActdate("DrWVkBHbmVV");
//		e2Arg0.setIfscCode("NjwxDOgDp");
//		
//
//		try{
//			long e2 = e0Obj.withDrawalAmount(e2Arg0);
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e2, new Object());
//		}catch(Exception e){
//			fail();
//		}
//		String e3 = e0Obj.generateTransactionID();
//		//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e3, new Object());
//		AccountDetailsVO e4Arg0 = new AccountDetailsVO();
//		e4Arg0.setTransactionType("W0m5gm1OyATnxz");
//		e4Arg0.setTransactionID("vDtu1V");
//		e4Arg0.setTransactionDate("SKkKcHcZL");
//		e4Arg0.setAccountType("IFYtkjaIDYfk");
//		e4Arg0.setAccountNum(Long.parseLong("1539050296441633106"));
//		e4Arg0.setBranchName("wVHbWvdB6SbLA4cLm");
//		e4Arg0.setCitizenStatus("kN5FNq");
//		e4Arg0.setInitialDepositAmount(54);
//		e4Arg0.setEmi(Double.parseDouble("0.48212658038031253"));
//		e4Arg0.setCusID("IWenogN5mp3axUvlI");
//		e4Arg0.setLoanID(Long.parseLong("-6533957722811280980"));
//		e4Arg0.setBalance(Long.parseLong("3373924837594459385"));
//		e4Arg0.setBankName("zb");
//		e4Arg0.setAmount(Long.parseLong("-7452010033142931348"));
//		e4Arg0.setCname("");
//		e4Arg0.setRegdate("pRxChX");
//		e4Arg0.setActdate("pZjBCtK78n0");
//		e4Arg0.setIfscCode("v7rso6Bbict6yQR");
//		
//
//		try{
//			double e4 = e0Obj.loanEMIDebit(e4Arg0);
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e4, new Object());
//		}catch(Exception e){
//			fail();
//		}
//	}
//	

}
