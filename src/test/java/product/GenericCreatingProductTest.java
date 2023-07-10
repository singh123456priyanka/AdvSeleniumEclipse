package product;

import java.io.IOException;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import POMOrganization.CreateProductPage;
import POMOrganization.HomePage;

public class GenericCreatingProductTest extends BaseClass {
@Test(groups={"regressionTest","smokeTest"})
	public void genericCreatingProductTest()throws IOException, InterruptedException {

		//File_Utility flib = new File_Utility();
		Webdriver_Utility wlib = new Webdriver_Utility();
		Java_Utility jlib = new Java_Utility();
		
		int ranNum = jlib.getRandomNum();		
				
		//caling POM class HomePage
		HomePage hlib = new HomePage(driver);
		hlib.productButtonClick();				
		Excel_Utility elib = new Excel_Utility();
		String pname = elib.getDataFromExcel("productSheet", 0,0)+ranNum;	
		CreateProductPage createPro = new CreateProductPage(driver);
		createPro.clickOnImgPlus();
		Thread.sleep(2000);
		createPro.dataToBeAddedInProductPage(pname);
		Thread.sleep(1000);
		createPro.save2(driver);
		wlib.refresh(driver);		
	
	
	}

}
