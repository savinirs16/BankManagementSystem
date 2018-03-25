package com.bms.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	private static Connection connection = null;
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException{
		
		// create Properties object
		Properties props = new Properties();
		
		// read data from the file
		InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
		
		// load properties from input stream
		props.load(inputStream);
		
		// read properties from the file
		String driver = props.getProperty("driver");
		//System.out.println(driver);
		String url = props.getProperty("url");
		//System.out.println(url);
		String user = props.getProperty("user");
		//System.out.println(user);
		String password = props.getProperty("password");
		//System.out.println(password);
		
		// load and register driver
		Class.forName(driver);
			//System.out.println("before connection");
		// create connection
		connection = DriverManager.getConnection(url, user, password);
		//System.out.println("after connection");
		return  connection;
		
	}
	
	
}
