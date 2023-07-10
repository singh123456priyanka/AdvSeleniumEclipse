package BrowserLaunch;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonList {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop",Keys.ENTER);
		List<WebElement> laptop_list = driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
		List<WebElement> laptop_price = driver.findElements(By.xpath("//span[@class='a-price']"));
		//printing the output in console
		for(int i=0;i<laptop_list.size();i++) {
			System.out.println((i+1)+"::" +laptop_list.get(i).getText()+"\t"+laptop_price.get(i).getText()+"\n");		
		}
		//printing the output in excel sheet
		//not working
		FileInputStream fis=new FileInputStream("./src/test/resources/AmazonList.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");							

		for(int i=0;i<laptop_list.size();i++) {
			sheet.createRow(i).createCell(0).setCellValue(laptop_list.get(i).getText());
			sheet.createRow(i).createCell(1).setCellValue(laptop_price.get(i).getText());
			//System.out.println(laptop_list.get(i).getText()+"\t"+laptop_price.get(i).getText()+"\n");		
		}
	FileOutputStream fos= new FileOutputStream("./src/test/resources/AmazonList.xlsx");
	wb.write(fos);
	wb.close();
	driver.close();

		
	}
}
