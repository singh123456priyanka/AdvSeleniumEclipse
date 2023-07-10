package BrowserLaunch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WriteReadInNotepad {

	public static void main(String[] args) throws IOException, InterruptedException {

		//Using FileOutputStream and FileInputStream
		//Write
		FileOutputStream fos=new FileOutputStream("./src/test/resources/pp.txt");
		OutputStreamWriter ow = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(ow);
		
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
			bw.write(alllinks.get(i).getText());
			bw.newLine();
						
		}		
		bw.close();	
		
		//Read
		FileInputStream fis= new FileInputStream("./src/test/resources/pp.txt");
		InputStreamReader isr = new InputStreamReader (fis);
		BufferedReader br= new BufferedReader(isr);
		
		String data;
		while((data=br.readLine()) !=null ) {
			System.out.println(data);
		}
		
		br.close();		
	}

}
