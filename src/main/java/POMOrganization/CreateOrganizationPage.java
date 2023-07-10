package POMOrganization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	//Initialization
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy (xpath ="//img[@title='Create Organization...']")
	private WebElement Clickimg; 
	@FindBy (name="accountname")
	private WebElement Orgname;
	@FindBy (id="phone")
	private WebElement Orgphone;
	@FindBy (id="email1")
	private WebElement Orgemail;
	@FindBy (xpath="//input[@name='button'][1]")
	private WebElement saveButton;
	//Getter methods

	public WebElement getClickimg() {
		return Clickimg;
	}
	public WebElement getOrgname() {
		return Orgname;
	}
	public WebElement getOrgphone() {
		return Orgphone;
	}
	public WebElement getOrgemail() {
		return Orgemail;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}

	
	//Buisness Logics
	public void clickOnPLUSImg()
	{
		Clickimg.click();
	}
	
	public void sendOrgData(String orgName,String phn,String email)
	{
		Orgname.sendKeys(orgName);
		Orgphone.sendKeys(phn);
		Orgemail.sendKeys(email);
	}
	public void save()
	{
		saveButton.click();
	}

}
