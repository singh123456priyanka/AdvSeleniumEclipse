package product;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import POMOrganization.CreateAndDeleteProductPage;
import POMOrganization.HomePage;

public class ProductAddandDeleteValidateClassroomExampleTest extends BaseClass {
@Test
	public void productAddandDeleteValidateClassroomExampleTest() throws InterruptedException, IOException {
				//All utility files
				Webdriver_Utility wlib = new Webdriver_Utility();
				//File_Utility flib = new File_Utility();
				Java_Utility jlib = new Java_Utility();
				Excel_Utility elib = new Excel_Utility();										
				HomePage hlib = new HomePage(driver);
				hlib.productButtonClick();					
		
		int ranNum = jlib.getRandomNum();
		String proData = elib.getDataFromExcel("productSheet", 2, 0)+ranNum;
		CreateAndDeleteProductPage dpro=new CreateAndDeleteProductPage(driver);
		dpro.clickOnImgPlus();
		dpro.dataToBeFilledProduct(proData);
		dpro.save2(driver);
		Thread.sleep(2000);
		String actData = driver.findElement(By.className("lvtHeaderText")).getText();
		{
			System.out.println("Product page validation:");
			if(actData.contains(proData))
			{
			 System.out.println("<--SCRIPT PASS-->");	
			}
			else
			{
			System.out.println("<--SCRIPT FAIL-->");
			}		
		}
		actData = driver.findElement(By.id("dtlview_Product Name")).getText();
		{
			System.out.println("Product Text Box validation:");
			if(actData.contains(proData))
			{
			 System.out.println("<-- PASS-->");	
			}
			else
			{
			System.out.println("<--FAIL-->");
			}		
		}
		wlib.refresh(driver);
		Thread.sleep(2000);
		hlib.productButtonClick();		
		driver.findElement(By.xpath("//table[@class=\"lvt small\"]//td//a[text()='"+proData+"']/../..//td[1]" )).click();
		Thread.sleep(3000);
		dpro.deleteProduct(driver);		
		Thread.sleep(2000);	
		List<WebElement> data = driver.findElements(By.xpath("(//table[@class='lvt small']//tbody//tr//td[3])[position()>1]"));
		Boolean flag= false;
		for( WebElement pro:data) {
			actData=pro.getText();
		if(actData.contains(proData))
		{	flag=true;
			break;
		}
		if(flag) {
			System.out.println("Product not found");
		}
		else {
			System.out.println("Product found "+"/n"+"not deleted");
		}
		}
	}

}
