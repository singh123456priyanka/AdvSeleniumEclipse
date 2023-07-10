package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	@Test(dataProvider="dataExecute")
	public void bookTicket(String src,String dest) {
		System.out.println("Book the tickets from "+src+" to "+dest);
	}
	
	
	
	@DataProvider
	public Object[][] dataExecute() {
		Object[][] obj= new Object[2][2];
		obj[0][0]="Bangalore";
		obj[0][1]="Delhi";
		obj[1][0]="Delhi";
		obj[1][1]="Bangalore";	
		
		return obj;
		
	}

}
