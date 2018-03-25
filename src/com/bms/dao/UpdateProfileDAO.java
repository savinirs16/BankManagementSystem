package com.bms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.bms.constants.QueryConstants;

import com.bms.exceptions.BMSException;
import com.bms.exceptions.BMSException;
import com.bms.util.DBUtil;
import com.bms.vo.UpdateProfileVO;


import org.apache.log4j.Logger;



public class UpdateProfileDAO {
	public static final Logger LOG = Logger.getLogger("UpdateProfileDAO");
	
	public int result;
	Connection connection=null;
	Statement statement=null;
	ResultSet resultset=null;
	PreparedStatement preparedstatement=null;
	ResultSet resultSet;
	UpdateProfileVO updateprofileVO=null;
	private int i; 
	
	HashMap<String, String> countryDetails = new HashMap<String, String>();
	
	/** The state details. */
	HashMap<String, String> stateDetails = new HashMap<String, String>();
	
	public HashMap<String, String> getCountryDetails() throws BMSException {
		
		LOG.info(" UpdateProfileDAO getCountryDetails() method got invoked");
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
			LOG.error("IOException in UpdateProfileDAO getCountryDetails() method"+e.getMessage());
			throw new BMSException();
		} catch (ClassNotFoundException e) {
			LOG.error("ClassNotFoundException in UpdateProfileDAO getCountryDetails() method"+e.getMessage());
			throw new BMSException();
		} catch (SQLException e) {
			LOG.error("SQLException in UpdateProfileDAO getCountryDetails() method"+e.getMessage());
			throw new BMSException();
		} 
		LOG.info("Out of getCountryDetails() Method in UpdateProfileDAO");
		return countryDetails;
	}
	
	public HashMap<String, String> getStateDetails() throws BMSException {
		LOG.info(" UpdateProfileDAO getStateDetails() method got invoked");
		
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
			LOG.error("IOException in UpdateProfileDAO getStateDetails() method"+e.getMessage());
			throw new BMSException();
		} catch (ClassNotFoundException e) {
			LOG.error("ClassNotFoundException in UpdateProfileDAO getStateDetails() method"+e.getMessage());
			throw new BMSException();
		} catch (SQLException e) {
			LOG.error("SQLException in UpdateProfileDAO getStateDetails() method"+e.getMessage());
			throw new BMSException();
		}
		LOG.info("Out of getStateDetails() Method in UpdateProfileDAO");
		return stateDetails;
	}
	
	public UpdateProfileVO getCustomer(String customerID) {
		
		LOG.info(" UpdateProfileDAO getCustomer() method got invoked");
		updateprofileVO =new UpdateProfileVO();
		System.out.println("Flow entrerd to DAO get customer");
		try {
			connection=DBUtil.getConnection();
			//System.out.println(connection);
			preparedstatement=connection.prepareStatement(QueryConstants.GET_CUSTOMER_DETAILS);
//			System.out.println(preparedstatement);
//			System.out.println("cus id in daop ios "+customerID);
			preparedstatement.setString(1, customerID);
			
			//resultset=statement.executeQuery("select l.cus_id,p.cname,p.guardian_type,p.guardian_name,p.address, p.citizenship,p.state,i.country,p.email,p.gender,p.marital_status,p.contactno,p.dob,p.proof_type,p.doc_num,r.reference_name,r.reference_num,r.reference_address,ad.account_num,ad.account_type,ad.branch_name,ad.bank_name,ad.regdate,ad.citizen_status,b.ifsc_code from personal_details p,login_details l,account_details ad, country_details c, initial_deposit_savings i,branch_ifsc b,reference_details r where l.cus_id=p.cus_id and l.cus_id=ad.cus_id and l.cus_id=r.cus_id and ad.ifsc_code=b.ifsc_code and p.cid=c.cid and c.country=i.country and l.cus_id='"+customerID+"'");
			//System.out.println(1);
			
			resultset = preparedstatement.executeQuery();
			//System.out.println(resultset);
			
			while(resultset.next()){
//				System.out.println("before result set in dao");
//				System.out.println(2);
				updateprofileVO.setCusid(resultset.getString(1));
				//System.out.println(updateprofileVO.getCusid());
				updateprofileVO.setName(resultset.getString(2));
				//updateprofileVO.setAccholdernum(resultset.getString(3));
				updateprofileVO.setGuardiantype(resultset.getString(3));	
				updateprofileVO.setGuardianname(resultset.getString(4));	
				updateprofileVO.setAdd(resultset.getString(5));	
				updateprofileVO.setCitizenship(resultset.getString(6));	
				updateprofileVO.setState(resultset.getString(7));		
				updateprofileVO.setCountry(resultset.getString(8));
				//updateprofileVO.setState(resultset.getString(9));
				updateprofileVO.setEmailID(resultset.getString(9));		
				updateprofileVO.setGender(resultset.getString(10));		
				updateprofileVO.setMarital(resultset.getString(11));		
				updateprofileVO.setContact(resultset.getString(12));		
				updateprofileVO.setDob(resultset.getString(13));
				updateprofileVO.setIdtype(resultset.getString(14));	
				updateprofileVO.setDocnum(resultset.getString(15));		
				updateprofileVO.setAccholdername(resultset.getString(16));
				updateprofileVO.setAccholdernum(resultset.getString(17));
				updateprofileVO.setAccholderadd(resultset.getString(18));
				updateprofileVO.setAccno(resultset.getLong(19));
				updateprofileVO.setAcctype(resultset.getString(20));
				updateprofileVO.setBranchname(resultset.getString(21));
				//updateprofileVO.setBankname(resultset.getString(22));
				updateprofileVO.setRegdate(resultset.getString(22));
				updateprofileVO.setCitizenstatus(resultset.getString(23));
				updateprofileVO.setIfsc(resultset.getString(24));
				//System.out.println(updateprofileVO.getIfsc());
				
				//System.out.println("Leaving DAO get customer");
			}
		} catch (ClassNotFoundException e) {
			LOG.error("ClassNotFoundException in UpdateProfileDAO getCustomer() method"+e.getMessage());
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			LOG.error("IOException in UpdateProfileDAO getCustomer() method"+e.getMessage());
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (SQLException e) {
			LOG.error("SQLException in UpdateProfileDAO getCustomer() method"+e.getMessage());
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		LOG.info("Out of getCustomer() Method in UpdateProfileDAO");
		return updateprofileVO;
	}
	
	public int getupdateCustomerdetails(UpdateProfileVO updateprofileVO) throws BMSException {
		LOG.info(" UpdateProfileDAO getupdateCustomerdetails() method got invoked");
		// TODO Auto-generated method stub
		//LOG.info("update customer DAO invoked");
		// TODO Auto-generated method stub
//		System.out.println("Flow entered dao upudate customer");
//		System.out.println(" Customer id at DAO is "+updateprofileVO.getCusid());
		try {
			 connection=DBUtil.getConnection();
			 preparedstatement=connection.prepareStatement(QueryConstants.SET_CUSTOMER+updateprofileVO.getCusid()+"'");	
			 preparedstatement.setString(1,updateprofileVO.getCountry());
			 //System.out.println(updateprofileVO.getCountry());
			 preparedstatement.setString(2, updateprofileVO.getCountry());
			 preparedstatement.setString(3, updateprofileVO.getState());
			 //System.out.println(updateprofileVO.getState());
			 preparedstatement.setString(4, updateprofileVO.getIdtype());
			 //System.out.println(updateprofileVO.getIdtype());
			 preparedstatement.setString(5, updateprofileVO.getDocnum());
			 //System.out.println(updateprofileVO.getDocnum());
		     preparedstatement.setString(6, updateprofileVO.getAdd());
			// System.out.println(updateprofileVO.getAdd());
			 preparedstatement.setString(7, updateprofileVO.getContact());
			 //System.out.println(updateprofileVO.getContact());
			 preparedstatement.setString(8, updateprofileVO.getEmailID());
			// System.out.println(updateprofileVO.getEmailID());
			 preparedstatement.setString(9, updateprofileVO.getMarital());
			 //System.out.println(updateprofileVO.getMarital());
			 preparedstatement.setString(10, updateprofileVO.getAcctype());
			//System.out.println(updateprofileVO.getAcctype());
			 preparedstatement.setString(11, updateprofileVO.getCitizenship());
			// System.out.println(updateprofileVO.getCitizenship());
			 preparedstatement.setString(12, updateprofileVO.getGuardiantype());
			// System.out.println(updateprofileVO.getGuardiantype());
			 preparedstatement.setString(13, updateprofileVO.getGuardianname());
			// System.out.println(updateprofileVO.getGuardianname());
			i=preparedstatement.executeUpdate();
			//System.out.println(" I value is "+i);
		//System.out.println("Executed sucessfully");
		} catch (ClassNotFoundException e) {
			LOG.error("ClassNotFoundException in UpdateProfileDAO getupdateCustomerdetails() method"+e.getMessage());
			// TODO Auto-generated catch block
			//LOG.error("Update customerID DAO error");
			//e.printStackTrace();
			throw new BMSException();
		} catch (IOException e) {
			LOG.error("IOException in UpdateProfileDAO getupdateCustomerdetails() method"+e.getMessage());
			// TODO Auto-generated catch block
			//LOG.error("Update customerID DAO error");
		//	e.printStackTrace();
			throw new BMSException();
		} catch (SQLException e) {
			LOG.error("SQLException in UpdateProfileDAO getupdateCustomerdetails() method"+e.getMessage());
			// TODO Auto-generated catch block
			//LOG.error("Update customerID DAO error");
		//e.printStackTrace();
			throw new BMSException();
		}
		finally {
			try {
				
				connection.close();
			} catch (SQLException e) {
				LOG.error("SQLException in UpdateProfileDAO getupdateCustomerdetails() method"+e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		LOG.info("Out of getupdateCustomerdetails() Method in UpdateProfileDAO");
	 
		return i;
	}
	}



	
	



