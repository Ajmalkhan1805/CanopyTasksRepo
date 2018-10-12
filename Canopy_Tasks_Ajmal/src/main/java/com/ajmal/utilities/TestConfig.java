package com.ajmal.utilities;

import com.ajmal.base.Constants;

public class TestConfig{


	
	public static String server="smtp.gmail.com";
	public static String from = "canopytestautomation@gmail.com";
	public static String password = Constants.password;
	public static String[] to ={"ajimulkhan@srinsofttech.com"}; //Add many rcpnts by adding comma 
	public static String subject = "Extent Project Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath="c:\\screenshot\\Test.jpg";
	public static String attachmentName="error.jpg";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://localhost;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword=""; //Provide passowrd
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/acs";
	
	
	
	
	
	
	
	
	
}
