package others;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowHandelExample {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://licindia.in/home");
		String parentwin = driver.getWindowHandle();		
		System.out.println("Parent Window: "+driver.getTitle());
		driver.findElement(By.xpath("	//a[@title='Login to Customer Portal']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		Set<String> wins = driver.getWindowHandles();
		 Iterator<String> itr = wins.iterator();
		 while(itr.hasNext()) {
			 String win=itr.next();
			 String title = driver.switchTo().window(win).getTitle();
			 System.out.println(title);
			 Thread.sleep(2000);
			 if(driver.getTitle().contains("Life Insurance Corporation of India")) {
					driver.findElement(By.xpath("//span[contains(text(),'Product ')]")).click();
					break;	
					}
			}		 
		 System.out.println("\n");
		 int i=0;
		 Set<String> allwins = driver.getWindowHandles();
			Iterator<String> itr2 = allwins.iterator();
			while(itr2.hasNext()) {
				String win2 = itr2.next();
				driver.switchTo().window(win2);
				String title2 = driver.getTitle();
				System.out.println(title2);
				Thread.sleep(2000);
				System.out.println(++i+"window");
				driver.close();
				//closes child window
//				if (driver.getCurrentUrl().contains("ecms.licindia.in/eCMS/getfilesrc/1674102178asbJV7NYHJ")) 
//				{
//				 driver.close();
//				}
			}
	}

}
	
