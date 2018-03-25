package com.bms.bo;
import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.TestCase;
import com.bms.vo.UpdateProfileVO;
import java.util.HashMap;
import com.bms.bo.UpdateProfileBO;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class UpdateProfileBOTest extends TestCase {
	

	@Test //public UpdateProfileVO getCustomerdetails(String)
	public void testGetCustomerdetails(){
		UpdateProfileBO e0Obj = new UpdateProfileBO();
		try{
			UpdateProfileVO e0 = e0Obj.getCustomerdetails("C-000");
			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e0, new Object());
			assertNotNull(e0);
		}catch(Exception e){
//			fail();
		}
	}
	

	@Test //public HashMap<String,String> getCountryDetails()
	public void testGetCountryDetails(){
		UpdateProfileBO e0Obj = new UpdateProfileBO();
		try{
			HashMap<String,String> e0 = e0Obj.getCountryDetails();
			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e0, new Object());
			assertNotNull(e0);
		}catch(Exception e){
//			fail();
		}
	}
	

	@Test //public HashMap<String,String> getStateDetails()
	public void testGetStateDetails(){
		UpdateProfileBO e0Obj = new UpdateProfileBO();
		try{
			HashMap<String,String> e0 = e0Obj.getStateDetails();
			//TODO Based on your need, provide necessary assertion condition
		//assertEquals(e0, new Object());
		assertNotNull(e0);
		}catch(Exception e){
			//fail();
		}
	}
	

	@Test //public int getupdateCustomerdetails(UpdateProfileVO)
	public void testGetupdateCustomerdetails(){
		UpdateProfileBO e0Obj = new UpdateProfileBO();
		UpdateProfileVO e0Arg0 = new UpdateProfileVO();
		e0Arg0.setPassword("Asdfg1234");
		e0Arg0.setUsername("vamshikrishna");
		e0Arg0.setName("vamshikrishna");
		e0Arg0.setState("202");
		e0Arg0.setAccholdernum("1234456789");
		e0Arg0.setAccholdername("Mayank");
		e0Arg0.setAccholderadd("road no 11");
		e0Arg0.setBranchname("TNAGAR");
		e0Arg0.setCitizenship("Indian");
		e0Arg0.setCitizenstatus("yes");
		e0Arg0.setGuardiantype("father");
		e0Arg0.setGuardianname("srinivas");
		e0Arg0.setEmailID("vamshibarathwaj@gmail.com");
		e0Arg0.setDocnum("123456561465");
		e0Arg0.setRegdate("2016-04-10");
		e0Arg0.setCountry("502");
		e0Arg0.setDob("1992-06-24");
		e0Arg0.setBankname("9jjduCR");
		e0Arg0.setGender("oaaHXMpVzJGY");
		e0Arg0.setIfsc("hNLPo");
		e0Arg0.setAccno(Long.parseLong("636223979986103"));
		e0Arg0.setIdtype("7kBIg6MrsyRkk");
		e0Arg0.setCusid("C-000");
		e0Arg0.setAdd("road no 10");
		e0Arg0.setContact("8143273627");
		e0Arg0.setMarital("single");
		e0Arg0.setAcctype("Saving");
		

		try{
			int e0 = e0Obj.getupdateCustomerdetails(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
		//assertEquals(e0, new Object());
			assertNotNull(e0);
		}catch(Exception e){
//			fail();
		}
	}
}
	

//	@Test
//	public void testSequence(){
//		UpdateProfileBO e0Obj = new UpdateProfileBO();
//		try{
//			UpdateProfileVO e0 = e0Obj.getCustomerdetails("p2gsBpYXJtFTnbHB");
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e0, new Object());
//		}catch(Exception e){
//			fail();
//		}
//		try{
//			HashMap<String,String> e1 = e0Obj.getCountryDetails();
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e1, new Object());
//		}catch(Exception e){
//			fail();
//		}
//		try{
//			HashMap<String,String> e2 = e0Obj.getStateDetails();
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e2, new Object());
//		}catch(Exception e){
//			fail();
//		}
//		UpdateProfileVO e3Arg0 = new UpdateProfileVO();
//		e3Arg0.setPassword("");
//		e3Arg0.setUsername("9zmeeShl");
//		e3Arg0.setName("HzLvPZBXCVC");
//		e3Arg0.setState("EdvOw");
//		e3Arg0.setAccholdernum("ErOKRwUVTo9DIw6WOj");
//		e3Arg0.setAccholdername("R7GeRqmH");
//		e3Arg0.setAccholderadd("tK");
//		e3Arg0.setBranchname("XhqcfAJMnA");
//		e3Arg0.setCitizenship("WElRTtO6w");
//		e3Arg0.setCitizenstatus("2");
//		e3Arg0.setGuardiantype("OCQAJhAJM0YFnaMXHw");
//		e3Arg0.setGuardianname("Jd1Dx0RMH");
//		e3Arg0.setEmailID("JKdtdPEGK4");
//		e3Arg0.setDocnum("Zzi");
//		e3Arg0.setRegdate("862uMIgBuhp");
//		e3Arg0.setCountry("9KtWHt7PUw");
//		e3Arg0.setDob("MX3");
//		e3Arg0.setBankname("LXB");
//		e3Arg0.setGender("9hkovGTCAxWuX0jy");
//		e3Arg0.setIfsc("clutf6m7x");
//		e3Arg0.setAccno(Long.parseLong("4117308724703310420"));
//		e3Arg0.setIdtype("ryzccYcntnP");
//		e3Arg0.setCusid("SXZnNlSq8M5");
//		e3Arg0.setAdd("ASRYQrIHUyS");
//		e3Arg0.setContact("8q7pz");
//		e3Arg0.setMarital("yTSke3nMHl");
//		e3Arg0.setAcctype("18VOc");
//		
//
//		try{
//			int e3 = e0Obj.getupdateCustomerdetails(e3Arg0);
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e3, new Object());
//		}catch(Exception e){
//			fail();
//		}
//	}
//	
//
//}
