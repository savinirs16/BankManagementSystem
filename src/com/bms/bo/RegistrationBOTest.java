package com.bms.bo;
import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.TestCase;
import java.util.HashMap;
import com.bms.bo.RegistrationBO;
import com.bms.vo.RegistrationVO;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class RegistrationBOTest extends TestCase {
	

	@Test //public HashMap<String,String> getStateDetails()
	public void testGetStateDetails(){
		RegistrationBO e0Obj = new RegistrationBO();
		try{
			HashMap<String,String> e0 = e0Obj.getStateDetails();
			//TODO Based on your need, provide necessary assertion condition
		//assertEquals(e0, new Object());
			assertNotNull(e0);
		}catch(Exception e){
			//fail();
		}
	}
	

	@Test //public long getAccountNum()
	public void testGetAccountNum(){
		RegistrationBO e0Obj = new RegistrationBO();
		long e0 = e0Obj.getAccountNum();
		//TODO Based on your need, provide necessary assertion condition
		//assertEquals(e0, new Object());
		assertNotNull(e0);
	}
	

	@Test //public String registerCustomer(RegistrationVO)
	public void testRegisterCustomer(){
		RegistrationBO e0Obj = new RegistrationBO();
		RegistrationVO e0Arg0 = new RegistrationVO();
		e0Arg0.setName("vamshikrishna");
		e0Arg0.setState("202");
		e0Arg0.setDate("e");
		e0Arg0.setAddress("road no 10");
		e0Arg0.setBalance(5500);
		e0Arg0.setCitizenstatus("yes");
		e0Arg0.setBranchName("TNAGAR");
		e0Arg0.setRefaddress("road no 11");
		e0Arg0.setMaritalStatus("single");
		e0Arg0.setAccountNum(Long.parseLong("636223979986103"));
		e0Arg0.setCitizenship("Indian");
		e0Arg0.setIfsc_code("COGN0502001");
		e0Arg0.setCusID("C-000");
		e0Arg0.setUname("vamshikrishna");
		e0Arg0.setPass("Asdfg1234");
		e0Arg0.setRpass("Asdfg1234");
		e0Arg0.setGtype("father");
		e0Arg0.setGname("srinivas");
		e0Arg0.setGender("Male");
		e0Arg0.setEmail("vamshibarathwaj@gmail.com");
		e0Arg0.setContact("8143273627");
		e0Arg0.setDob("1992-06-24");
		e0Arg0.setAcctype("Saving");
		e0Arg0.setInidepamo(5000);
		e0Arg0.setIdproof("Vote card");
		e0Arg0.setIdnum("123456561465");
		e0Arg0.setRefname("Mayank");
		e0Arg0.setRefaccnum(Long.parseLong("1234456789"));
		e0Arg0.setCountry("502");
		

		try{
			String e0 = e0Obj.registerCustomer(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
		assertEquals(e0, new Object());
		}catch(Exception e){
			//fail();
		}
	}
	

	@Test //public HashMap<String,String> getCountryDetails()
	public void testGetCountryDetails(){
		RegistrationBO e0Obj = new RegistrationBO();
		try{
			HashMap<String,String> e0 = e0Obj.getCountryDetails();
			//TODO Based on your need, provide necessary assertion condition
		//assertEquals(e0, new Object());
			assertNotNull(e0);
		}catch(Exception e){
			//fail();
		}
	}
	

	@Test //public String generateCustId()
	public void testGenerateCustId(){
		RegistrationBO e0Obj = new RegistrationBO();
		String e0 = e0Obj.generateCustId();
		//TODO Based on your need, provide necessary assertion condition
		//assertEquals(e0, new Object());
		assertNotNull(e0);
	}
	

//	@Test
//	public void testSequence(){
//		RegistrationBO e0Obj = new RegistrationBO();
//		try{
//			HashMap<String,String> e0 = e0Obj.getStateDetails();
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e0, new Object());
//		}catch(Exception e){
//			fail();
//		}
//		long e1 = e0Obj.getAccountNum();
//		//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e1, new Object());
//		RegistrationVO e2Arg0 = new RegistrationVO();
//		e2Arg0.setName("CGCqkfTBBpIC1Cwlzd");
//		e2Arg0.setState("EznKrw1H");
//		e2Arg0.setDate("dgSmjnmS");
//		e2Arg0.setAddress("L6weAH3yiEGh5");
//		e2Arg0.setBalance(6);
//		e2Arg0.setCitizenstatus("Gb");
//		e2Arg0.setBranchName("CmYD8DignwT46fDz");
//		e2Arg0.setRefaddress("rxszc6r1Cy");
//		e2Arg0.setMaritalStatus("f3kBOQGBCLlkKNb2c");
//		e2Arg0.setAccountNum(Long.parseLong("-4692032645167481025"));
//		e2Arg0.setCitizenship("PYO7P75sKlJm");
//		e2Arg0.setIfsc_code("uvjy2z6qK1O");
//		e2Arg0.setCusID("pVSe");
//		e2Arg0.setUname("JoZaSyrdy");
//		e2Arg0.setPass("ks");
//		e2Arg0.setRpass("r6Rg96WRVbmkJthyHj");
//		e2Arg0.setGtype("");
//		e2Arg0.setGname("xSZ5OqMBWErYaBj");
//		e2Arg0.setGender("8Twwcsu0hUP");
//		e2Arg0.setEmail("pvdZyqVNdpX");
//		e2Arg0.setContact("NeOQRAw8AY");
//		e2Arg0.setDob("4Nia9c0Po");
//		e2Arg0.setAcctype("f");
//		e2Arg0.setInidepamo(-24);
//		e2Arg0.setIdproof("JzsB2oIW");
//		e2Arg0.setIdnum("n");
//		e2Arg0.setRefname("sdZ0T1E");
//		e2Arg0.setRefaccnum(Long.parseLong("2567055494209453666"));
//		e2Arg0.setCountry("rB");
//		
//
//		try{
//			String e2 = e0Obj.registerCustomer(e2Arg0);
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e2, new Object());
//		}catch(Exception e){
//			fail();
//		}
//		try{
//			HashMap<String,String> e3 = e0Obj.getCountryDetails();
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e3, new Object());
//		}catch(Exception e){
//			fail();
//		}
//		String e4 = e0Obj.generateCustId();
//		//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e4, new Object());
//	}
	

}
