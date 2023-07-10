package Generic_Utility;

import java.io.File;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class ListenerImplementation implements ITestListener {
	public void onTestFailure(ITestResult result) {
		/*{1.for single failure screenshot
			String testData= result.getMethod().getMethodName();
		System.out.println("Test data method name: "+testData);
		EventFiringWebDriver efdriver = new EventFiringWebDriver(BaseClass.Sdriver);
		File src = efdriver.getScreenshotAs(OutputType.FILE);		
		try {
			Files.copy(src,new File("./screenshotAdv/"+testData+".png"));
			}
		catch(Exception e) {
			e.printStackTrace();
			}
		
		Java_Utility jlib = new Java_Utility();
		System.out.println("Local time: ");
		jlib.getLocDate();
		System.out.println("\nSystem time: ");
		jlib.getSysDate();
		
		}*/
		//follow ListenerTestng.xml and screen shot
		
		//2. for multiple failure screenshot
		{
			String testName=result.getMethod().getMethodName();
			System.out.println("-----execute-----");
			
			TakesScreenshot screen=( TakesScreenshot)BaseClass.Sdriver;
			File src=screen.getScreenshotAs(OutputType.FILE);
			LocalDateTime localDateTime = LocalDateTime.now();//with help of date and time we store the file or else its not possible
			localDateTime.toString().replace(" ", "-").replace(":","/");
			File dest=new File("./screenshotAdv/"+testName+".png");
			
			try {
				Files.copy(src,dest);
				}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Problem is saving screenshot"+e.getMessage());

				}
			//follow ListenerMultipleFailuretestng.xml and 2 screenshot 
		}
		
		
	
		
	}
	

}
