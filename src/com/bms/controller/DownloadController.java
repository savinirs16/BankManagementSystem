package com.bms.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Statement;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bms.bo.StatementBO;
import com.bms.exceptions.BMSBussinessException;
import com.bms.exceptions.BMSException;
import com.bms.vo.TransactionVO;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class DownloadController
 */
public class DownloadController extends HttpServlet {
	public static final Logger LOG = Logger.getLogger("DownloadController");
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("DoGet Method in DownloadController got invoked");
		//System.out.println("in down controller");
		HttpSession session = request.getSession();
		
String fdate=(String) session.getAttribute("fdate");
String tdate=(String) session.getAttribute("tdate");
Date fdt=new Date();
Date tdt=new Date();
SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
try {
	fdt=sdf.parse(fdate);
	tdt=sdf.parse(tdate);
//	System.out.println(fdt);
//	System.out.println(tdt);
	
	
} catch (ParseException e1) {
	// TODO Auto-generated catch block
	LOG.error("ParseExceptionn  in DownloadController doGet() method"+e1.getMessage());
	e1.printStackTrace();
}
String dt1=sdf1.format(fdt);
String dt2=sdf1.format(tdt);
//System.out.println(dt1);
//System.out.println(dt2);
		List<TransactionVO> trList = (List<TransactionVO>) session.getAttribute("tList");
		
		//System.out.println(trList.get(0));
		String cs=(String) session.getAttribute("cusID");
//System.out.println(cs);
String filename = "d:\\"+cs+"_"+dt1+"_"+dt2+".csv";
try
{
	//ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),CsvPreference.STANDARD_PREFERENCE);
FileWriter fw = new FileWriter(filename);

//Class.forName(driver).newInstance();
//conn = DriverManager.getConnection(url+dbName,userName,password);
//String query  = "Select * from transaction_details where transaction_date between '2015/09/02' and '2015/09/05'";
//stmt = conn.createStatement();
//ResultSet rs = stmt.executeQuery(query);
fw.append("Cognizant Bank");
fw.append('\n');
fw.append(cs);
fw.append('\n');
fw.append("transaction date");
fw.append(',');
fw.append("transaction type");
fw.append(',');
fw.append("transaction amount");
fw.append(',');
fw.append("balance");
fw.append(',');
fw.append('\n');
//System.out.println("before for each");
for(TransactionVO transaction : trList){
	
fw.append(transaction.getTransactionDate());
fw.append(',');
fw.append(transaction.getTransactionType());
fw.append(',');
fw.append(String.valueOf(transaction.getTransactionAmount()));
fw.append(',');
fw.append(String.valueOf(transaction.getBalance()));
fw.append(',');
fw.append('\n');
}
fw.flush();
fw.close();
//conn.close();
//System.out.println("CSV File is created successfully.");

RequestDispatcher requestDispatcher=request.getRequestDispatcher("Transactionsuccesspage.jsp");

session.setAttribute("filename", filename);
//session.setAttribute("Message","Downloaded Successfully");
requestDispatcher.forward(request, response);
} catch (Exception e) {
	LOG.error("Exception  in DownloadController doGet() method"+e.getMessage());
e.printStackTrace();
}
LOG.info("Out of DownloadController doGet() method ");
	}
}