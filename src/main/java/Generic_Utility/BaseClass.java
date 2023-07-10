package Generic_Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import POMOrganization.HomePage;
import POMOrganization.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver Sdriver;// @listener Step 2 neeche step 3 hai
	
	@BeforeSuite(groups={"regressionTest","smokeTest"})
	public void beforeSuite() {
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest(groups={"regressionTest","smokeTest"})
	public void beforeTest() {
		System.out.println("Parallel execution");
	}
	
	//@Parameters("BROWSER")//TestNG Data driven from XML files
	@BeforeClass(groups={"regressionTest","smokeTest"})
	
	public void beforeClass() throws IOException {
	//public void beforeClass(String BROWSER) throws IOException {
		System.out.println("Launching the Browser");
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getStringKeyandValue("browser");
		driver=null;
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
		Sdriver=driver;						//@listener step 3 , step 4 createorganizaton me pahucho
	}
	
	//@Parameters("URL") //TestNG Data driven from XML files
	@BeforeMethod(groups={"regressionTest","smokeTest"})
	//public void beforeMethod(String URL) throws IOException, InterruptedException {
	public void beforeMethod() throws IOException, InterruptedException {

		System.out.println("Login to Application");
		File_Utility flib = new File_Utility();
		Webdriver_Utility wlib = new Webdriver_Utility();
		//maximize window
		wlib.maxWindow(driver);
		//implicit wait
		wlib.implicitwait(driver);
		//String URL = flib.getStringKeyandValue("url");
		String USERNAME = flib.getStringKeyandValue("user");
		String PASSWORD = flib.getStringKeyandValue("password");
		String URL= flib.getStringKeyandValue("url");
		driver.get(URL);	
		Thread.sleep(1000);	
		LoginPage log = new LoginPage(driver);
		log.loginApp(USERNAME, PASSWORD);
	}

	@AfterMethod(groups={"regressionTest","smokeTest"})
	public void afterMethod() throws InterruptedException {
		System.out.println("Logout from Application");
		HomePage home = new HomePage(driver);
		Thread.sleep(1000);
		home.signoutButtonClick(driver);
		Thread.sleep(1000);
	}
	
	@AfterClass(groups={"regressionTest","smokeTest"})
	public void afterClass() throws InterruptedException {
		System.out.println("Closing the browser");
		Thread.sleep(1000);
		driver.close();
	}
	
	@AfterTest(groups={"regressionTest","smokeTest"})
	public void afterTest() {
		System.out.println("Close Parallel Execution");
		}
	
	@AfterSuite(groups={"regressionTest","smokeTest"})
	public void afterSuite() {
		System.out.println("Close DataBase Connection");
	}
	

}
