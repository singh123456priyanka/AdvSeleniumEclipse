package others;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;

public class CreatingInvoice {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		Excel_Utility elib = new Excel_Utility();	

		WebDriver driver= new ChromeDriver();
		JavascriptExecutor js= (JavascriptExecutor)driver;		

		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
		//creating Contact
	/*	driver.findElement(By.xpath("//td[@class='tabUnSelected'][4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		Thread.sleep(2000);
		String fname = elib.getData2FromExcel("contactSheet", 1, 0)+ranNum;
		String lname = elib.getData2FromExcel("contactSheet", 0, 1);
		String mobile = elib.getData2FromExcelUsingDataFormatter("contactSheet",0, 2);
        String email = elib.getData2FromExcelUsingDataFormatter("contactSheet", 1, 3);
        
        Select dropdown=new Select(driver.findElement(By.name("salutationtype")));
        dropdown.selectByVisibleText("Mr.");
		Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys(fname);
		Thread.sleep(2000);
        driver.findElement(By.name("lastname")).sendKeys(lname);
		Thread.sleep(2000);
		driver.findElement(By.id("mobile")).sendKeys(mobile);
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='button'][1]")).click();*/
		
		String pname = elib.getDataFromExcel("productSheet", 0,0)+ranNum;		
		//creating product
		driver.findElement(By.xpath("//a[text()='Products']")).click();		
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(pname);		
		js.executeScript("window.scrollTo(602,1152)");		
		WebElement saveButton = driver.findElement(By.xpath("//textarea[@class='detailedViewTextBox']/parent::td/parent::tr/following-sibling::tr[2]//td//div/input[1]"));
		Thread.sleep(1000);
		saveButton.click(); 

		//moving to more button
		Actions act = new Actions(driver); 
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"))).perform();
		Thread.sleep(1000);
		
		//sales order creating
		driver.findElement(By.xpath("//a[@id='more' and @name='Sales Order' ]")).click();
		driver.findElement(By.xpath("//img[@title='Create Sales Order...']")).click();
		String subject = elib.getData2FromExcel("salesorderSheet", 0, 0)+ranNum;
		driver.findElement(By.name("subject")).sendKeys(subject);
		
		driver.findElement(By.xpath("//td[@class='dvtCellInfo'][2]/child::input/following-sibling::img[1]")).click();
		driver.findElement(By.linkText("Qspiders728")).click();
		
		String parent = driver.getWindowHandle();
		//scroll down
		WebElement pro = driver.findElement(By.id("searchIcon1"));
		for(;;) {
			try 
			{	pro.click();
				break;
			}
			catch(NoSuchElementException e)
			{
				js.executeScript("window.scrollBy(0,400);");
				Thread.sleep(1000);
			}
		}
		//product window
		Set<String> allwin = driver.getWindowHandles();
		System.out.println(allwin.toString());
//		Iterator<String> itr = allwin.iterator();
//		while(itr.hasNext()) {
//			String win = itr.next();
//			driver.switchTo().window(win);
//			if(driver.getTitle().contains("Products&action")){
//				break;
//			}
//		}
//		driver.manage().window().maximize();				
//		driver.findElement(By.name("search_text")).sendKeys(pname);
//		
		
		for(String win:allwin)
		{
			System.out.println(driver.getTitle());
			driver.switchTo().window(win);

		}
		
		driver.manage().window().maximize();				
		driver.findElement(By.name("search_text")).sendKeys(pname);
		driver.findElement(By.name("search")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("select_all")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		driver.switchTo().window(parent);
		Thread.sleep(3000);
		
		String qty = elib.getData2FromExcelUsingDataFormatter("salesorderSheet", 0, 1);
		String listprice = elib.getData2FromExcelUsingDataFormatter("salesorderSheet", 0, 2);
		
		driver.findElement(By.id("qty1")).sendKeys(qty);
		Thread.sleep(2000);
		driver.findElement(By.id("listPrice1")).clear();
		driver.findElement(By.id("listPrice1")).sendKeys(listprice);
		Thread.sleep(4000);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		

	}

}
/*contactName =//input[@name="contact_name"]/parent::td[@class="dvtCellInfo"]/input[@name="contact_id"]/following-sibling::img
organizationName=//td[text()="Organization Name 			"]/following-sibling::td/input/following-sibling::img
salesOrder=//td[@class='dvtCellLabel'][2]/following-sibling::td/input/following-sibling::img[1]*/