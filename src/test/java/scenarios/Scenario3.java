package scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import POMOrganization.HomePage;
import POMOrganization.LoginPage;
import POMScenarios.POMCreateOrganizationPage;

public class Scenario3 {

	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		File_Utility flib=new File_Utility();
		String URL = flib.getStringKeyandValue("url");
		driver.get(URL);
		Webdriver_Utility wlib= new Webdriver_Utility();
		wlib.maxWindow(driver);
		wlib.implicitwait(driver);		
		String USER = flib.getStringKeyandValue("user");
		String PSW = flib.getStringKeyandValue("password");
		LoginPage log= new LoginPage(driver);
		log.loginApp(USER, PSW);
		HomePage home= new HomePage(driver);
		Thread.sleep(1000);
		home.organizationButtonClick();
		POMCreateOrganizationPage creorg= new POMCreateOrganizationPage(driver);
		creorg.ClickImgPlusOrganization();
		
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		String oname = elib.getData3FromExcel("problemSheet", 10,0)+ranNum;
		String indData = elib.getData3FromExcelUsingDataFormatter("problemSheet", 10, 1);
		String typeData = elib.getData3FromExcel("problemSheet", 10, 2);
		
		creorg.FillDataFrmexcel(oname,indData,typeData);
		creorg.Save();
		Thread.sleep(3000);		
		home.signoutButtonClick(driver);
		driver.close();		
	}

}
