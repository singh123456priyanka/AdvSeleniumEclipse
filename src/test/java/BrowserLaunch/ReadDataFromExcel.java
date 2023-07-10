package BrowserLaunch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream(new File("./src/test/resources/flipkart.xlsx"));
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Thread.sleep(3000);
		
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@class='eFQ30H'][3]"))).perform();
		
		//driver.findElement(By.xpath("//div[@class='eFQ30H'][3]")).click();
		Thread.sleep(2000);

		List<WebElement> alllinks = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC'] //a"));
				
		
		for(int i=0;i<alllinks.size();i++)
		{
			 Row row = sheet.getRow(i);
			 Cell cell = row.getCell(0);
			 cell.setCellValue(alllinks.get(i).getText());
		}
		
		FileOutputStream fos= new FileOutputStream("./src/test/resources/AmazonList.xlsx");
		wb.write(fos);
		wb.close();		
		
	}

}
