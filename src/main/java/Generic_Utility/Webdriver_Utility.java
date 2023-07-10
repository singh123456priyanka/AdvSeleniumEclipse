package Generic_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Webdriver_Utility {
	//1maximize the window
	public void maxWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	//2minimize the window
	public void minWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	//3move the mouse to element Action class
	public void moveMouseTo(WebDriver driver,WebElement ele) {
		Actions act= new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	//4right click mouse on element Action class
		public void rightClickMOuse(WebDriver driver,WebElement ele) {
			Actions act= new Actions(driver);
			act.contextClick(ele).perform();
		}
	
	//5double click the mouse on element Action class
		public void doubleClickMouse(WebDriver driver,WebElement ele) {
			Actions act= new Actions(driver);
			act.doubleClick(ele).perform();
		}
		
	//6double click the mouse on element Action class
		public void dragtheElementToMouse(WebDriver driver,WebElement src,WebElement dest) {
			Actions act= new Actions(driver);
			act.dragAndDrop(src,dest).perform();
		}
		
	//7scrolling to element
		public void scrollUntilFindTheElement(WebDriver driver,WebElement ele,int x,int y) 
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;			
			for(;;)
			{
				try
				{
					  ele.click();
				}
				catch(NoSuchElementException e)
				{
					js.executeScript("window.scrollBy(x,y);");
				}
			}
			
		}
	//8move to the element scroll by 	
		public void scrolltoParticularElement(WebDriver driver,WebElement ele, Boolean boolTorF) 
		{			
				JavascriptExecutor js= (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView("+boolTorF+");",ele);
		}
	//9take screenshot of page
		public void takeScreenshotofWebpage ( WebDriver driver,String url) throws IOException {
			driver.get(url);
			RemoteWebDriver rm = (RemoteWebDriver) driver;
			File src = rm.getScreenshotAs(OutputType.FILE);
			File dest= new File("./screenshotAdv/Webpage1.png");			
			Files.copy(src, dest );
			
		}
		
	//10take screenshot of element
		public void takeScreenshotOfElement(WebDriver driver,WebElement ele) throws IOException {
			WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(2000));			
			wait.until(ExpectedConditions.visibilityOf(ele)) ;
			File src = ele.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshotAdv/Element1.png");
			Files.copy(src, dest);
		}
		
	//11switching on windows 
		public void switchtoWindows(WebDriver driver,String title)
		{
			Set<String> allwin = driver.getWindowHandles();
			Iterator<String> itr = allwin.iterator();
				while(itr.hasNext()) 
				{
					String window=itr.next();
					driver.switchTo().window(window);
					if(driver.getTitle().contains(title)) {
					break;
				}					
			}
		}
		
	//12 switch to window	
		public void switchToThisWindow(WebDriver driver,String win) {
			//String win = driver.getWindowHandle();
			driver.switchTo().window(win);
		}
	//13 implicitwait
		public void implicitwait(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		}
	//14 refresh
		public void refresh(WebDriver driver) {
			driver.navigate().refresh();
		}
		//15 alert accept
				public void alertACCEPT(WebDriver driver) {
					driver.switchTo().alert().accept();
				}
		//16 alert dismiss
				public void alertDISMISS(WebDriver driver) {
					driver.switchTo().alert().dismiss();;
				}
		//17 dropdown select by visisble txt
				public void dropdownVisisbleByTxt(WebElement ele,String txt) {
					Select dropdown= new Select(ele);
					dropdown.selectByVisibleText(txt);
				}
		//18 switch to iframe
				public void iframeSwitch(WebDriver driver,WebElement ele) {
					driver.switchTo().frame(ele);
					driver.switchTo().parentFrame();

				}
				
		//19 switch to parent iframe
				public void iframeParentSwitch(WebDriver driver) {
					driver.switchTo().parentFrame();

				}
				
		//20 switch using diff approach				
				public void switchToChildWindowUsingParentWindowandSearchFileToBeClicked(WebDriver driver,String parentwin,String pname) throws InterruptedException {
				Set<String> allwin = driver.getWindowHandles();
				Iterator<String> itr = allwin.iterator();
				while(itr.hasNext()) {
					 String win = itr.next();
					 driver.switchTo().window(win);
					 Thread.sleep(1500);
					 if (!parentwin.equals(win)) {
						Thread.sleep(700);
						driver.findElement(By.xpath("//a[text()='"+pname+"']")).click();
					}
				
				}
			}

		

}
