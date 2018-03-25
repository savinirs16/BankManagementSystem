package com.bms.bo;
import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.TestCase;
import java.util.List;
import com.bms.vo.TransactionVO;
import com.bms.bo.StatementBO;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class StatementBOTest extends TestCase {
	

	@Test //public List<TransactionVO> generateStatement(TransactionVO)
	public void testGenerateStatement(){
		StatementBO e0Obj = new StatementBO();
		TransactionVO e0Arg0 = new TransactionVO();
		e0Arg0.setLimit(5);
		e0Arg0.setUsername("vamshikrishna");
		e0Arg0.setTransactionType("deposit");
		e0Arg0.setTransactionDate("2016-04-11");
		e0Arg0.setTransactionAmount(Double.parseDouble("100"));
		e0Arg0.setTransactionAmountd(Double.parseDouble("100"));
		e0Arg0.setBalance(Double.parseDouble("5100"));
		e0Arg0.setCusId("C-000");
		e0Arg0.setFromDate("2016-02-11");
		e0Arg0.setToDate("2016-05-11");
		

		try{
			List<TransactionVO> e0 = e0Obj.generateStatement(e0Arg0);
			//TODO Based on your need, provide necessary assertion condition
		//assertEquals(e0, new Object());
		assertNotNull(e0);
		}catch(Exception e){
			fail();
		}
	}
	

//	@Test
//	public void testSequence(){
//		StatementBO e0Obj = new StatementBO();
//		TransactionVO e0Arg0 = new TransactionVO();
//		e0Arg0.setLimit(-12);
//		e0Arg0.setUsername("tdKWoHH7wr19pOewv");
//		e0Arg0.setTransactionType("rB6LK4jvA7wVELcMKp");
//		e0Arg0.setTransactionID(-57);
//		e0Arg0.setTransactionDate("UB");
//		e0Arg0.setTransactionAmount(Double.parseDouble("0.43861141454962527"));
//		e0Arg0.setTransactionAmountw(Double.parseDouble("0.9833356906690496"));
//		e0Arg0.setTransactionAmountd(Double.parseDouble("0.9498538280982174"));
//		e0Arg0.setBalance(Double.parseDouble("0.7776090190202143"));
//		e0Arg0.setCusName("7tNqelbYSNL");
//		e0Arg0.setCusId("jrdsVNtAosEFb");
//		e0Arg0.setDebit(Double.parseDouble("0.12019724602036719"));
//		e0Arg0.setCredit(Double.parseDouble("0.5854242731456498"));
//		e0Arg0.setFromDate("Slc");
//		e0Arg0.setToDate("9KPwp");
//		
//
//		try{
//			List<TransactionVO> e0 = e0Obj.generateStatement(e0Arg0);
//			//TODO Based on your need, provide necessary assertion condition
//		assertEquals(e0, new Object());
//		}catch(Exception e){
//			fail();
//		}
//	}
	

}
