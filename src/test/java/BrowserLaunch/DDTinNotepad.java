package BrowserLaunch;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDTinNotepad {

	public static void main(String[] args) throws IOException {
		
		//Amazon Iphone search and write list in notepad
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("iphone",Keys.ENTER);
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));	
		
		FileOutputStream fos= new FileOutputStream("./src/test/resources/pp.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		for(int i=0;i<list.size();i++)
		{
			bw.write(list.get(i).getText());
			bw.newLine();
		}
		bw.close();
		driver.close();

	}

}
