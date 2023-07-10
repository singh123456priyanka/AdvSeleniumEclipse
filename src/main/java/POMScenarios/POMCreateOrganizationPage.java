package POMScenarios;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;

public class POMCreateOrganizationPage {

	public POMCreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//declaration
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement clickImgPlusOrganization;
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organizationTxtBox;
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	@FindBy(name="industry")
	private WebElement industryDropDown;
	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement save1;
	
	//getters
	public WebElement getClickImgPlusOrganization() {
		return clickImgPlusOrganization;
	}
	public WebElement getOrganizationTxtBox() {
		return organizationTxtBox;
	}
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	public WebElement getSave1() {
		return save1;
	}
	//buisness logics
	public void ClickImgPlusOrganization() {
		clickImgPlusOrganization.click();
	}

	public void FillDataFrmexcel(String oname,String indData,String typeData) throws InterruptedException, EncryptedDocumentException, IOException {
		Webdriver_Utility wlib = new Webdriver_Utility();
		organizationTxtBox.sendKeys(oname);
		Thread.sleep(1000);
		wlib.dropdownVisisbleByTxt(industryDropDown, indData);
		Thread.sleep(1000);
		wlib.dropdownVisisbleByTxt(typeDropDown,typeData);
		Thread.sleep(1000);
	}
	
	public void Save() {
		save1.click();
	}

}
