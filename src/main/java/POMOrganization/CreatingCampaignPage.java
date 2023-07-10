package POMOrganization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Webdriver_Utility;

public class CreatingCampaignPage {
	//Initialization
	public CreatingCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy (xpath="//img[@title='Create Campaign...']")
	private WebElement Clickonimg;//plus sign 
	
	@FindBy (name="campaignname")
	private WebElement Campname;//textbox
	
	@FindBy (xpath="//textarea[@class='detailedViewTextBox']/parent::td/parent::tr/following-sibling::tr/td/div/input[1]")
	private WebElement Save2button;
	
	
	@FindBy (xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement plusImgAddProduct;

	
	
	
	
	


	//Getter methods
	public WebElement getClickonimg() {
		return Clickonimg;
	}

	public WebElement getCampname() {
		return Campname;
	}

	public WebElement getSave2button() {
		return Save2button;
	}
	public WebElement getPlusImgAddProduct() {
		return plusImgAddProduct;
	}

	
		
	//Buisness logics
	public void AddProductPlusImg() {
		plusImgAddProduct.click();
	}
	
	
	public void clickOnImg() {
		Clickonimg.click();	
	}
	public void dataToBeFilledCampaign(String campnametextbox) {
		Campname.sendKeys(campnametextbox);
	}
	
	public void save2(WebDriver driver) throws InterruptedException
	{
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.scrolltoParticularElement(driver,Save2button , false);
		Thread.sleep(3000);
		Save2button.click();
	}
}
