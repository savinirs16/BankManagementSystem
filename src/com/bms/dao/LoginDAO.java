package com.bms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bms.constants.QueryConstants;
import com.bms.util.DBUtil;
import com.bms.vo.LoginVO;
import org.apache.log4j.Logger;

public class LoginDAO {
	public static final Logger LOG=Logger.getLogger("LoginDAO");
	ResultSet resultSet=null;
	ResultSet resultSet1=null;
	ResultSet resultSet2=null;
	ResultSet resultSet3=null;
	ResultSet resultSet4=null;
	Connection connection = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	PreparedStatement pstmt4 = null;
public List<LoginVO> validateList(LoginVO loginVO)
{
	LOG.info("Login DAO validateList() method got invoked");
//	System.out.println("before list in DAO");
	List<LoginVO> loginList = new ArrayList<LoginVO>();
//	System.out.println("after list in DAO");
	try {
		connection = DBUtil.getConnection();
//		System.out.println("before Pstmt in DAO");
		pstmt = connection.prepareStatement(QueryConstants.GET_USERLIST);
//		System.out.println("after pstmt in DAO");
		resultSet=pstmt.executeQuery();
		
		
		
		while(resultSet.next())
		{
			loginVO=new LoginVO();
			loginVO.setCustid(resultSet.getString(1));
			loginVO.setUsername(resultSet.getString(2));
			loginVO.setPassword(resultSet.getString(3));
			loginList.add(loginVO);
		}
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		LOG.error( "ClassNotFoundException in Login DAO validateList() method "+e.getMessage());
		e.printStackTrace();
	} catch (IOException e) {
		LOG.error( "IOException in Login DAO validateList() method "+e.getMessage());
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		LOG.error( "SQLException in Login DAO validateList() method "+e.getMessage());
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			resultSet.close();
			connection.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		LOG.info("out of ValidateList() method in Login DAO");
	}
	
	return loginList;
	
	
}

public LoginVO returndata(LoginVO loginVO)
{
	LOG.info("Login DAO returndata() method got invoked ");
//	System.out.println("in return data");
	LoginVO loginVO1=new LoginVO();
	LoginVO loginVO2=new LoginVO();
	ArrayList<LoginVO> l=new ArrayList<LoginVO>();
	try {
		connection = DBUtil.getConnection();
		pstmt1=connection.prepareStatement(QueryConstants.GET_CUSID);
//		System.out.println("in dao "+loginVO.getUsername());
//		System.out.println("in dao"+loginVO.getPassword());
		pstmt1.setString(1, loginVO.getUsername());
		pstmt1.setString(2, loginVO.getPassword());
		resultSet1=pstmt1.executeQuery();
		while(resultSet1.next())
		{			 
			loginVO1.setCustid(resultSet1.getString(1));
			
		}
		loginVO2.setCustid(loginVO1.getCustid());
//		System.out.println("in dao "+loginVO1.getCustid());
		for(LoginVO login:l)
		{
			if(loginVO.getUsername().equalsIgnoreCase(login.getUsername()) && loginVO.getPassword().equalsIgnoreCase(login.getPassword()))				
			{
				loginVO2.setUsername(login.getUsername());
				loginVO2.setPassword(login.getPassword());
				
			}
		}	
		pstmt2=connection.prepareStatement(QueryConstants.GET_NAME);
//		System.out.println("after getting name");
		pstmt2.setString(1, loginVO1.getCustid());
		resultSet2=pstmt2.executeQuery();
		while(resultSet2.next())
		{
//			System.out.println("inside while loop cname");
			loginVO2.setCname(resultSet2.getString(1));
		}
		pstmt3=connection.prepareStatement(QueryConstants.GET_ACCOUNTNUM);
		pstmt3.setString(1, loginVO1.getCustid());
		resultSet3=pstmt3.executeQuery();
		while(resultSet3.next())
		{ 
			loginVO2.setAcctnum(resultSet3.getLong(1));
		}
		pstmt4=connection.prepareStatement(QueryConstants.GET_BALANCE);
		pstmt4.setString(1, loginVO1.getCustid());
		resultSet4=pstmt4.executeQuery();
		while(resultSet4.next())
		{
			loginVO2.setBalance(resultSet4.getInt(1));
		}
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		LOG.error( "ClassNotFoundException in Login DAO returndata() method "+e.getMessage());
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		LOG.error( "IOException in Login DAO returndata() method "+e.getMessage());
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		LOG.error( "SQLException in Login DAO returndata() method "+e.getMessage());
		e.printStackTrace();
	}
	LOG.info("out of Login DAO returnData()");
	
	return loginVO2;	
	
}




}
