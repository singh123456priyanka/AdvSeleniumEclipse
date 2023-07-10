package debugProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2CallingMethod {

	public static void main(String[] args) throws Throwable {
		ChromeDriver driver= new ChromeDriver();
		driver.get("http:/localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.name("user_password")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.id("submitButton")).click();	
		CallMax.maxwindow(driver);
		

	}

}
