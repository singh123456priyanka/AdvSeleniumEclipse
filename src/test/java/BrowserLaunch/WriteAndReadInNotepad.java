package BrowserLaunch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WriteAndReadInNotepad {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Using FileWriter and FileReader
		//Writing in txt file
		FileWriter writer = new FileWriter("./src/test/resources/pp.txt");		
		WebDriver driver= new ChromeDriver();		
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Thread.sleep(3000);		
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@class='eFQ30H'][3]"))).perform();		
		Thread.sleep(2000);
		List<WebElement> alllinks = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC'] //a"));		
		for(int i=0;i<alllinks.size();i++)
		{
			writer.write(alllinks.get(i).getText());
			writer.write("\n");			
		}		
		writer.close();	
		
		//Reading from txt file		
		FileReader reader= new FileReader("./src/test/resources/pp.txt");
		BufferedReader br= new BufferedReader(reader);		
		String value;		
		while((value=br.readLine())!=null)
		{
			System.out.println(value);					
		}
		reader.close();

	}

}
