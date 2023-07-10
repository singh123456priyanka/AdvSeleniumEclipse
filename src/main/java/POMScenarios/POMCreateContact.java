package POMScenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Webdriver_Utility;

public class POMCreateContact {

	public POMCreateContact(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Declaration
	@FindBy(xpath="//img[contains(@src,'themes/softed/images/btnL3A')]") 
	private WebElement clickOnImgPlusContact;
	@FindBy(name ="salutationtype") 
	private WebElement salutationdd;
	@FindBy(name="firstname") 
	private WebElement firstNameTxtBox ;
	@FindBy(name="lastname") 
	private WebElement lastNameTxtBox ;
	@FindBy(xpath="(//img[@title='Select'])[1]") 
	private WebElement plusImgOrganization;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	//Getter Method
	public WebElement getClickOnImgPlusContact() {
		return clickOnImgPlusContact;
	}
	public WebElement getSalutationdd() {
		return salutationdd;
	}
	public WebElement getFirstNameTxtBox() {
		return firstNameTxtBox;
	}
	public WebElement getLastNameTxtBox() {
		return lastNameTxtBox;
	}
	public WebElement getPlusImgOrganization() {
		return plusImgOrganization;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	//Buisness Logics
	public void ClickOnImgPlusContact() {
	clickOnImgPlusContact.click();
	}
	
	public void FillDataInContact(String salutation,String fname,String lname ) throws InterruptedException {
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.dropdownVisisbleByTxt(salutationdd, salutation);
		firstNameTxtBox.sendKeys(fname);
		lastNameTxtBox.sendKeys(lname);
		Thread.sleep(700);
		plusImgOrganization.click();
	}
	
	public void Save() {
		saveButton.click();	
	}
	
	
}
