package dataProvider;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Generic_Utility.Excel_Utility;

public class ExcelOrganizationDataProvider {
@Test(dataProvider="getData")
public void organizationCreate(String orgName,String phn,String email) throws Throwable {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("http://localhost:8888/");
			Thread.sleep(1000);
	driver.findElement(By.name("user_name")).sendKeys("admin");
			Thread.sleep(1000);
	driver.findElement(By.name("user_password")).sendKeys("admin");
			Thread.sleep(1000);
	driver.findElement(By.id("submitButton")).click();	
	
	driver.findElement(By.xpath("//a[text()='Organizations'][1]")).click();
	driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();		
	Random ran = new Random();
	int ranNum = ran.nextInt(200);
	driver.findElement(By.name("accountname")).sendKeys(orgName+ranNum);
	driver.findElement(By.id("phone")).sendKeys(phn);
	driver.findElement(By.id("email1")).sendKeys(email);		
	driver.findElement(By.xpath("//input[@name='button'][1]")).click();
			Thread.sleep(2000);
	driver.findElement(By.xpath("//td[@class='small']//td[2]")).click();
			Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();		
			Thread.sleep(4000);
	driver.quit();
		
}	

@DataProvider
/*public Object[][] getData() throws Exception, Exception{
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\DataProvider (1).xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Sheet1");
	DataFormatter db = new DataFormatter ();
	int lastRow=sheet.getPhysicalNumberOfRows();
	int lastCol=sheet.getRow(0).getPhysicalNumberOfCells();
	System.out.println("RowCount: "+lastRow);
	System.out.println("ColumnCount: "+lastCol);

	Object[][] obj= new Object[lastRow][lastCol];
	for(int i=0;i<lastRow;i++) {
		for(int j=0;j<lastCol;j++) {			
			obj[i][j]=	db.formatCellValue(sheet.getRow(i).getCell(j));
		}
	}
	return obj;
}*/
public Object[][] getData() throws Exception{
	Excel_Utility elib= new Excel_Utility();
	String file_source = ".\\src\\test\\resources\\DataProvider (1).xlsx";
	String sheet="Sheet1";		
	return elib.getMultipleData(file_source, sheet);
	}


}
