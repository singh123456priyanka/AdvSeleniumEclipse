package BrowserLaunch;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.File_Utility;

public class Browser {

	public static void main(String[] args) throws IOException {
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getStringKeyandValue("browser");
		WebDriver driver=null;
		if (BROWSER.equalsIgnoreCase("Chrome")){
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Either way");
			driver= new ChromeDriver();
		}
		
	}

}
