package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class Practice {

	public static void main(String[] args) throws SQLException  {
		//Load the mysql
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);		
		//Get connection with database	
		Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstdatabase", "root","root");
		Statement stat = connect.createStatement();
		//statement for query
		String query = "insert into mybatch(first_name,last_name,address) values('Siddhanta','Singh','America')";
		int result = stat.executeUpdate(query);		
		//search the result
		if(result==1) {
			System.out.println("Data updated");
		}
		else {
			System.out.println("Data Failed to update");
		}		
		//connection close
		connect.close();
	}

}
