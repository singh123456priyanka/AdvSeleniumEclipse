package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class WriteDataToDatbaseMYSQL {

	public static void main(String[] args) throws SQLException {
		//Register or load the mysql database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
	//Get connection to the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdatabase ","root","root" );
	//create statement
		Statement stat = connection.createStatement();
		
		 String query = "INSERT INTO mybatch(FIRST_NAME,LAST_NAME,ADDRESS)values('Siddhartha','Singh','Agra')";
		 int result = stat.executeUpdate(query);

		 if(result==1)
		 {
			 System.out.println("data updated");
		 }
		 else
		 {
			 System.out.println("data not updated");
		 }
	

		 connection.close();		 

	}

}
