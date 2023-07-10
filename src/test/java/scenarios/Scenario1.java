package scenarios;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import Generic_Utility.File_Utility;
import Generic_Utility.Webdriver_Utility;
import POMOrganization.HomePage;
import POMOrganization.LoginPage;
import POMScenarios.POMCreateProduct;

public class Scenario1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver= new ChromeDriver();
		File_Utility flib = new File_Utility();
		Webdriver_Utility wlib = new Webdriver_Utility();
		String URL = flib.getStringKeyandValue("url");
		driver.get(URL);
		wlib.maxWindow(driver);
		wlib.implicitwait(driver);
		String USER = flib.getStringKeyandValue("user");
		String PSW = flib.getStringKeyandValue("password");
		LoginPage log= new LoginPage(driver);
		log.loginApp(USER, PSW);
		HomePage home = new HomePage(driver);
		home.productButtonClick();
		driver.findElement(By.xpath("//img[contains(@src,'themes/softed/images/btnL3A')]")).click();
		Thread.sleep(1000);

		//POMCreateProduct crePro = new POMCreateProduct(driver);
		String parentwin = driver.getWindowHandle();
		driver.findElement(By.xpath("(//td[@class='dvtCellLabel'])[11]/following-sibling :: td/img")).click();
		Set<String> windows = driver.getWindowHandles();
		for(String win:windows) {
			String title = driver.switchTo().window(win).getTitle();
			Thread.sleep(2000);
			if(title.contains("Vendors&action"))
			{
				driver.switchTo().window(win);
			driver.findElement(By.xpath("//td//a[text()='AVendor']")).click();
			
			}
		}
		

	}

}
