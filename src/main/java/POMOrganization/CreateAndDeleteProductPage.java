package POMOrganization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Webdriver_Utility;

public class CreateAndDeleteProductPage {
//Initialization
	public CreateAndDeleteProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//Declaration
	@FindBy (xpath="//img[@title='Create Product...']")
	private WebElement Clickonimg;
	@FindBy (name="productname")
	private WebElement Productnametextbox;
	@FindBy (xpath="//textarea[@class='detailedViewTextBox']/parent::td/parent::tr/following-sibling::tr[2]//td//div/input[1]")
	private WebElement Save2Button;
	@FindBy (xpath="//input[@class='crmbutton small delete']")
	private WebElement DeleteButton;
//Getter methods	
	public WebElement getClickonimg() {
		return Clickonimg;
	}
	public WebElement getProductnametextbox() {
		return Productnametextbox;
	}
	public WebElement getSave2Button() {
		return Save2Button;
	}
	public WebElement getDeleteButton() {
		return DeleteButton;
	}
	//Buisness logics
	public void clickOnImgPlus(){ 
		Clickonimg.click();
	}
	public void dataToBeFilledProduct(String productname){
		Productnametextbox.sendKeys(productname);
	}
	public void save2(WebDriver driver) throws InterruptedException {
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.scrolltoParticularElement(driver, Save2Button, false);
		//Thread.sleep(1000);
		Save2Button.click();
	}
	public void deleteProduct(WebDriver driver){
		DeleteButton.click();
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.alertACCEPT(driver);
	}
	
	
}
