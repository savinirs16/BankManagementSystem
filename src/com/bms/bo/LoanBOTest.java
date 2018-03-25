package com.bms.bo;
import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.TestCase;
import com.bms.vo.LoanVO;
import com.bms.bo.LoanBO;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class LoanBOTest extends TestCase {
	

	@Test //public String eMIEduCalculation(LoanVO)
	public void testEMIEduCalculation(){
		LoanBO e0Obj = new LoanBO();
		LoanVO e0Arg0 = new LoanVO();
		e0Arg0.setMyExperiencewithCurrentCompany(78);
		e0Arg0.setFatherName("Ram");
		e0Arg0.setFatherOccupation("Govt emp");
		e0Arg0.setLoanApplyDate("2016-07-01");
		e0Arg0.setLoanAmount(25000);
		e0Arg0.setRationCardNumber("123654asd");
		e0Arg0.setAnnualIncome(1200000);
		e0Arg0.setFatherTotalExperience("25");
		e0Arg0.setP(11);
		e0Arg0.setE(9);
		e0Arg0.setCustid("C-000");
		e0Arg0.setCourse("ece");
		e0Arg0.setLoanid("L-001");
		e0Arg0.setDuration(5);
		e0Arg0.setLoanType("educational");
		e0Arg0.setCourseFee(2500);
		e0Arg0.setEmi(Double.parseDouble("5113.06"));
		e0Arg0.setFatherTotalExperienceWithCurrentCompany(10);
		

		try{
			String e0 = e0Obj.eMIEduCalculation(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e0, new Object());
			assertNotNull(e0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public String generateLoanID()
	public void testGenerateLoanID(){
		LoanBO e0Obj = new LoanBO();
		String e0 = e0Obj.generateLoanID();
		//TODO Based on your need, provide necessary assertion condition
		assertNotNull(e0);
	}
	

	@Test //public String eMIPersCalculation(LoanVO)
	public void testEMIPersCalculation(){
		LoanBO e0Obj = new LoanBO();
		LoanVO e0Arg0 = new LoanVO();
		e0Arg0.setMyExperiencewithCurrentCompany(1);
		e0Arg0.setDesignation("pat");
		e0Arg0.setLoanApplyDate("2016-01-01");
		e0Arg0.setLoanAmount(25000);
		e0Arg0.setTotalExperience(1);
		e0Arg0.setAnnualIncome(25000);
		e0Arg0.setP(11);
		e0Arg0.setE(9);
		e0Arg0.setCustid("C-000");
		e0Arg0.setCourse("ece");
		e0Arg0.setLoanid("L-004");
		e0Arg0.setCompany("cts");
		e0Arg0.setDuration(5);
		e0Arg0.setLoanType("personal");
		e0Arg0.setEmi(Double.parseDouble("5138.34"));

		

		try{
			String e0 = e0Obj.eMIPersCalculation(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
		//assertEquals(e0, new Object());
			assertNotNull(e0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public double emivalueEdu(LoanVO)
	public void testEmivalueEdu(){
		LoanBO e0Obj = new LoanBO();
		LoanVO e0Arg0 = new LoanVO();
		e0Arg0.setMyExperiencewithCurrentCompany(-24);
		e0Arg0.setFatherName("Ram");
//		e0Arg0.setDesignation("HottLL7TC");
		e0Arg0.setFatherOccupation("Govt emp");
		e0Arg0.setLoanApplyDate("0007-01-06");
		e0Arg0.setLoanAmount(25000);
		e0Arg0.setRationCardNumber("123654asd");
//		e0Arg0.setTotalExperience(-45);
//		e0Arg0.setAnnualIncome();
//		e0Arg0.setGuarenteerName("N0m3zVibe8PK");
//		e0Arg0.setGuarenteerAddress("qzMfePinEz5lNnAc");
//		e0Arg0.setGuarenteerIncome("mQ9cUIHPwRziPlu8rV");
		e0Arg0.setFatherTotalExperience("25");
		e0Arg0.setP(11);
		e0Arg0.setE(9);
		e0Arg0.setCustid("C-000");
//		e0Arg0.setLoanAcNo("E");
		e0Arg0.setCourse("ece");
		e0Arg0.setLoanid("L-002");
		e0Arg0.setCompany("cts");
		e0Arg0.setDuration(5);
		e0Arg0.setLoanType("educational");
		e0Arg0.setCourseFee(2500);
		e0Arg0.setEmi(Double.parseDouble("5113.06"));
//		e0Arg0.setFatherTotalExperienceWithCurrentCompany(31);
		

		try{
			double e0 = e0Obj.emivalueEdu(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e0, new Object());
			assertNotNull(e0);
		}catch(Exception e){
//			fail();
		}
	}
	

	@Test //public double emivaluePer(LoanVO)
	public void testEmivaluePer(){
		LoanBO e0Obj = new LoanBO();
		LoanVO e0Arg0 = new LoanVO();
		e0Arg0.setMyExperiencewithCurrentCompany(83);
		e0Arg0.setDesignation("pat");
		e0Arg0.setLoanApplyDate("2016-01-01");
		e0Arg0.setLoanAmount(25000);
		e0Arg0.setTotalExperience(1);
		e0Arg0.setAnnualIncome(25000);
		e0Arg0.setP(11);
		e0Arg0.setE(9);
		e0Arg0.setCustid("C-000");
		e0Arg0.setLoanid("L-004");
		e0Arg0.setCompany("cts");
		e0Arg0.setDuration(5);
		e0Arg0.setLoanType("personal");
		e0Arg0.setEmi(Double.parseDouble("5138.34"));

		

		try{
			double e0 = e0Obj.emivaluePer(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e0, new Object());
			assertNotNull(e0);
		}catch(Exception e){
//			fail();
		}
	}
	

//	@Test
//	public void testSequence(){
//		LoanBO e0Obj = new LoanBO();
//		LoanVO e0Arg0 = new LoanVO();
//		e0Arg0.setMyExperiencewithCurrentCompany(84);
//		e0Arg0.setFatherName("Eh6OapJ");
//		e0Arg0.setDesignation("Byv8all");
//		e0Arg0.setFatherOccupation("08VSG4ddo0P6j");
//		e0Arg0.setLoanApplyDate("bkpqlIK");
//		e0Arg0.setLoanAmount(-96);
//		e0Arg0.setRationCardNumber("DY2K2cDsX6Cvoz67h");
//		e0Arg0.setTotalExperience(30);
//		e0Arg0.setAnnualIncome(25);
//		e0Arg0.setGuarenteerName("anJJUgD4GYJVrs8WAg");
//		e0Arg0.setGuarenteerAddress("");
//		e0Arg0.setGuarenteerIncome("p9U9o5edbxtUkN");
//		e0Arg0.setFatherTotalExperience("IUqO3wjTYji");
//		e0Arg0.setP(77);
//		e0Arg0.setE(45);
//		e0Arg0.setCustid("gWnA");
//		e0Arg0.setLoanAcNo("LH");
//		e0Arg0.setCourse("RkXJ0X5hJUUCZCxoHPa");
//		e0Arg0.setLoanid("ddU2j33ewisNq");
//		e0Arg0.setCompany("V1quqRhtdv5b1");
//		e0Arg0.setDuration(72);
//		e0Arg0.setLoanType("G5Lt4");
//		e0Arg0.setCourseFee(93);
//		e0Arg0.setEmi(Double.parseDouble("0.4962859432927518"));
//		e0Arg0.setFatherTotalExperienceWithCurrentCompany(-30);
//		
//
//		try{
//			String e0 = e0Obj.eMIEduCalculation(e0Arg0);
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e0, new Object());
//		}catch(Exception e){
//			fail();
//		}
//		String e1 = e0Obj.generateLoanID();
//		//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e1, new Object());
//		LoanVO e2Arg0 = new LoanVO();
//		e2Arg0.setMyExperiencewithCurrentCompany(8);
//		e2Arg0.setFatherName("M1YJRTv9G");
//		e2Arg0.setDesignation("dnbhuTM");
//		e2Arg0.setFatherOccupation("tRoBcVvWC3SD");
//		e2Arg0.setLoanApplyDate("DTWIN9");
//		e2Arg0.setLoanAmount(-73);
//		e2Arg0.setRationCardNumber("OyrT71tVLtfMZj0qtF");
//		e2Arg0.setTotalExperience(-59);
//		e2Arg0.setAnnualIncome(9);
//		e2Arg0.setGuarenteerName("ssTxqrs");
//		e2Arg0.setGuarenteerAddress("eXGc6g");
//		e2Arg0.setGuarenteerIncome("TBl0z65FPDgtSq");
//		e2Arg0.setFatherTotalExperience("vafzJSFVHzNfWHm");
//		e2Arg0.setP(46);
//		e2Arg0.setE(67);
//		e2Arg0.setCustid("m9PyVZr");
//		e2Arg0.setLoanAcNo("QzixzEIX");
//		e2Arg0.setCourse("7VUSKMa");
//		e2Arg0.setLoanid("P79YbCP");
//		e2Arg0.setCompany("Q");
//		e2Arg0.setDuration(73);
//		e2Arg0.setLoanType("TdFLleuwQAcdZaV");
//		e2Arg0.setCourseFee(-84);
//		e2Arg0.setEmi(Double.parseDouble("0.7213748144020155"));
//		e2Arg0.setFatherTotalExperienceWithCurrentCompany(-33);
//		
//
//		try{
//			String e2 = e0Obj.eMIPersCalculation(e2Arg0);
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e2, new Object());
//		}catch(Exception e){
//			fail();
//		}
//		LoanVO e3Arg0 = new LoanVO();
//		e3Arg0.setMyExperiencewithCurrentCompany(-31);
//		e3Arg0.setFatherName("p9");
//		e3Arg0.setDesignation("U60h8tkzunQPoy");
//		e3Arg0.setFatherOccupation("mbEy3mCv2XU8");
//		e3Arg0.setLoanApplyDate("aGGBoyUNiQRnv");
//		e3Arg0.setLoanAmount(99);
//		e3Arg0.setRationCardNumber("u");
//		e3Arg0.setTotalExperience(-37);
//		e3Arg0.setAnnualIncome(-81);
//		e3Arg0.setGuarenteerName("tMva9ND5JnOJGVrM");
//		e3Arg0.setGuarenteerAddress("9huCtLclyP");
//		e3Arg0.setGuarenteerIncome("vaPCAK1rBT");
//		e3Arg0.setFatherTotalExperience("DSARN4MYTy81j");
//		e3Arg0.setP(-28);
//		e3Arg0.setE(34);
//		e3Arg0.setCustid("kaimE9kij");
//		e3Arg0.setLoanAcNo("5guk7VDE83LN3Enst");
//		e3Arg0.setCourse("");
//		e3Arg0.setLoanid("weMHEBFw");
//		e3Arg0.setCompany("swP");
//		e3Arg0.setDuration(-35);
//		e3Arg0.setLoanType("qyhld1SDep01SyvH");
//		e3Arg0.setCourseFee(-83);
//		e3Arg0.setEmi(Double.parseDouble("0.7393459291185691"));
//		e3Arg0.setFatherTotalExperienceWithCurrentCompany(38);
//		
//
//		try{
//			double e3 = e0Obj.emivalueEdu(e3Arg0);
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e3, new Object());
//		}catch(Exception e){
//			fail();
//		}
//		LoanVO e4Arg0 = new LoanVO();
//		e4Arg0.setMyExperiencewithCurrentCompany(-60);
//		e4Arg0.setFatherName("qYxssjpsmvYcjv1k");
//		e4Arg0.setDesignation("aCwuUIrwcsEUf8K");
//		e4Arg0.setFatherOccupation("XbGC");
//		e4Arg0.setLoanApplyDate("QpNltqAnjMd6CQMSB");
//		e4Arg0.setLoanAmount(-58);
//		e4Arg0.setRationCardNumber("DPK6");
//		e4Arg0.setTotalExperience(-37);
//		e4Arg0.setAnnualIncome(-74);
//		e4Arg0.setGuarenteerName("x3UPNGW7");
//		e4Arg0.setGuarenteerAddress("9mSeyh");
//		e4Arg0.setGuarenteerIncome("jenW");
//		e4Arg0.setFatherTotalExperience("7f5ljHi9cid");
//		e4Arg0.setP(14);
//		e4Arg0.setE(-33);
//		e4Arg0.setCustid("57BLtX");
//		e4Arg0.setLoanAcNo("oI");
//		e4Arg0.setCourse("ARrqRRj");
//		e4Arg0.setLoanid("VZTMnR6YZyl90jtL2wS");
//		e4Arg0.setCompany("PWK6QsEkgqnSoSdlg3K");
//		e4Arg0.setDuration(-9);
//		e4Arg0.setLoanType("Xst");
//		e4Arg0.setCourseFee(92);
//		e4Arg0.setEmi(Double.parseDouble("0.32589925967742817"));
//		e4Arg0.setFatherTotalExperienceWithCurrentCompany(67);
//		
//
//		try{
//			double e4 = e0Obj.emivaluePer(e4Arg0);
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e4, new Object());
//		}catch(Exception e){
//			fail();
//		}
//	}
//	

}
