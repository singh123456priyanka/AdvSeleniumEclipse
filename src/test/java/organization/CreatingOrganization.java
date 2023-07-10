package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatingOrganization {

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
		
		driver.findElement(By.xpath("//a[text()='Organizations'][1]")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();		
		
		driver.findElement(By.name("accountname")).sendKeys("Hello2");
		driver.findElement(By.id("phone")).sendKeys("9120645033");
		driver.findElement(By.id("email1")).sendKeys("abc@gmail.com");		
		driver.findElement(By.xpath("//input[@name='button'][1]")).click();
				Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@class='small']//td[2]")).click();
				Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();		
				Thread.sleep(4000);
		driver.close();
		

	}

}
