package practiceSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDATAbase {
	public static void main(String []args) throws SQLException {
		//. create  instance for Driver ---> register driver to jdbc

	   Driver dbdriver= new Driver();
		 DriverManager.registerDriver(dbdriver);


	//	DriverManager.registerDriver(new Driver());


		//Step2 .. get connection --> bdurl, un , psw,  : url --> jdbc:mysql://localhost:3306/mydb

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46", "root", "root");



		//3: steP create statement... return type is statement 

		Statement statment = connection.createStatement();

		// 4 Execute query 
		ResultSet result = statment.executeQuery("select * from employee");
		
//System.out.println(result);
		//5  --->  iterate the data and verify of fetch
		
		while(result.next()){
		String empName = result.getString(4);
		int empId = result.getInt(1);
		System.out.println(empName + "----->" + empId);
		
			}


       connection.close();
	

	}



}


