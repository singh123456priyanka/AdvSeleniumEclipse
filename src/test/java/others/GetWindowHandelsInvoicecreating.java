package others;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GetWindowHandelsInvoicecreating {

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
		driver.findElement(By.linkText("Invoice")).click();		
		driver.findElement(By.xpath("//img[@title='Create Invoice...']")).click();
		driver.findElement(By.name("subject")).sendKeys("Hp Invoice");
		
		String parentwin = driver.getWindowHandle();
		String title = driver.getTitle();
		System.out.println("parent:"+title);
		
		
		driver.findElement(By.xpath("//img[@title='Select'and @src='themes/softed/images/select.gif'][1]")).click();
		
		Set<String> allwindows = driver.getWindowHandles();
		for(String win:allwindows) {
			driver.switchTo().window(win);
			title=driver.getTitle();
			System.out.println(title);
			if(!driver.getTitle().contentEquals("Administrator - Invoice - vtiger CRM 5 - Commercial Open Source CRM")) 
			{
				driver.close();
			}
		}
		driver.switchTo().window(parentwin);
		
	}

}
