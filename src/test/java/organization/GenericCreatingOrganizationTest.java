package organization;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import POMOrganization.CreateOrganizationPage;
import POMOrganization.HomePage;
import POMValOrganization.POMValidateOrganization;

public class GenericCreatingOrganizationTest extends BaseClass {

	@Test
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
				Thread.sleep(3000);
				//wlib.refresh(driver);				
			//2.verification of Organization page 
				POMValidateOrganization valOrgPage = new POMValidateOrganization(driver);
				String actData = valOrgPage.getValOrgPage().getText();// through getter
				Assert.assertTrue(actData.contains(orgname));
				//data check
				//calling method from pom class
				valOrgPage.assertOrgtextbox(phn); 		//@listener step 4 orgname k bale phn do,fail hoga to trigger hoga
														//step 5 @listener ab convert xml file ListenerTestNG banao
				valOrgPage.assertPhntextbox(phn);
				valOrgPage.assertEmailtxtbox(email);

				
				
				
				
				
			/*String actData = driver.findElement(By.className("dvHeaderText")).getText();
			{
				System.out.println("Organization page verification:");
				if(actData.contains(orgname)) {						
					System.out.println("<--pass-->");
					}
				else {
					System.out.println("<--fail-->");
					}
			}*/
		/*	actData = driver.findElement(By.id("dtlview_Organization Name")).getText();
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
			}	*/		
				
	}

}
