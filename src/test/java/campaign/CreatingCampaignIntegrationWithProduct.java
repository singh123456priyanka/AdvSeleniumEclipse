package campaign;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;

public class CreatingCampaignIntegrationWithProduct {

	public static void main(String[] args) throws InterruptedException, IOException {
		//all utility files
		Webdriver_Utility wlib = new Webdriver_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
	
		WebDriver driver = new ChromeDriver();
		wlib.maxWindow(driver);
		wlib.implicitwait(driver);
		
		//using utility file flib,assigning values for login page ,fetching it from property file		
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

		WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
		wlib.moveMouseTo(driver, more);
		
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		String parentwin = driver.getWindowHandle();
		//System.out.println(parentwin);
		
		int ranNum = jlib.getRandomNum();
		driver.findElement(By.name("campaignname")).sendKeys("HP Laptop Campaign"+ranNum);
		driver.findElement(By.xpath("//input[@name='assigntype'][2]")).click();
		Thread.sleep(1000);
		
		Select dropdown= new Select(driver.findElement(By.name("campaigntype")));
		Thread.sleep(1000);
		dropdown.selectByVisibleText("Webinar");
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		wlib.switchtoWindows(driver,"Products&action");
		
//		Set<String> allwindows = driver.getWindowHandles();
//		for(String win:allwindows)
//		{
//			driver.switchTo().window(win);
//			if(!parentwin.equals(win))
//			{
//				driver.findElement(By.xpath("//a[text()='Hp Laptop']")).click();
//			}
//		
//		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
//		Thread.sleep(1000);
//		driver.close();
		Thread.sleep(2000);

		
		//driver.switchTo().window(parentwin);	
		wlib.switchToThisWindow(driver,parentwin);
		Thread.sleep(3000);
		
		WebElement save = driver.findElement(By.xpath("//textarea[@class='detailedViewTextBox']/parent::td/parent::tr/following-sibling::tr/td/div/input[1]"));
//		JavascriptExecutor js= (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(false);",save);
		wlib.scrolltoParticularElement(driver, save, false);
		save.click();
		wlib.refresh(driver);
		Thread.sleep(2000);
		//1.verification of campaign page 
				String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				{
					System.out.println("Campaign page verification:");
					if(actData.contains("HP")) {
				
					System.out.println("<--pass-->");
					}
					else {
					System.out.println("<--fail-->");

					}
				}

		
		driver.findElement(By.xpath("//td[@class=\"small\"]//td/following-sibling::td/img[@src='themes/softed/images/user.PNG']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(1000);
		driver.close();
	}

}
