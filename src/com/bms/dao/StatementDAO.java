package com.bms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import sun.misc.Cache;
import org.apache.log4j.Logger;
import com.bms.bo.StatementBO;
import com.bms.constants.QueryConstants;

import com.bms.exceptions.BMSException;
import com.bms.util.DBUtil;
import com.bms.vo.TransactionVO;

public class StatementDAO implements IStatementDAO{
	public static final Logger LOG = Logger.getLogger("StatementDAO");
	Connection connection = null;
	Statement statement1=null;
	Statement statement2=null;
	ResultSet resultSet1=null;
	ResultSet resultSet2=null;
	
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;

	TransactionVO transactionVO = null;
	
	//HttpSession session=null;
	// create List
	List<TransactionVO> transactionList = new ArrayList<TransactionVO>();
	@Override	
	public List<TransactionVO> getTransaction(TransactionVO transactionVO) throws BMSException {
		
		// TODO Auto-generated method stub
		
		LOG.info(" StatementDAO getTransaction() method got invoked");
		String f=new String();
		String t=new String();
		String transType=new String();
		transType=transactionVO.getTransactionType();
		//System.out.println(transType);

		//  create connection
		try {
			
			connection = DBUtil.getConnection();
			//System.out.println(" Connection "+connection);
			
			// create statement		
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
			String fdt=transactionVO.getFromDate();
			String tdt=transactionVO.getToDate();
			Date fdt1=sdf.parse(fdt);
			Date tdt1=sdf.parse(tdt);
//			System.out.println(fdt1);
//			System.out.println(tdt1);
			f=sdf1.format(fdt1);
			t=sdf1.format(tdt1);
//			System.out.println(f);
//			System.out.println(t);
			
			
			
			//get customername
			

			//statement2=connection.createStatement();
			String cusid=transactionVO.getCusId();
			
			
			
			if(transType.equalsIgnoreCase("Both")){
				//System.out.println(transType);
				//System.out.println("both");
				pstmt = connection.prepareStatement(QueryConstants.GET_TRANSACTIONS3);
				pstmt.setString(1,f);
				pstmt.setString(2,t);
				pstmt.setString(3, cusid);
				resultSet2=pstmt.executeQuery();
			}else if(transType.equalsIgnoreCase("withdraw")){
				//System.out.println(transType);
				//System.out.println("withdraw");
				//resultSet2=statement2.executeQuery(QueryConstants.GET_TRANSACTIONS3+"where transaction_type ="+transType+" and transaction_date between '"+f+"' and '"+t+"'");
				pstmt = connection.prepareStatement(QueryConstants.GET_TRANSACTIONS1);
				pstmt.setString(1,f);
				pstmt.setString(2,t);
				pstmt.setString(3, transType);
				pstmt.setString(4, cusid);
				int c=0;
				++c;
				//System.out.println(c);
				resultSet2=pstmt.executeQuery();
			}else if(transType.equalsIgnoreCase("deposit")){
				//System.out.println(transType);
				//System.out.println("in deposit");
				//resultSet2=statement2.executeQuery(QueryConstants.GET_TRANSACTIONS3+"where transaction_type ="+transType+" and transaction_date between '"+f+"' and '"+t+"'");
				pstmt = connection.prepareStatement(QueryConstants.GET_TRANSACTIONS1);
				//System.out.println("after query");
				pstmt.setString(1,f);
				pstmt.setString(2,t);
				pstmt.setString(3, transType);
				pstmt.setString(4, cusid);
				//System.out.println("before exec");
				resultSet2=pstmt.executeQuery();
				//System.out.println("after exec");
			}
			int d = 1;
			while(resultSet2.next())
			{
			
				transactionVO = new TransactionVO();
				transactionVO.setTransactionDate(resultSet2.getString(1));
				//System.out.println(resultSet2.getString(1));
				transactionVO.setTransactionType(resultSet2.getString(2));
				//String type=transactionVO.getTransactionType();
				//System.out.println(resultSet2.getString(2));
				transactionVO.setTransactionAmount(resultSet2.getDouble(3));
				//System.out.println(resultSet2.getDouble(3));	
				transactionVO.setBalance(resultSet2.getDouble(4));
				//System.out.println(resultSet2.getDouble(4));				
				// add Transaction Vo object to list
				//transactionList.add(transactionVO);
				//System.out.println("leaving dao while loop");	
				
				
				
				// add transaction to list
				transactionList.add(transactionVO);
				//System.out.println(" inside while loop "+d);
				d++;
							
			}
		}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			 LOG.error("ClassNotFoundException in StatementDAO getTransaction() method"+e.getMessage());
			e.printStackTrace();
			throw new BMSException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("IOException in StatementDAO getTransaction() method"+e.getMessage());
			e.printStackTrace();
			throw new BMSException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("SQLException in StatementDAO getTransaction() method"+e.getMessage());
			e.printStackTrace();
			throw new BMSException();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			LOG.error("ParseException in StatementDAO getTransaction() method"+e.getMessage());
			e.printStackTrace();
			throw new BMSException();		
		}finally{			
			try {
				resultSet2.close();
				//statement2.close();
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOG.error("SQLException in StatementDAO getTransaction() method"+e.getMessage());
				e.printStackTrace();
				throw new BMSException();
			}
		}	
		LOG.info(" Out of StatementDAO getTransaction() method");
//		System.out.println(" Leaving DAO");	
//		System.out.println(transactionList.size()+"leaving dao");
		return transactionList;
}
}
