package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;

public class DataProviderExExcel {
	@Test(dataProvider="dataExecute")
	public void bookTicket(String src,String dest) {
		System.out.println("Book the tickets from "+src+" to "+dest);
	}
	
	@DataProvider
	public Object[][] dataExecute() throws Throwable {
		Excel_Utility elib = new Excel_Utility();
		String file_source = ".\\src\\test\\resources\\DataProvider (1).xlsx";
		String sheet="Sheet2";		
		return elib.getMultipleData(file_source, sheet);
	}

}
