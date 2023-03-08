package practiceSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifingDataFromDataBase {
	public static void main(String []args) throws SQLException {
		//. create  instance for Driver ---> register driver to jdbc

		Driver dbdriver= new Driver();
		DriverManager.registerDriver(dbdriver);


		//	DriverManager.registerDriver(new Driver());


		//Step2 .. get connection --> bdurl, un , psw,  : url --> jdbc:mysql://localhost:3306/mydb
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/project", "root@%", "root");



			//3: steP create statement... return type is statement 

			Statement statement = connection.createStatement();

			// 4 Execute query 
			int result = statement.executeUpdate("insert into employee value(2024, 'vamsi',7959,95151564,'pradesh');");
			//int result1 = statement.executeUpdate("update employee set phone_number='909790125'where emp_name ='vamsi';");
			//int result2 = statement.executeUpdate("delete from employee where emp_name='vamsi';");
			//int result3 = statement.executeUpdate("alter table employee drop column


			//5  --->  iterate the data and verify of fetch
			if(result==1) {
				System.out.println("Data added sucessfully");
				//System.out.println("Data Updated sucessfully");
				//System.out.println("Data Deleted sucessfully");
			}
		}

		finally {
			connection.close();
			System.out.println("connection closed");
		}



	}


}

