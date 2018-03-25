package com.bms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.bms.constants.QueryConstants;
import com.bms.exceptions.BMSException;
import com.bms.util.DBUtil;
import com.bms.vo.RegistrationVO;
import com.bms.exceptions.BMSException;
import com.bms.util.DBUtil;
import com.bms.exceptions.BMSException;
import com.bms.util.DBUtil;
import org.apache.log4j.Logger;

public class RegistrationDao {
    public static final Logger LOG=Logger.getLogger("RegistrationDAO");
	boolean result;
	PreparedStatement preparedStatement1=null;
	PreparedStatement preparedStatement2=null;
	PreparedStatement preparedStatement3=null;
	PreparedStatement preparedStatement4=null;
	PreparedStatement preparedStatement5=null;
	PreparedStatement preparedStatement6=null;
	private Statement statement;
	ResultSet resultSet;
	ResultSet ifsc=null;
	String code=new String();
	Connection connection = null;
	/** The country details. */
	HashMap<String, String> countryDetails = new HashMap<String, String>();
	
	/** The state details. */
	HashMap<String, String> stateDetails = new HashMap<String, String>();
	RegistrationVO regisVo=new RegistrationVO();
	public HashMap<String, String> getCountryDetails() throws BMSException {
		LOG.info("RegistrationDAO getCountryDetails() method invoked");
		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QueryConstants.COUNTRYDETAILS);
			while (resultSet.next()) {
				String country = resultSet.getString(1);
				String countryname = resultSet.getString(2);
				countryDetails.put(country, countryname);
			}
		} catch (IOException e) {
		  LOG.error("IOException in RegistrationDAO getCountryDetails() method"+e.getMessage());
			throw new BMSException();
		} catch (ClassNotFoundException e) {
			LOG.error("ClassNotFoundException in RegistrationDAO getCountryDetails() method"+e.getMessage());
			throw new BMSException();
		} catch (SQLException e) {
			LOG.error("SQLException in RegistrationDAO getCountryDetails() method"+e.getMessage());
			throw new BMSException();
		} 
		LOG.info("Out of RegistrationDAO getCountryDetails() method ");
		return countryDetails;
	}
	
	public HashMap<String, String> getStateDetails() throws BMSException {
		LOG.info("RegistrationDAO getStateDetails() method invoked");
		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QueryConstants.STATEDETAILS);
			while (resultSet.next()) {
			final	String stateid = resultSet.getString(1);
			final	String statename = resultSet.getString(2);
			final	String scountryid = resultSet.getString(3);
				stateDetails.put(stateid, (statename + "|" + scountryid));
			}
		} catch (IOException e) {
			 LOG.error("IOException in RegistrationDAO getStateDetails() method"+e.getMessage());
			throw new BMSException();
		} catch (ClassNotFoundException e) {
			LOG.error("ClassNotFoundException in RegistrationDAO getStateDetails() method"+e.getMessage());
			throw new BMSException();
		} catch (SQLException e) {
			LOG.error("SQLException in RegistrationDAO getStateDetails() method"+e.getMessage());
			throw new BMSException();
		}
		LOG.info("Out of RegistrationDAO getStateDetails() method ");
		return stateDetails;
	}
	public boolean insertDetails(RegistrationVO registrationVO) throws BMSException, ParseException {
		// TODO Auto-generated method stub
		LOG.info("RegistrationDAO insertDetails() method invoked");
		//System.out.println(" Flow came to registration DAO - insert deatils method");
		try {
			connection = DBUtil.getConnection();
			//System.out.println("Connection Established Sucessufully");

			preparedStatement3 = connection.prepareStatement(QueryConstants.REGISTERLOGINDETAILS);
			preparedStatement3.setString(1, registrationVO.getCusID());
			//System.out.println("id is set"+registrationVO.getCusID());
			preparedStatement3.setString(2, registrationVO.getUname());
			//System.out.println(registrationVO.getUname());
			preparedStatement3.setString(3, registrationVO.getPass());
			
			preparedStatement1 = connection.prepareStatement(QueryConstants.REGISTERPERSONALDETAILS);
			//System.out.println("in pere");
			preparedStatement1.setString(1, registrationVO.getCusID());
			//System.out.println("new  customer id came from bo "+registrationVO.getCusID());
			preparedStatement1.setString(2, registrationVO.getUname());
			//System.out.println("user name is in dAO "+ registrationVO.getUname());
			preparedStatement1.setString(3, registrationVO.getGtype());
			//System.out.println(registrationVO.getGtype());
			preparedStatement1.setString(4, registrationVO.getGname());
			//System.out.println(registrationVO.getGname());
			preparedStatement1.setString(5, registrationVO.getAddress());
			//System.out.println(registrationVO.getAddress());
			preparedStatement1.setString(6, registrationVO.getCitizenship());
			//System.out.println(registrationVO.getCitizenship());
			preparedStatement1.setString(7, registrationVO.getCountry());
			//System.out.println("country"+registrationVO.getCountry());
			preparedStatement1.setString(8, registrationVO.getCountry());
			//System.out.println(registrationVO.getCountry());
			preparedStatement1.setString(9, registrationVO.getState());
			//System.out.println(registrationVO.getState());
			
			preparedStatement1.setString(10, registrationVO.getEmail());
			//	System.out.println(registrationVO.getEmail());
			preparedStatement1.setString(11, registrationVO.getGender());
			//System.out.println(registrationVO.getGender());
			preparedStatement1.setString(12, registrationVO.getMaritalStatus());
			//System.out.println(registrationVO.getMaritalStatus());
			preparedStatement1.setString(13, registrationVO.getContact());
			//System.out.println("contact"+registrationVO.getContact());

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			// String dt = formatter.format(registrationVO.getDob());
			//System.out.println("parsing");
			Date dt = formatter.parse(registrationVO.getDob());
			java.sql.Date dt1 = new java.sql.Date(dt.getTime());
			preparedStatement1.setDate(14, dt1);
			//System.out.println(registrationVO.getDob());
			preparedStatement1.setString(15, registrationVO.getIdproof());
			//System.out.println(registrationVO.getIdproof());
			preparedStatement1.setString(16, registrationVO.getIdnum());
			//System.out.println(registrationVO.getIdnum());
			////	
			////	System.out.println(" After setting data into PreparedStatement 1");
			////			
			preparedStatement5=connection.prepareStatement(QueryConstants.IFSCCODE);
			//System.out.println(" Branch name: "+registrationVO.getBranchName());
			preparedStatement5.setString(1, registrationVO.getBranchName());
			ifsc=preparedStatement5.executeQuery();
			//System.out.println("ifsc code"+ifsc);
			while(ifsc.next())
			{
				//System.out.println(" Flow came to while ");
				regisVo.setIfsc_code(ifsc.getString(1));
			
				code=regisVo.getIfsc_code();
			}
			//System.out.println(code);
			
			
			//System.out.println("before ini");
			preparedStatement6=connection.prepareStatement(QueryConstants.INITIALDEPSAVING);
			preparedStatement6.setString(1, registrationVO.getCountry());
			preparedStatement6.setInt(2, registrationVO.getInidepamo());
			
			
			
			preparedStatement2 = connection.prepareStatement(QueryConstants.REGISTERREFERENCEDETAILS);
			//System.out.println("Prepared statement2"+preparedStatement2);
			////	//preparedStatement2.setString(1, "C-001");
			preparedStatement2.setString(1, registrationVO.getCusID());
			preparedStatement2.setString(2, registrationVO.getRefname());
			////	//System.out.println("p2");
			////	//System.out.println(registrationVO.getRefname());
			preparedStatement2.setInt(3, (int) registrationVO.getRefaccnum());
			preparedStatement2.setString(4, registrationVO.getRefaddress());
			//System.out.println("finished pstmt2 ");
			
			
			
			
			
			preparedStatement4 = connection.prepareStatement(QueryConstants.REGISTERACCOUNTDETAILS);
			// System.out.println("Prepared statement4"+preparedStatement4);
			//preparedStatement4.setString(1, "C-001");
			// preparedStatement4.setString(2,"12345678910");
			preparedStatement4.setString(1, registrationVO.getCusID());
			preparedStatement4.setLong(2, registrationVO.getAccountNum());
			preparedStatement4.setString(3, registrationVO.getAcctype());
			//System.out.println("p4");
			//System.out.println(registrationVO.getAcctype());
			preparedStatement4.setInt(4, registrationVO.getInidepamo());
			preparedStatement4.setString(5, registrationVO.getBranchName());
			preparedStatement4.setString(6, code);
			DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			Date dt11 = formatter1.parse(registrationVO.getDate());
			java.sql.Date dt2 = new java.sql.Date(dt11.getTime());

			preparedStatement4.setDate(7, dt2);
			preparedStatement4.setDate(8, dt2);
			preparedStatement4.setString(9, registrationVO.getCitizenstatus());
			int bal=registrationVO.getInidepamo();
			//System.out.println("this is bal "+bal);
			preparedStatement4.setInt(10, bal);
			//System.out.println("finished pstmt4");
			
			
			
			
			int count1=preparedStatement3.executeUpdate();	
			//System.out.println(" P3 done");
			//System.out.println("eu");
			int count2 =preparedStatement1.executeUpdate();
			//System.out.println("P1 done");
			int count3=preparedStatement2.executeUpdate();
			//System.out.println("P2 done");
			int count4=preparedStatement4.executeUpdate();
			//System.out.println(" P4 done");
			int count5=preparedStatement6.executeUpdate();
			//System.out.println("p6 done");
			if(count1==1&&count2==1&&count3==1&&count4==1&&count5==1){
				result=true;
			}


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOG.error("ClassNotFoundException in RegistrationDAO insertDetails() method"+e.getMessage());
			e.printStackTrace();
			// throw new BMSException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("IOException in RegistrationDAO insertDetails() method"+e.getMessage());
			e.printStackTrace();
			// throw new BMSException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("SQLException in RegistrationDAO insertDetails() method"+e.getMessage());
			e.printStackTrace();
			// throw new BMSException();
		}

		finally {
			try {
				connection.close();
				preparedStatement1.close();
				preparedStatement2.close();
				preparedStatement3.close();
				preparedStatement4.close();
				preparedStatement6.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOG.error("SQLException in RegistrationDAO insertDetails() method"+e.getMessage());
				e.printStackTrace();
			}

		}
		return result;

	}


	
	public int getCustCount() {
		LOG.info("Registration Dao getCustCount() method invoked");
		// TODO Auto-generated method stub
		//System.out.println("in dao gen count");
		int count=0;

		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		//establish connection
		try {
			connection =DBUtil.getConnection();

			statement=connection.createStatement();

			resultSet=statement.executeQuery(QueryConstants.CUSTID);
			while(resultSet.next()){
				count++;
			}

			//	System.out.println(" Count from dao is "+count);
		} catch ( ClassNotFoundException e) {
			LOG.error(" ClassNotFoundException in RegistrationDAO getCustCount() method invoked"+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			LOG.error(" IOException in RegistrationDAO getCustCount() method invoked"+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			LOG.error(" SQLException in RegistrationDAO getCustCount() method invoked"+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();


LOG.info("Out of Registration Dao");
		}
	
		//System.out.println("flow return to bo gen cust");
		return count;	
	}		
}


