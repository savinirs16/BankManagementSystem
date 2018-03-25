package com.bms.bo;
import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.TestCase;
import com.bms.vo.LoginVO;
import com.bms.bo.LoginBO;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class LoginBOTest extends TestCase {
	

	@Test //public LoginVO data(LoginVO)
	public void testData(){
		LoginBO e0Obj = new LoginBO();
		LoginVO e0Arg0 = new LoginVO();
		e0Arg0.setPassword("Asdfg1234");
		e0Arg0.setUsername("vamshikrishna");
		e0Arg0.setCustid("C-000");
		e0Arg0.setAcctnum(Long.parseLong("636223979986103"));
		e0Arg0.setCname("vamshikrishna");
		e0Arg0.setBalance(5500);
		

		LoginVO e0 = e0Obj.data(e0Arg0);
		//TODO Based on your need, provide necessary assertion condition
		assertNotNull(e0);
	}
	

	@Test //public boolean validateUser(LoginVO)
	public void testValidateUser(){
		LoginBO e0Obj = new LoginBO();
		LoginVO e0Arg0 = new LoginVO();
		e0Arg0.setPassword("Asdfg1234");
		e0Arg0.setUsername("vamshikrishna");
		e0Arg0.setCustid(null);
		e0Arg0.setAcctnum(null);
		e0Arg0.setCname(null);
		e0Arg0.setBalance(0);
		

		boolean e0 = e0Obj.validateUser(e0Arg0);
		//TODO Based on your need, provide necessary assertion condition
		assertEquals(e0, true);
	}
	

//	@Test
//	public void testSequence(){
//		LoginBO e0Obj = new LoginBO();
//		LoginVO e0Arg0 = new LoginVO();
//		e0Arg0.setPassword("b5FOBGe");
//		e0Arg0.setUsername("cSnWyDe5NvP5aaIJt");
//		e0Arg0.setCustid("HjKOuqy5uZaI3F9Xb");
//		e0Arg0.setAcctnum(Long.parseLong("-7809874770357409441"));
//		e0Arg0.setCname("gq2L5ZY1OC");
//		e0Arg0.setBalance(48);
//		
//
//		LoginVO e0 = e0Obj.data(e0Arg0);
//		//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e0, new Object());
//		LoginVO e1Arg0 = new LoginVO();
//		e1Arg0.setPassword("hTtGuEl2in0BTrAmE");
//		e1Arg0.setUsername("Iz9OE71e6JkI");
//		e1Arg0.setCustid("t3xv7d2aelkV9OF");
//		e1Arg0.setAcctnum(Long.parseLong("-5320672278269611799"));
//		e1Arg0.setCname("R5");
//		e1Arg0.setBalance(-19);
//		
//
//		boolean e1 = e0Obj.validateUser(e1Arg0);
//		//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e1, new Object());
//	}
//	

}
