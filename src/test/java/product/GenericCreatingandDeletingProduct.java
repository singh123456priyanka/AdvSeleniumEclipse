package product;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;

public class GenericCreatingandDeletingProduct  {

	public static void main(String[] args) throws IOException, InterruptedException {
	/*			//Retrieving from Properties file
				FileInputStream fis = new FileInputStream(new File("./src/test/resources/vtigerCredential.properties"));
				Properties prop = new Properties();
				prop.load(fis);*/
				
				//launching 
				WebDriver driver = new ChromeDriver();
				Webdriver_Utility wlib = new Webdriver_Utility();				
				wlib.maxWindow(driver);				
				wlib.implicitwait(driver);
				
			/*	driver.get(prop.getProperty("url"));		
				Thread.sleep(1000);
				driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("user"));
				Thread.sleep(1000);
				driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
				Thread.sleep(1000);
				driver.findElement(By.id("submitButton")).click();*/
				File_Utility flib = new File_Utility();
				String URL = flib.getStringKeyandValue("url");
				String USERNAME = flib.getStringKeyandValue("user");
				String PASSWORD = flib.getStringKeyandValue("password");
				driver.get(URL);	
				Thread.sleep(1000);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
						Thread.sleep(1000);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
						Thread.sleep(1000);
				driver.findElement(By.id("submitButton")).click();									
				/*//creating Random Class
				Random ran = new Random();
				int ranNum = ran.nextInt(1000);*/
				
				Java_Utility jlib = new Java_Utility();
				int ranNum = jlib.getRandomNum();
				
				//Retrieving from Excel Sheet 
				/*FileInputStream fis1 = new FileInputStream(new File("./src/test/resources/vtigerExcelData.xlsx"));
				Workbook excel = WorkbookFactory.create(fis1);
				Sheet sheet2 = excel.getSheet("productSheet");
				Cell pcol_00 = sheet2.getRow(1).getCell(0);			
				String data = pcol_00.toString()+ranNum;						
				System.out.println(data);*/
				
				//calling Excel_utility
				Excel_Utility excel = new Excel_Utility();
				String proname = excel.getDataFromExcel("productSheet",1,0)+ranNum;
				
				//creating product
				driver.findElement(By.xpath("//a[text()='Products']")).click();		
				driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
				driver.findElement(By.name("productname")).sendKeys(proname);
				
//				JavascriptExecutor js= (JavascriptExecutor)driver;		
//				js.executeScript("window.scrollTo(602,1152)");
				 WebElement saveButton = driver.findElement(By.xpath("//textarea[@class='detailedViewTextBox']/parent::td/parent::tr/following-sibling::tr[2]//td//div/input[1]"));
				wlib.scrollUntilFindTheElement(driver, saveButton, 602, 1152);
				 Rectangle rect= saveButton.getRect();
				System.out.println("X="+rect.x);
				System.out.println("Y="+rect.y);
				Thread.sleep(1000);
				saveButton.click();
				wlib.refresh(driver);
				Thread.sleep(2000);

				
				//deleting Product
				Thread.sleep(3000);		
				driver.findElement(By.xpath("//a[text()='Products']")).click();		
				driver.findElement(By.name("search_text")).sendKeys(proname);		
				
//				WebElement dropdown= new Select(driver.findElement(By.id("bas_searchfield")));
//				dropdown.selectByVisibleText("Product Name");
				WebElement dropdown = driver.findElement(By.id("bas_searchfield"));
				wlib.dropdownVisisbleByTxt(dropdown,"Product Name");
				
				driver.findElement(By.name("submit")).click();
				Thread.sleep(3000);		
				driver.findElement(By.name("selectall")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
				
				//driver.switchTo().alert().accept();
				wlib.alertACCEPT(driver);
				
				Thread.sleep(2000);		
				driver.findElement(By.xpath("//a[text()='Products']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//td[@class=\"small\"]//td/following-sibling::td/img[@src='themes/softed/images/user.PNG']")).click();
				Thread.sleep(1000);
				driver.findElement(By.linkText("Sign Out")).click();
				Thread.sleep(1000);
				driver.close();

	}

}
