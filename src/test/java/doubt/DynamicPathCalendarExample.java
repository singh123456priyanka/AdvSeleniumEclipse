package doubt;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DynamicPathCalendarExample {

	public static void main(String[] args) throws AWTException, InterruptedException {

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		String month = "June 2023";
		String dayt="23";
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+dayt+"']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		month = "July 2023";
		dayt="20";
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+dayt+"']")).click();

		//driver.findElement(By.xpath("//div[text()='July 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='26']")).click();

	}

}
