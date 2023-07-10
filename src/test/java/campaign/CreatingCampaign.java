package campaign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreatingCampaign {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
				Thread.sleep(1000);
		driver.findElement(By.name("user_name")).sendKeys("admin");
				Thread.sleep(1000);
		driver.findElement(By.name("user_password")).sendKeys("admin");
				Thread.sleep(1000);
		driver.findElement(By.id("submitButton")).click();	
		
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='More']"))).perform();
		
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys("HP Campaign");
		WebElement save = driver.findElement(By.xpath("//textarea[@class='detailedViewTextBox']/parent::td/parent::tr/following-sibling::tr/td/div/input[1]"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false);",save);
		save.click();
		
		driver.findElement(By.xpath("//td[@class=\"small\"]//td/following-sibling::td/img[@src='themes/softed/images/user.PNG']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(1000);
		driver.close();
		
		
	
	}

}
