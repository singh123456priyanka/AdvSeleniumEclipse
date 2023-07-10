package product;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreatingAndDeletingProduct {

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
		driver.findElement(By.xpath("//a[text()='Products']")).click();		
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		//Using RandomClass to avoid duplicate value.
		Random r= new Random();
		int randomNum = r.nextInt(1000);
		String data = "Hp Laptop"+randomNum;		
		driver.findElement(By.name("productname")).sendKeys(data);		
		JavascriptExecutor js= (JavascriptExecutor)driver;		
		js.executeScript("window.scrollTo(602,1152)");			
		WebElement saveButton = driver.findElement(By.xpath("//textarea[@class='detailedViewTextBox']/parent::td/parent::tr/following-sibling::tr[2]//td//div/input[1]"));
		Rectangle rect= saveButton.getRect();
		System.out.println("X="+rect.x);
		System.out.println("Y="+rect.y);
		Thread.sleep(1000);
		saveButton.click();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//a[text()='Products']")).click();		
		driver.findElement(By.name("search_text")).sendKeys(data);		
		Select dropdown= new Select(driver.findElement(By.id("bas_searchfield")));
		dropdown.selectByVisibleText("Product Name");		
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);		
		driver.findElement(By.name("selectall")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		driver.switchTo().alert().accept();
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
