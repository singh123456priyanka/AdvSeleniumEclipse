package campaign;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import POMCampaign.POMCampaignCreation;
import POMOrganization.CreatingCampaignPage;
import POMOrganization.HomePage;

public class GenericCreatingCampaignTest extends BaseClass {

	@Test
//	@Test(retryAnalyzer=Generic_Utility.RetryAnlayser.class)//retryAnalyser executing 2 times because of failure
	public void genericCreatingCampaignTest() throws IOException, InterruptedException {
		//all utility files
		Webdriver_Utility wlib = new Webdriver_Utility();
	//	File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();		
		//Calling POM class HomePage
		HomePage hlib = new HomePage(driver);
		hlib.moreButtonClick();
		hlib.campaignButtonClick();
		//Calling CreatingCampaignPage POM class
		CreatingCampaignPage creCamp = new CreatingCampaignPage(driver);
		creCamp.clickOnImg();
		Thread.sleep(1000);		
		int ranNum = jlib.getRandomNum();
		//Fetching values from excel sheet 
		String campname = elib.getDataFromExcel("campaignSheet",0,0)+ranNum;
		creCamp.dataToBeFilledCampaign(campname);
		creCamp.save2(driver);
		Thread.sleep(1000);
		wlib.refresh(driver);
		Thread.sleep(3000);
		//1.verification of campaign name textbox data fetched through excel
		POMCampaignCreation valid = new POMCampaignCreation(driver);
		valid.campNameTxt(campname);
		Assert.assertEquals(true, false);
	
	/*	String actData= driver.findElement(By.id("dtlview_Campaign Name")).getText();
		{
			System.out.println("1.Campaign Name from excel verification:");
				if(actData.contains(campname)) {
							System.out.println("<--pass-->");
					}
			else {
				System.out.println("<--fail-->");
			}
		}*/
		
		//1.verification of campaign page 
		String expTitleHas = campname;
		valid.campCreatePageValSoftAssert(expTitleHas);		
		valid.doAllAssert();
		
	/*	actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();				
		{
			System.out.println("1.Campaign page verification:");
			if(actData.contains(campname)) {		
			System.out.println("<--pass-->");
			}
			else {
			System.out.println("<--fail-->");
			}
		}*/				
	}
	/*@Test
	public void genericCreatingOrganizationTest() throws EncryptedDocumentException, IOException, InterruptedException {
				Webdriver_Utility wlib = new Webdriver_Utility();
				//File_Utility flib = new File_Utility();	
				Java_Utility jlib = new Java_Utility();
				int ranNum = jlib.getRandomNum();								
				//calling Excel_utility
				Excel_Utility excel = new Excel_Utility();
				String orgname = excel.getDataFromExcel("organizationSheet",0,0)+ranNum;
				String phn = excel.getDataFromExcelUsingDataFormatter("organizationSheet", 1, 1);
				String email = excel.getDataFromExcelUsingDataFormatter("organizationSheet", 0, 2);
				//Creating Organization				
				//caling POM class HomePage
				HomePage hlib = new HomePage(driver);
				hlib.organizationButtonClick();
				//calling POM CreateOrganizatioPage class
				CreateOrganizationPage creOrg = new CreateOrganizationPage(driver);
				creOrg.clickOnPLUSImg();
				creOrg.sendOrgData(orgname, phn, email);
				Thread.sleep(4000);
				creOrg.save();				
				Thread.sleep(2000);
				wlib.refresh(driver);
				Thread.sleep(2000);
			//2.verification of campaign page 
			String actData = driver.findElement(By.className("dvHeaderText")).getText();
			{
				System.out.println("Organization page verification:");
				if(actData.contains(orgname)) {						
					System.out.println("<--pass-->");
					}
				else {
					System.out.println("<--fail-->");
					}
			}
			actData = driver.findElement(By.id("dtlview_Organization Name")).getText();
			{	
				System.out.println("1.Organization text box Name from excel verification:");			
				if(actData.contains(orgname)) {				
					System.out.println("<--pass-->");
				}
				else {
					System.out.println("<--fail-->");
				}				
			}
			actData = driver.findElement(By.id("dtlview_Phone")).getText();
			{
				System.out.println("2.Phn textbox number from excel verification:");			
				if(actData.contains(phn)) {				
					System.out.println("<--pass-->");
				}
				else {
					System.out.println("<--fail-->");
				}				
			}
			actData = driver.findElement(By.id("dtlview_Email")).getText();
			{
				System.out.println("3.Email txtbox Name from excel verification:");			
				if(actData.contains(email)) {				
					System.out.println("<--pass-->");
				}
				else {
					System.out.println("<--fail-->");
				}				
			}			
				
	}*/

}
