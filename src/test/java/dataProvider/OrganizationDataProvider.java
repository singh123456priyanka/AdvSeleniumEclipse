package dataProvider;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrganizationDataProvider {
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
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
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
	public Object[][] getData(){
		 Random ran = new Random();
		 int ranNum = ran.nextInt(100);
		Object[][] obj=new Object[3][3];
		obj[0][0]="QSP"+ranNum;
		obj[0][1]="9127364454";
		obj[0][2]="abc@gmail.com";
		obj[1][0]="JSP"+ranNum;
		obj[1][1]="9473364454";
		obj[1][2]="fgh@gmail.com";
		obj[2][0]="RSP"+ranNum;
		obj[2][1]="7799364454";
		obj[2][2]="xyz@gmail.com";
		return obj;
		
	}

}
