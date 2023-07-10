package product;

import java.io.IOException;
import org.testng.annotations.Test;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import POMOrganization.CreateProductPage;
import POMOrganization.CreatingCampaignPage;
import POMOrganization.HomePage;

public class CreatingProductandCampaignGenericTest extends BaseClass {
@Test
	public void creatingProductandCampaignGenericTest()throws InterruptedException, IOException {
		//UTILITY files
		  Webdriver_Utility wlib = new Webdriver_Utility();
		//  File_Utility flib= new File_Utility();
		  Excel_Utility elib = new Excel_Utility();
		  Java_Utility jlib = new Java_Utility(); 				
				//creating Random Class
				int ranNum = jlib.getRandomNum();
				String pname = elib.getDataFromExcel("productSheet", 0,0)+ranNum;
				HomePage home = new HomePage(driver);
				home.productButtonClick();
				CreateProductPage crepro = new CreateProductPage(driver);
				crepro.clickOnImgPlus();
				crepro.dataToBeAddedInProductPage(pname);
				crepro.save2(driver);
				Thread.sleep(2000);
				home.moreButtonClick();
				Thread.sleep(1000);
				home.campaignButtonClick();
				Thread.sleep(1000);
				CreatingCampaignPage crecamp = new CreatingCampaignPage(driver);
				String parentwin = driver.getWindowHandle();
				crecamp.clickOnImg();
				String cname = elib.getDataFromExcel("campaignSheet", 0,0)+ranNum;
				crecamp.dataToBeFilledCampaign(cname);
				crecamp.AddProductPlusImg();
				Thread.sleep(2000);
				wlib.switchToChildWindowUsingParentWindowandSearchFileToBeClicked(driver, parentwin, pname);
				Thread.sleep(1000);
				wlib.switchToThisWindow(driver, parentwin);
				crecamp.save2(driver);
				
				//creating product
//				driver.findElement(By.xpath("//a[text()='Products']")).click();		
//				driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
//				driver.findElement(By.name("productname")).sendKeys(data);
//				Thread.sleep(3000);

				
			/*	JavascriptExecutor js= (JavascriptExecutor)driver;		
				js.executeScript("window.scrollTo(602,1152)");		
				
				WebElement saveButton = driver.findElement(By.xpath("//textarea[@class='detailedViewTextBox']/parent::td/parent::tr/following-sibling::tr[2]//td//div/input[1]"));
				Rectangle rect= saveButton.getRect();
				System.out.println("X="+rect.x);
				System.out.println("Y="+rect.y);
				Thread.sleep(1000);
				saveButton.click();
				Thread.sleep(3000);

				
				//creating Campaign
				Actions act= new Actions(driver);
				act.moveToElement(driver.findElement(By.xpath("//a[text()='More']"))).perform();		
				driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
				
				driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
				String parentwin = driver.getWindowHandle();
				System.out.println(parentwin);
				
				String cname1 = sheet1.getRow(1).getCell(0).toString();
				String cname = cname1+ranNum;

				driver.findElement(By.name("campaignname")).sendKeys(cname);
				driver.findElement(By.xpath("//input[@name='assigntype'][2]")).click();
				Thread.sleep(1000);
				
				Select dropdown= new Select(driver.findElement(By.name("campaigntype")));
				Thread.sleep(2000);
				dropdown.selectByVisibleText("Webinar");
				Thread.sleep(2000);				
				driver.findElement(By.xpath("//img[@title='Select']")).click();
				Set<String> allwindows = driver.getWindowHandles();
				for(String win:allwindows)
				{
					driver.switchTo().window(win);
					driver.manage().window().maximize();
					Thread.sleep(8000);

					if(!parentwin.equals(win))
					{
						driver.findElement(By.xpath("//a[text()='"+data+"']")).click();
						Thread.sleep(8000);
					}
				
				}
				//if we have already made pom class for create product do we have to again write new pom class for create and delete product
								
				driver.switchTo().window(parentwin);	
				Thread.sleep(2000);

				 driver.findElement(By.xpath("//textarea[@class='detailedViewTextBox']/parent::td/parent::tr/following-sibling::tr/td/div/input[1]")).click();
				Thread.sleep(2000);
				//				JavascriptExecutor js= (JavascriptExecutor)driver;
//				js.executeScript("arguments[0].scrollIntoView(false);",save);
//				save.click();
				
				driver.findElement(By.xpath("//td[@class=\"small\"]//td/following-sibling::td/img[@src='themes/softed/images/user.PNG']")).click();
				Thread.sleep(1000);
				driver.findElement(By.linkText("Sign Out")).click();
				Thread.sleep(1000);
				driver.close();		*/


	}

}
