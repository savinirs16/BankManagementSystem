package com.bms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

import com.bms.constants.QueryConstants;
import com.bms.exceptions.BMSException;
import com.bms.util.DBUtil;
import com.bms.vo.LoanVO;

public class LoanDAO implements ILoanDAO{
	public static final Logger LOG = Logger.getLogger("LoanDAO");
	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	LoanVO loanVO=new LoanVO();
	
	public int issueLoan1(LoanVO loanVO) throws BMSException{
		LOG.info("LoanDAO issueLoan1()got invoked");
	int count=0;
//	System.out.println("Entering Dao");
	
	try {
//		System.out.println("before conn");
		connection=DBUtil.getConnection();
//		System.out.println("after conn");
		pstmt=connection.prepareStatement(QueryConstants.REGISTER_LOAN);
//		System.out.println("after register");
		pstmt1=connection.prepareStatement(QueryConstants.EDUCATIONAL_LOAN);
//		System.out.println("after edu");
		pstmt2=connection.prepareStatement(QueryConstants.PERSONAL_LOAN);
//		System.out.println("after per");
		
		pstmt.setString(1, loanVO.getCustid());
//		System.out.println("set 1");
		pstmt.setString(2, loanVO.getLoanid());
//		System.out.println("set 2");
		pstmt.setInt(3, loanVO.getLoanAmount());
//		System.out.println("set 3");
		//System.out.println(loanVO.getLoanType());
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		String s=loanVO.getLoanApplyDate();

		//System.out.println(s);
		Date dt=sdf.parse(s);
		//System.out.println(dt);
		String s1=sdf1.format(dt);
		//System.out.println(s1);
		pstmt.setString(4,s1);
		
		if(loanVO.getLoanType().equalsIgnoreCase("educational")){
			System.out.println("after if loop");
			pstmt.setDouble(5, loanVO.getE());}
		else if(loanVO.getLoanType().equalsIgnoreCase("personal")){
			//prepared statement3
			pstmt.setDouble(5, loanVO.getP());}
		
			
		
		pstmt.setInt(6, loanVO.getDuration());
		pstmt.setDouble(7, loanVO.getEmi());
		pstmt.setString(8, loanVO.getLoanType());
		//System.out.println(" Before pstmt");
		count = pstmt.executeUpdate();
	//	System.out.println(" After PSTMT");
	//	System.out.println("after upd");	
		if(loanVO.getLoanType().equalsIgnoreCase("educational")){
			//pstmt.setDouble(6, loanVO.getE());
//			System.out.println("into dao educational loop");
//			System.out.println(loanVO.getLoanid());
			pstmt1.setString(1, loanVO.getLoanid());		
			pstmt1.setDouble(2, loanVO.getCourseFee());
			pstmt1.setString(3, loanVO.getCourse());
			pstmt1.setString(4, loanVO.getFatherName());
			pstmt1.setString(5, loanVO.getFatherOccupation());
			pstmt1.setString(6, loanVO.getFatherTotalExperience());
			pstmt1.setInt(7, loanVO.getFatherTotalExperienceWithCurrentCompany());
			pstmt1.setString(8, loanVO.getRationCardNumber());
			pstmt1.setDouble(9, loanVO.getAnnualIncome());
			pstmt1.executeUpdate();			
		}else if(loanVO.getLoanType().equalsIgnoreCase("personal")){
			//prepared statement2
			
			//System.out.println(loanVO.getLoanid());
			pstmt2.setString(1, loanVO.getLoanid());
			pstmt2.setDouble(2, loanVO.getAnnualIncome());
			pstmt2.setString(3, loanVO.getCompany());
			pstmt2.setString(4, loanVO.getDesignation());
			pstmt2.setInt(5, loanVO.getTotalExperience());
			pstmt2.setInt(6, loanVO.getMyExperiencewithCurrentCompany());
			pstmt2.executeUpdate();
			
		}
			
	} catch (IOException e) {
		// TODO Auto-generated catch block
		LOG.error("IOException in LoanDAO issueLoan1() "+e.getMessage());
		e.printStackTrace();
		throw new BMSException();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		LOG.error("ClassNotFoundException in LoanDAO issueLoan1() "+e.getMessage());
		e.printStackTrace();
		throw new BMSException();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		LOG.error("SQLException in LoanDAO issueLoan1() "+e.getMessage());
		e.printStackTrace();
		throw new BMSException();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		LOG.error("ParseException in LoanDAO issueLoan1() "+e.getMessage());
		e.printStackTrace();
	}
		
	finally{
		try {
			connection.close();
			pstmt.close();
			pstmt1.close();
			pstmt2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("SQLException in LoanDAO issueLoan1() "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	//System.out.println("exiting dao");
	LOG.info("Out of LoanDAO issueLoan1() method");
		return count;
	}
		
	
	
	public int getLoanRecordsCount(){
		LOG.info("LoanDAO getLoanRecordsCount() got invoked");
		int count=0;
		
		try {
			//create connection
			connection=DBUtil.getConnection();
			
			//create Statement object
			statement=connection.createStatement();
			
			//execute query
			resultSet=statement.executeQuery(QueryConstants.LOANRECORDSCOUNT);
			
			while(resultSet.next()){
				count++;
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOG.error("ClassNotFoundException in LoanDAO getLoanRecordsCount() "+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("IOException in LoanDAO getLoanRecordsCount() "+e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("SQLException in LoanDAO getLoanRecordsCount() "+e.getMessage());
			e.printStackTrace();
		}
		LOG.info("Out of LoanDAO getLoanRecordsCount() method");
		return count;
		
	}
	
}
